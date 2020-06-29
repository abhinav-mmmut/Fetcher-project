package com.abhinav.jersey;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Alien {
		private int id;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		private String name;
		private int points;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getPoints() {
			return points;
		}
		public void setPoints(int points) {
			this.points = points;
		}
		@Override
		public String toString() {
			return "Alien [id=" + id + ", name=" + name + ", points=" + points + "]";
		}
		
		
}
