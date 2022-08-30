package com.oracle.techchallenge.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.oracle.techchallenge.bean.TechChallengeGeozone;
import com.oracle.techchallenge.util.TechChallengeUtil;

/**
 * TechChallengeImpl is implementation class of TechChallenge.
 * 
 * @author VENNUHH SUNKISHALAA
 */
public class TechChallengeImpl implements TechChallenge {

	TechChallegeTypes enumOperations = new TechChallegeTypesImpl();
	TechChallengeUtil util = new TechChallengeUtil();

	/**
	 * To read the content from csv file and stored in List.
	 * 
	 * @param fileName
	 * @return List<TechChallengeGeozone>
	 */
	@Override
	public List<TechChallengeGeozone> readTechChallengeFromCSV(String fileName) {

		List<TechChallengeGeozone> geoZones = new ArrayList<>();
		Path pathToFile = Paths.get(fileName);
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {

			String line = br.readLine();
			while (StringUtils.isNoneEmpty(line)) {
				String[] attributes = line.split(",");
				TechChallengeGeozone geozoneBean = createTechChallege(attributes);
				geoZones.add(geozoneBean);
				line = br.readLine();
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return geoZones;
	}

	/**
	 * To set the records into TechChallengeGeozone bean.
	 * 
	 * @param metadata
	 * @return TechChallengeGeozone
	 */
	@Override
	public TechChallengeGeozone createTechChallege(String[] metadata) {

		String customerId = StringUtils.EMPTY;
		String contractId = StringUtils.EMPTY;
		String geoZone = StringUtils.EMPTY;
		String teamCode = StringUtils.EMPTY;
		String projectCode = StringUtils.EMPTY;
		String buildDuration = StringUtils.EMPTY;

		// pattern for CustomerId
		if (StringUtils.isNoneEmpty(metadata[0]) && Pattern.matches("\\b\\d{7}\\b", metadata[0])) {
			customerId = metadata[0];
		}

		// pattern for contractId
		if (StringUtils.isNoneEmpty(metadata[1]) && Pattern.matches("\\b\\d{4}\\b", metadata[1])) {
			contractId = metadata[1];
		}

		String geoZonevalue = enumOperations.geoZoneValue(metadata[2]);
		if (StringUtils.isNoneEmpty(geoZonevalue)) {
			geoZone = geoZonevalue;
		}

		String teamCodevalue = enumOperations.teamCode(metadata[3]);
		if (StringUtils.isNoneEmpty(teamCodevalue)) {
			teamCode = teamCodevalue;
		}

		String projectCodevalue = enumOperations.projectCode(metadata[4]);
		if (StringUtils.isNoneEmpty(projectCodevalue)) {
			projectCode = projectCodevalue;
		}

		// patterns fort buildDuration
		if (StringUtils.isNoneEmpty(metadata[5]) && Pattern.matches("\\b\\w{5}s?\\b", metadata[5])) {
			buildDuration = metadata[5];
		}

		if (StringUtils.isNoneEmpty(customerId) && StringUtils.isNoneEmpty(contractId)
				&& StringUtils.isNoneEmpty(geoZone) && StringUtils.isNoneEmpty(teamCode)
				&& StringUtils.isNoneEmpty(projectCode) && StringUtils.isNoneEmpty(buildDuration)) {
			return new TechChallengeGeozone(customerId, contractId, geoZone, teamCode, projectCode, buildDuration);
		}

		return null;
	}

}