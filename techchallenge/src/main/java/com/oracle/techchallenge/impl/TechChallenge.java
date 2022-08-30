package com.oracle.techchallenge.impl;

import java.util.List;

import com.oracle.techchallenge.bean.TechChallengeGeozone;

/**
 * TechChallenge is used to read the content from csv file line by line and to
 * stored in to the bean.
 * 
 * @author VENNUHH SUNKISHALAA
 */
public interface TechChallenge {

	List<TechChallengeGeozone> readTechChallengeFromCSV(String fileName);

	TechChallengeGeozone createTechChallege(String[] metadata);
}