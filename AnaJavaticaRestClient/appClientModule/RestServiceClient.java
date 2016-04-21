
import java.net.MalformedURLException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import anajavatica.rest.controller.Developer;

public class RestServiceClient {

	private Client buildClient() {
		Client client = ClientBuilder.newClient();
		client.register(com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider.class);
		return client;
	}

	public void addDeveloper() throws MalformedURLException {
		Client client = buildClient();
		WebTarget target = client.target("http://localhost:8080/AnaJavaticaRestWeb/rest/developerRestService/");
		Developer newDeveloper = new Developer("Developer1", "Java");
		Invocation.Builder builderLogin = target.request(MediaType.APPLICATION_JSON);
		Response response = builderLogin.post(Entity.json(newDeveloper));
		System.out.println("addDeveloper: " + response.readEntity(Boolean.class));
	}

	public void updateDeveloper() throws MalformedURLException {
		Client client = buildClient();
		WebTarget target = client.target("http://localhost:8080/AnaJavaticaRestWeb/rest/developerRestService/");
		Developer updateDeveloper = new Developer("Developer1", "JavaFX");
		Invocation.Builder builderLogin = target.request(MediaType.APPLICATION_JSON);
		Response response = builderLogin.put(Entity.json(updateDeveloper));
		System.out.println("updateDeveloper: " + response.readEntity(Boolean.class));
	}

	public void getAllDevelopers() throws MalformedURLException {
		Client client = buildClient();
		WebTarget target = client.target("http://localhost:8080/AnaJavaticaRestWeb/rest/developerRestService/");
		Invocation.Builder builderLogin = target.request(MediaType.APPLICATION_JSON);
		Response response = builderLogin.get();
		Integer allDeveloperListSize = response.readEntity(Integer.class);
		System.out.println(allDeveloperListSize);
	}

	public void getDeveloper() throws MalformedURLException {
		Client client = buildClient();
		WebTarget target = client.target("http://localhost:8080/AnaJavaticaRestWeb/rest/developerRestService/")
				.path("/getDeveloper");
		Invocation.Builder builderLogin = target.request(MediaType.APPLICATION_JSON);
		Developer developer = builderLogin.get(Developer.class);
		if (developer != null)
			System.out.println("getDeveloper: " + developer.toString());
		else
			System.out.println("Developer is not exist!");
	}

	public static void main(String[] args) throws MalformedURLException {

		RestServiceClient restClient = new RestServiceClient();
		restClient.addDeveloper();
		restClient.getAllDevelopers();
		restClient.updateDeveloper();
		restClient.getDeveloper();

	}

}
