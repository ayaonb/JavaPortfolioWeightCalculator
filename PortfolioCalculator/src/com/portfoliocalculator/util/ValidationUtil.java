package com.portfoliocalculator.util;

public class ValidationUtil {
    
	/**
	 * @param marketValue
	 * @return true if the marketValuePassed Is Valid Number else false
	 */
	public static boolean isValidNumber(String marketValue)
	{
		return marketValue.matches("^[1-9]\\d*(\\.\\d+)?$");
	}
	
	/**
	 * @param fundName
	 * @return true if FundName is a Valid Name else false
	 */
	public static boolean isValidName(String fundName)
	{
		return fundName.matches("^[\\p{L} .'-]+$");
	}
	
	
	/**
	 * @param fundNameOrMarketValue
	 * @return true if Fund Name or Market Value Is Blank or Null else false
	 */
	public static boolean isBlank(String fundNameOrMarketValue)
	{
		return (fundNameOrMarketValue==null || fundNameOrMarketValue.trim().isEmpty());
	}
	
	
}
