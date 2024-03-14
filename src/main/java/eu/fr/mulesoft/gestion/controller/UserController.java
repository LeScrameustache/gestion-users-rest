package eu.fr.mulesoft.gestion.controller;



import java.util.List;

import eu.fr.mulesoft.gestion.entity.Utilisateur;
import eu.fr.mulesoft.gestion.service.IUtilisateurService;
import eu.fr.mulesoft.gestion.service.impl.UtilisateurServiceImpl;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
public class UserController {
	private IUtilisateurService userService = new UtilisateurServiceImpl();
	
	@GET
	@Path("/hello")
	@Produces(MediaType.APPLICATION_JSON)
	public String hello() {
		return "Hello world !";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		System.out.println(userService.listerUtilisateur());
		List<Utilisateur> responseList = userService.listerUtilisateur();
		return Response.ok(responseList).build();
	}
	
	@GET
	@Path("{matricule}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByMatricule(@PathParam("matricule") String matricule) {
		Utilisateur user = userService.rechercherUtilisateurParMatricule(matricule);
		if (user != null) {
			return Response.ok(user).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Utilisateur user) {
		userService.creerUtilisateur(user);
		return Response.status(Response.Status.CREATED).entity(user).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{matricule}")
	public Response updateUser(@PathParam("matricule") String matricule, Utilisateur user) {
		Utilisateur userAModifier = userService.rechercherUtilisateurParMatricule(matricule);
		if (userAModifier !=null) {
			user.setMatricule(userAModifier.getMatricule());
			userService.modifierUtilisateur(user);
			return Response.ok(user).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{matricule}")
	public Response deleteUser(@PathParam("matricule") String matricule) {
		Utilisateur userToDelete = userService.rechercherUtilisateurParMatricule(matricule);
		if (userToDelete!=null) {
			userService.supprimerUtilisateur(userToDelete);
			return Response.noContent().build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
}
