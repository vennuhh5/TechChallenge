package com.oracle.techchallenge;

import java.util.List;

import com.oracle.techchallenge.bean.TechChallengeGeozone;
import com.oracle.techchallenge.impl.TechChallenge;
import com.oracle.techchallenge.impl.TechChallengeImpl;
import com.oracle.techchallenge.impl.TechChallengeReports;
import com.oracle.techchallenge.impl.TechChallengeReportsImpl;

/**
 * TechChallengeMain is the main class, all operations took place from here.
 * 
 * @author VENNUHH SUNKISHALAA
 */

public class TechChallengeMain {

	public static void main(String... args) {

		TechChallenge techChallenge = new TechChallengeImpl();

		List<TechChallengeGeozone> geoZones = techChallenge.readTechChallengeFromCSV("resources/TechChallenge.csv");
		getTechChallegeReports(geoZones);

	}

	/**
	 * This method consist of all the TechChallengeReports call.
	 * 
	 * @param geoZones
	 */
	public static void getTechChallegeReports(List<TechChallengeGeozone> geoZones) {

		TechChallengeReports techChallengeReports = new TechChallengeReportsImpl();

		// To Print all the person read from CSV file
		techChallengeReports.printData(geoZones);

		// (1) To get :: The Number of Unique CustomerId for each ContractId
		techChallengeReports.uniqueCustomerIdCountbyContractId(geoZones);

		// (2) To get :: The Number of Unique CustomerId for each GeoZone
		techChallengeReports.uniqueCustomerIdCountByGeoZone(geoZones);

		// (3) To get :: The Average buildDuration for each GeoZone
		techChallengeReports.avgBuildDurationByGeozone(geoZones);

		// (4) To Get :: The list of unique customerId for each GeoZone
		techChallengeReports.uniqueCustomerIdByGeozone(geoZones);

	}

}
