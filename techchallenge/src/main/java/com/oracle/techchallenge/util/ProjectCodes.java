package com.oracle.techchallenge.util;

public enum ProjectCodes {
	PROJECTAPPLE("ProjectApple"), PROJECTBANANA("ProjectBanana"), PROJECTCARROT("ProjectCarrot"),
	PROJECTDATE("ProjectDate"), PROJECTEGG("ProjectEgg");

	private final String projectCodeValue;

	ProjectCodes(String projectCodeValue) {
		this.projectCodeValue = projectCodeValue;
	}

	public String getProjectCodeValue() {
		return projectCodeValue;
	}
}
