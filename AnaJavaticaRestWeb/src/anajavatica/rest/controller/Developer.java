package anajavatica.rest.controller;

public class Developer {

	private String name = "";
	private String language = "";

	public Developer(String name, String language) {
		super();
		this.name = name;
		this.language = language;
	}

	public String getName() {
		return name;
	}

	public String getLanguage() {
		return language;
	}

	@Override
	public String toString() {
		return "Developer: " + getName() + ", " + getLanguage();
	}

}
