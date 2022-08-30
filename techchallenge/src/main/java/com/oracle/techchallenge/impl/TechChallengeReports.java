package com.oracle.techchallenge.impl;

import java.util.List;

import com.oracle.techchallenge.bean.TechChallengeGeozone;

/**
 * TechChallengeReports is used to generate the reports.
 * 
 * @author VENNUHH SUNKISHALAA
 */
public interface TechChallengeReports {

	public void printData(List<TechChallengeGeozone> geoZones);

	public void uniqueCustomerIdCountbyContractId(List<TechChallengeGeozone> geoZones);

	public void uniqueCustomerIdCountByGeoZone(List<TechChallengeGeozone> geoZones);

	public void avgBuildDurationByGeozone(List<TechChallengeGeozone> geoZones);

	public void uniqueCustomerIdByGeozone(List<TechChallengeGeozone> geoZones);

}
