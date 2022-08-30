package com.oracle.techchallenge.util;

import java.util.Arrays;

/**
 * TechChallengeUtil is the utility class.
 * 
 * @author VENNUHH SUNKISHALAA
 */
public class TechChallengeUtil {

	/**
	 * This method is used to print a line.
	 */
	public void printLine() {
		System.out.println("----------------------------------------------------------------------------------- ");
	}

	/**
	 * This method is used to print column headings.
	 * @param column1
	 * @param column2
	 */
	public void printColumn(String column1, String column2) {
		System.out.println("\t----------  ------------ ");
		System.out.println("\t" + column1 + "     " + column2);
		System.out.println("\t----------  ------------ ");
	}
	
	/**
	 * This method is used to find the given str in the enumValues, and return the same.
	 * 
	 * @param <T>
	 * @param enumValues
	 * @param str
	 * @return <T>
	 */
	public <T extends Enum<T>> Enum<T> getEnum(T[] enumValues, String str) {
		return Arrays.stream(enumValues).filter(geos -> str.equalsIgnoreCase(geos.name())).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("No " + str + " constant found "));
	}

}
