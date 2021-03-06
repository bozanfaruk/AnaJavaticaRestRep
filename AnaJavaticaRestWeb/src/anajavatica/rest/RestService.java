package anajavatica.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import anajavatica.rest.controller.Developer;
import anajavatica.rest.controller.RestServiceController;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/developerRestService")
@SuppressWarnings("javadoc")
public class RestService {

	private RestServiceController controller = new RestServiceController();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public int getAllDevelopers() {
		return getController().getDeveloperList().size();
	}

	@GET
	@Path("getDeveloper/{name}/{language}")
	public Developer getDeveloper(@PathParam("name") String name, @PathParam("language") String language) {
		return getController().getDeveloper(name, language);
	}

	@POST
	public boolean addDeveloper(Developer developer) {
		return getController().addDeveloper(developer);
	}

	@PUT
	public boolean updateDeveloper(Developer developer) {
		return getController().updateDeveloper(developer);
	}

	private RestServiceController getController() {
		return controller;
	}

}
