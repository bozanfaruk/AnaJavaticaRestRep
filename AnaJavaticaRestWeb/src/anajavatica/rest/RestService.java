package anajavatica.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import anajavatica.rest.controller.Developer;
import anajavatica.rest.controller.RestServiceController;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("developerRestService")
public class RestService {

	private RestServiceController controller = new RestServiceController();

	@GET
	public List<Developer> getAllDevelopers() {
		return getController().getDeveloperList();
	}

	@GET
	@Path("getDeveloper")
	public Developer getDeveloper(@PathParam("name") String name, @PathParam("language") String language) {
		return getController().getDeveloper(name, language);
	}

	@POST
	public boolean addDeveloper(@QueryParam("developer") Developer developer) {
		return getController().addDeveloper(developer);
	}

	@PUT
	public boolean updateDeveloper(Developer developer) {
		return getController().updateDeveloper(developer);
	}

	@DELETE
	public int deleteMethod(Developer developer) {
		return getController().deleteDeveloper(developer);
	}

	private RestServiceController getController() {
		return controller;
	}

}
