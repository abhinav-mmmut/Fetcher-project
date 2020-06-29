package com.abhinav.jersey;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource {
	AlienRepository repo = new AlienRepository();

	@POST
	@Path("create")
	public void createAlien(Alien a) {
		System.out.println("createAlien method called");
		repo.createAlien(a);
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Alien> getAliens() {
		System.out.println("getAliens method called");
		return repo.getAliens();
	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Alien getAlien(@PathParam("id") int id) {
		System.out.println("getAlien method called");
		return repo.getAlien(id);
	}

	@PUT
	@Path("update")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public void updateAlien(Alien a) {
		System.out.println("getAlien method called");
		Alien A = repo.getAlien(a.getId());
		if (A.getId() != 0) {
			repo.updateAlien(a);
		} else {
			repo.createAlien(a);
		}
	}

	@DELETE
	@Path("kill/{id}")
	public Alien deleteAlien(@PathParam("id") int id) {
		System.out.println("deleteAlien method called");
		Alien a = repo.getAlien(id);
		if (a.getId() != 0)
			repo.deleteAlien(id);
		return a;

	}
}
