package com.abhinav.jersey;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class AlienRepository {
	Connection con = null;

	public AlienRepository() {

		String url = "jdbc:mysql://localhost:3306/restdb";
		String user = "root";
		String password = "qwerty";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void createAlien(Alien a) {

		try {
			String sql = "INSERT INTO ALIENS VALUES (?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, a.getId());
			st.setString(2, a.getName());
			st.setInt(3, a.getPoints());
			st.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public List<Alien> getAliens() {
		List<Alien> aliens = new ArrayList<Alien>();
		String sql = "SELECT * FROM ALIENS";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Alien a = new Alien();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));
				aliens.add(a);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return aliens;

	}

	public Alien getAlien(int id) {
		Alien a = new Alien();
		String sql = "SELECT * FROM ALIENS WHERE ID=" + id;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {

				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return a;
	}

	public void updateAlien(Alien a) {
		String sql = "UPDATE ALIENS SET NAME=?, POINTS =? WHERE ID=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, a.getName());
			st.setInt(2, a.getPoints());
			st.setInt(3, a.getId());
			st.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void deleteAlien(int id) {
		String sql = "DELETE FROM ALIENS WHERE ID=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
