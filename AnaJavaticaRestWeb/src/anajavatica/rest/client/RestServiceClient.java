package anajavatica.rest.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import anajavatica.rest.controller.Developer;

public class RestServiceClient {

	private Client buildClient() {
		Client client = ClientBuilder.newClient();
		return client;
	}

	public void addDeveloper() {
		Client client = buildClient();
		WebTarget target = client.target("http://localhost:8080/developerRestService");
		Developer newDeveloper = new Developer("Developer1", "Java");
		Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.json(newDeveloper));
		System.out.println("addDeveloper: " + response.readEntity(Boolean.class));
	}

	public void updateDeveloper() {
		Client client = buildClient();
		WebTarget target = client.target("http://localhost:8080/developerRestService");
		Developer updateDeveloper = new Developer("Developer1", "JavaFX");
		Response response = target.request(MediaType.APPLICATION_JSON).put(Entity.json(updateDeveloper));
		System.out.println("updateDeveloper: " + response.readEntity(Boolean.class));
	}

	public void deleteDeveloper() {
		Client client = buildClient();
		WebTarget target = client.target("http://localhost:8080/developerRestService");
		Developer deleteDeveloper = new Developer("Developer1", "JavaFX");
		Response response = target.request(MediaType.APPLICATION_JSON).put(Entity.json(deleteDeveloper));
		System.out.println("deleteDeveloper: " + response.readEntity(Integer.class));
	}

	public void getAllDevelopers() {
		Client client = buildClient();
		WebTarget target = client.target("http://localhost:8080/developerRestService");
		List<Developer> allDevelopers = target.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Developer>>() {
				});
		System.out.println("getAllDevelopers: " + allDevelopers.size());
	}

	public void getDeveloper() {
		Client client = buildClient();
		WebTarget target = client.target("http://localhost:8080/developerRestService").path("/getDeveloper");
		Developer developer = target.request(MediaType.APPLICATION_JSON).get(Developer.class);
		System.out.println("getDeveloper: " + developer.toString());
	}

	public static void main(String[] args) {
		RestServiceClient restClient = new RestServiceClient();
		restClient.getAllDevelopers();
	}

}
