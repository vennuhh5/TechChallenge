package com.oracle.techchallenge.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.oracle.techchallenge.bean.TechChallengeGeozone;
import com.oracle.techchallenge.util.TechChallengeUtil;

/**
 * TechChallengeReportsImpl is the implementation class of TechChallengeReports,
 * is used to generate the reports.
 * 
 * @author VENNUHH SUNKISHALAA
 */
public class TechChallengeReportsImpl implements TechChallengeReports {
	TechChallengeUtil util = new TechChallengeUtil();

	/**
	 * This method is used to print the complete Data.
	 * 
	 * @param geoZones
	 */
	@Override
	public void printData(List<TechChallengeGeozone> geoZones) {
		System.out.println("\n............Tech Challenge Data............\n");
		util.printLine();
		System.out.println("CustomerId | ContractId | GeoZone | TeamCode  | ProjectCode    | BuildDuration");
		util.printLine();
		for (TechChallengeGeozone geobuild : geoZones) {
			System.out.format("%10s %10s %11s %12s %15s %7s", geobuild.getCustomerId(), geobuild.getContractId(),
					geobuild.getGeoZone(), geobuild.getTeamCode(), geobuild.getProjectCode(),
					geobuild.getBuildDuration());
			System.out.println();
		}

		util.printLine();
	}

	/**
	 * This method is used to get "The Number of Unique CustomerId for each
	 * ContractId".
	 * 
	 * @param geoZones
	 */
	@Override
	public void uniqueCustomerIdCountbyContractId(List<TechChallengeGeozone> geoZones) {
		// (1) To get :: The Number of Unique CustomerId for each ContractId

		Map<String, Integer> customerIdCountbyContractIdUniqueMap = geoZones.stream()
				.collect(Collectors.groupingBy(TechChallengeGeozone::getContractId,
						Collectors.mapping(TechChallengeGeozone::getCustomerId,
								Collectors.collectingAndThen(Collectors.toSet(), Set::size))));

		System.out.println("\n(1) The Number of Unique CustomerId for each ContractId :: ");
		util.printColumn("ContractId", "CustomerId  ");

		customerIdCountbyContractIdUniqueMap.entrySet().forEach(entry -> {
			System.out.println("\t" + entry.getKey() + "\t\t" + entry.getValue());
		});

		util.printLine();
	}

	/**
	 * This method is used to get "The Number of Unique CustomerId for each
	 * GeoZone".
	 * 
	 * @param geoZones
	 */
	@Override
	public void uniqueCustomerIdCountByGeoZone(List<TechChallengeGeozone> geoZones) {
		// (2) To get :: The Number of Unique CustomerId for each GeoZone

		Map<String, Integer> customerIdCountByGeoZoneMap = geoZones.stream()
				.collect(Collectors.groupingBy(TechChallengeGeozone::getGeoZone,
						Collectors.mapping(TechChallengeGeozone::getCustomerId,
								Collectors.collectingAndThen(Collectors.toSet(), Set::size))));

		System.out.println("\n(2) The Number of Unique CustomerId for each GeoZone :: ");
		util.printColumn("GeoZone", "CustomerId  ");

		customerIdCountByGeoZoneMap.entrySet().forEach(entry -> {
			System.out.println("\t" + entry.getKey() + "\t\t" + entry.getValue());
		});

		util.printLine();
	}

	/**
	 * This method is used to get "The Average buildDuration for each GeoZone".
	 * 
	 * @param geoZones
	 */
	@Override
	public void avgBuildDurationByGeozone(List<TechChallengeGeozone> geoZones) {
		// (3) To get :: The Average buildDuration for each GeoZone
		Map<String, Double> avgBuildDurationByGeozoneMap = geoZones.stream()
				.collect(Collectors.groupingBy(TechChallengeGeozone::getGeoZone, Collectors.averagingInt(obj -> Integer
						.parseInt(obj.getBuildDuration().substring(0, obj.getBuildDuration().length() - 1)))));

		System.out.println("\n(3) The average buildDuration group by GeoZone :: ");
		util.printColumn("GeoZone", "Average Build Duration  ");

		avgBuildDurationByGeozoneMap.entrySet().forEach(entry -> {
			System.out.println("\t" + entry.getKey() + "\t    " + String.format("%.2f", entry.getValue()));
		});

		util.printLine();
	}

	/**
	 * This method is used to get "The list of unique customerId for each GeoZone".
	 * 
	 * @param geoZones
	 */
	@Override
	public void uniqueCustomerIdByGeozone(List<TechChallengeGeozone> geoZones) {
		// (4) To Get :: The list of unique customerId for each GeoZone
		Map<String, Set<String>> uniqueCustomerIdByGeozoneMap = geoZones.stream().collect(Collectors.groupingBy(
				TechChallengeGeozone::getGeoZone,
				Collectors.mapping(TechChallengeGeozone::getCustomerId, Collectors.toCollection(HashSet::new))));

		System.out.println("\n(4) The list of unique customerId for each GeoZone:: ");
		util.printColumn("GeoZone", "CutomerId  ");

		uniqueCustomerIdByGeozoneMap.entrySet().forEach(entry -> {
			System.out.println("\t" + entry.getKey() + "\t    " + entry.getValue());
		});

		util.printLine();
	}

}
