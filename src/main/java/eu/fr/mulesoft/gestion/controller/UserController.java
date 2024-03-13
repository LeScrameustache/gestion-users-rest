package eu.fr.mulesoft.gestion.controller;

import jakarta.ws.rs.Path;

@Path("/users")
public class UserController {
	
	@GET
	
	public String hello() {
		return "Hello world !";
	}
}
