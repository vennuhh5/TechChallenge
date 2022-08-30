package com.oracle.techchallenge.bean;

import org.apache.commons.lang3.StringUtils;

/**
 * TechChallengeGeozone is the bean, to store the data which is read line by
 * line from the csv file.
 * 
 * @author VENNUHH SUNKISHALAA
 *
 */
public class TechChallengeGeozone {

	private String customerId;
	private String contractId;
	private String geoZone;
	private String teamCode;
	private String projectCode;
	private String buildDuration;

	public TechChallengeGeozone(String customerId, String contractId, String geoZone, String teamCode,
			String projectCode, String buildDuration) {
		this.customerId = customerId;
		this.contractId = contractId;
		this.geoZone = geoZone;
		this.teamCode = teamCode;
		this.projectCode = projectCode;
		this.buildDuration = buildDuration;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getGeoZone() {
		return geoZone;
	}

	public void setGeoZone(String geoZone) {
		this.geoZone = geoZone;
	}

	public String getTeamCode() {
		return teamCode;
	}

	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getBuildDuration() {
		return buildDuration;
	}

	public void setBuildDuration(String buildDuration) {
		this.buildDuration = buildDuration;
	}

	@Override
	public String toString() {
		return "GeoBuild [customerId=" + customerId + ", contractId=" + contractId + ", geoZone=" + geoZone
				+ ", teamCode=" + teamCode + ", projectCode=" + projectCode + ", buildDuration=" + buildDuration + "]";
	}

	@Override
	public int hashCode() {

		return (StringUtils.isNoneEmpty(customerId) && StringUtils.isNoneEmpty(contractId)
				&& StringUtils.isNoneEmpty(geoZone))
						? Integer.parseInt(customerId) + Integer.parseInt(contractId) + geoZone.hashCode()
						: 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(this instanceof TechChallengeGeozone)) {
			return false;
		}
		TechChallengeGeozone geo = (TechChallengeGeozone) obj;

		return this.customerId.equals(geo.getCustomerId()) && this.contractId.equals(geo.getContractId())
				&& this.geoZone.equals(geo.getGeoZone()) && this.teamCode.equals(geo.getTeamCode())
				&& this.projectCode.equals(geo.getProjectCode());
	}
}