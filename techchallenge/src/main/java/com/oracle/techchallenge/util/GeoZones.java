package com.oracle.techchallenge.util;

public enum GeoZones {
	US_EAST("us_east"), US_WEST("us_west"), EU_WEST("eu_west");

	private final String geoZoneValue;

	GeoZones(String v) {
		geoZoneValue = v;
	}

	public String getGeoZoneValue() {
		return geoZoneValue;
	}

}
