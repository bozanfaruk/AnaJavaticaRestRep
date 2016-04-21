package anajavatica.rest.controller;

import java.util.ArrayList;
import java.util.List;

public class RestServiceController {

	private List<Developer> developerList = new ArrayList<>();

	public List<Developer> getDeveloperList() {
		return developerList;
	}

	public Developer getDeveloper(String name, String language) {
		for (Developer d : getDeveloperList()) {
			if (d.getName().equals(name) && d.getLanguage().equals(language))
				return d;
		}
		return null;
	}

	public boolean addDeveloper(Developer developer) {
		boolean result = true;
		for (Developer d : getDeveloperList()) {
			if (d.getName().equals(developer.getName()) && d.getLanguage().equals(developer.getLanguage())) {
				result = false;
				break;
			}
		}
		if (result)
			getDeveloperList().add(developer);
		return result;
	}

	public boolean updateDeveloper(Developer developer) {
		boolean result = false;
		for (int i = 0; i < getDeveloperList().size(); i++) {
			Developer d = getDeveloperList().get(i);
			if (d.getName().equals(developer.getName())) {
				getDeveloperList().set(i, developer);
				result = true;
				break;
			}
		}
		return result;
	}

}
