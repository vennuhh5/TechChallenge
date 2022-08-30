package com.oracle.techchallenge.impl;

import com.oracle.techchallenge.util.GeoZones;
import com.oracle.techchallenge.util.ProjectCodes;
import com.oracle.techchallenge.util.TeamCodes;
import com.oracle.techchallenge.util.TechChallengeUtil;

/**
 * TechChallegeTypesImpl is implementation class of TechChallegeTypes.
 * 
 * @author VENNUHH SUNKISHALAA
 */

public class TechChallegeTypesImpl implements TechChallegeTypes {

	TechChallengeUtil util = new TechChallengeUtil();

	/**
	 * To get geoZoneValue based on the given String input.
	 * 
	 * @param geoZoneValue
	 * @return String
	 */
	@Override
	public String geoZoneValue(String geoZoneValue) {
		switch ((GeoZones) util.getEnum(GeoZones.values(), geoZoneValue)) {
		case EU_WEST:
			return GeoZones.EU_WEST.getGeoZoneValue();
		case US_EAST:
			return GeoZones.US_EAST.getGeoZoneValue();
		case US_WEST:
			return GeoZones.US_WEST.getGeoZoneValue();
		default:
			throw new IllegalArgumentException("Invalid GeoZone : " + geoZoneValue);
		}
	}

	/**
	 * To get projectCodeValue based on the given String.
	 * 
	 * @param projectCodeValue
	 * @return String
	 */
	@Override
	public String projectCode(String projectCodeValue) {

		switch ((ProjectCodes) util.getEnum(ProjectCodes.values(), projectCodeValue)) {
		case PROJECTAPPLE:
			return ProjectCodes.PROJECTAPPLE.getProjectCodeValue();
		case PROJECTBANANA:
			return ProjectCodes.PROJECTBANANA.getProjectCodeValue();
		case PROJECTCARROT:
			return ProjectCodes.PROJECTCARROT.getProjectCodeValue();
		case PROJECTDATE:
			return ProjectCodes.PROJECTDATE.getProjectCodeValue();
		case PROJECTEGG:
			return ProjectCodes.PROJECTEGG.getProjectCodeValue();
		default:
			throw new IllegalArgumentException("Invalid ProjectCode : " + projectCodeValue);
		}
	}

	/**
	 * To get teamCodeValue based on the given String.
	 * 
	 * @param teamCodeValue
	 * @return String
	 */
	@Override
	public String teamCode(String teamCodeValue) {
		switch ((TeamCodes) util.getEnum(TeamCodes.values(), teamCodeValue)) {
		case REDTEAM:
			return TeamCodes.REDTEAM.getTeamCodeValue();
		case BLUETEAM:
			return TeamCodes.BLUETEAM.getTeamCodeValue();
		case YELLOWTEAM3:
			return TeamCodes.YELLOWTEAM3.getTeamCodeValue();
		default:
			throw new IllegalArgumentException("Invalid TeamCode : " + teamCodeValue);
		}
	}

}
