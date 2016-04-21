package anajavatica.rest.controller;

import java.io.Serializable;

public class Developer implements Serializable {

	private static final long serialVersionUID = 1L;
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

	public void setName(String name) {
		this.name = name;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "Developer: " + getName() + ", " + getLanguage();
	}

}
