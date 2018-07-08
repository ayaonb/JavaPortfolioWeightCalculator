package com.portfoliocalculator.service;

import com.portfoliocalculator.exception.ExceptionConstant;
import com.portfoliocalculator.exception.ValidationFailException;
import com.portfoliocalculator.util.ValidationUtil;

public class ValidationService {
    
	/**
	 * @param parentName
	 * @param childName
	 * @param startingMarketValue
	 * @throws ValidationFailException
	 * Validates all the possible input combination as as expected else throws an exception
	 */
	public static void validateInput(String parentName,String childName,String startingMarketValue) throws ValidationFailException
	{
		if(ValidationUtil.isBlank(parentName) )
		{
			throw new ValidationFailException(ExceptionConstant.EMPTY_NAME_PARENT+" for "+ "Fund [ParentName=" + parentName + ",Child Name="+childName+", marketValue=" + startingMarketValue + "]");
			
		}
		
		if( ValidationUtil.isBlank(childName))
		{
			throw new ValidationFailException(ExceptionConstant.EMPTY_NAME_CHILD+" for "+ "Fund [ParentName=" + parentName + ",Child Name="+childName+", marketValue=" + startingMarketValue + "]");
			
		}
		
		if(ValidationUtil.isBlank(startingMarketValue))
		{
			throw new ValidationFailException(ExceptionConstant.EMPTY_STARTING_MARKET_VALUE+" for "+ "Fund [ParentName=" + parentName + ",Child Name="+childName+", marketValue=" + startingMarketValue + "]");
		}
		if(!ValidationUtil.isValidNumber(startingMarketValue))
		{
			throw new ValidationFailException(ExceptionConstant.INVALID_MARKET_VALUE+" for "+ "Fund [ParentName=" + parentName + ",Child Name="+childName+", marketValue=" + startingMarketValue + "]");
		}
		
	}

	/**
	 * @param parentName
	 * @param childName
	 * @param startingMarketValue
	 * @param endingMarketValue
	 * @throws ValidationFailException
	 * Validates the optional ending market value is as expected else throws exception
	 */
	public static void validateEndMarketValue(String parentName, String childName, Double startingMarketValue,
			String endingMarketValue) throws ValidationFailException {
		if(ValidationUtil.isBlank(endingMarketValue))
		{
			throw new ValidationFailException(ExceptionConstant.EMPTY_ENDING_MARKET_VALUE+" for "+ "Fund [ParentName=" + parentName + ",Child Name="+childName+", marketValue=" + startingMarketValue + "]");
		}
		if(!ValidationUtil.isValidNumber(endingMarketValue))
		{
			throw new ValidationFailException(ExceptionConstant.INVALID_ENDING_MARKET_VALUE+" for "+ "Fund [ParentName=" + parentName + ",Child Name="+childName+", marketValue=" + startingMarketValue + "]");
		}
		
	}
}
