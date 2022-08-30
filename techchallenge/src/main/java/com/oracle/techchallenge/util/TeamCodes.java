package com.oracle.techchallenge.util;

public enum TeamCodes {
	REDTEAM("RedTeam"), BLUETEAM("BlueTeam"), YELLOWTEAM3("YellowTeam3");

	private final String teamCodeValue;

	TeamCodes(String teamCodeValue) {
		this.teamCodeValue = teamCodeValue;
	}

	public String getTeamCodeValue() {
		return teamCodeValue;
	}
}
