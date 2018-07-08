package com.test.portfoliocalculator.testcases;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.portfoliocalculator.domain.CalculatedWeightResult;
import com.portfoliocalculator.exception.ValidationFailException;
import com.portfoliocalculator.service.PortCalService;

public class TestValidationOfFunds { 
 
private String inputBlankFundNameFileName;
private String inputBlankMarketValueFileName;
private String inputInvalidMarketValueFileName;
private String inputBlankEndingMarketValueFileName;
private String inputInvalidEndingMarketValueFileName;
private String inputDuplicateFundNameFileName;




@Before
public void initialize() {
	inputBlankFundNameFileName=System.getProperty("fileNameBlankFundName");
	inputBlankMarketValueFileName=System.getProperty("fileNameBlankMarketValue");
	inputInvalidMarketValueFileName=System.getProperty("fileNameInvalidMarketValue");
	inputBlankEndingMarketValueFileName=System.getProperty("fileNameBlankEndingMarketValue");
	inputInvalidEndingMarketValueFileName=System.getProperty("fileNameInvalidEndingMarketValue");
	inputDuplicateFundNameFileName=System.getProperty("fileNameDuplicateFundName");
}

/**
 * Test for Validating Blank fund name 
 * @throws IOException 
 */
@Test
public void validateBlankFundNameTest() throws IOException  {
	  	
	  boolean validationEx = false;
	  PortCalService testInput=new PortCalService();
	  try {
	  testInput.crateTreeAndValidateInput(inputBlankFundNameFileName);
	  }
	  catch(ValidationFailException e)
	  {
		  validationEx=true;
	  }
	
	     assertTrue("Fund Name Should Not Be Empty",validationEx);
	   
	   }
/**
 * Test for Validating Blank Market Value
 * @throws IOException 
 */
@Test
public void validateBlankMarketValueTest() throws IOException  {
	  	
	  boolean validationEx = false;
	  PortCalService testInput=new PortCalService();
	  try {
	  testInput.crateTreeAndValidateInput(inputBlankMarketValueFileName);
	  }
	  catch(ValidationFailException e)
	  {
		  validationEx=true;
	  }
	
	     assertTrue("Market Value Should Not Be Empty",validationEx);
	   
	}

/**
 * Test for Validating Invalid Market Value
 * @throws IOException 
 */
@Test
public void validateInvalidMarketValueTest() throws IOException  {
	  	
	  boolean validationEx = false;
	  PortCalService testInput=new PortCalService();
	  try {
	  testInput.crateTreeAndValidateInput(inputInvalidMarketValueFileName);
	  }
	  catch(ValidationFailException e)
	  {
		  validationEx=true;
	  }
	
	     assertTrue("Market Value Should Be A Number",validationEx);
	   
	}


/**
 * Test for Validating Blank Ending Market Value
 * @throws IOException 
 */
@Test
public void validateEndingBlankMarketValueTest() throws IOException  {
	  	
	  boolean validationEx = false;
	  PortCalService testInput=new PortCalService();
	  try {
	  testInput.crateTreeAndValidateInput(inputBlankEndingMarketValueFileName);
	  }
	  catch(ValidationFailException e)
	  {
		  validationEx=true;
	  }
	
	     assertTrue("Ending Market Value Should Not Be Empty",validationEx);
	   
	}

/**
 * Test for Validating Invalid Ending Market Value
 * @throws IOException 
 */
@Test
public void validateInvalidEndingMarketValueTest() throws IOException  {
	  	
	  boolean validationEx = false;
	  PortCalService testInput=new PortCalService();
	  try {
	  testInput.crateTreeAndValidateInput(inputInvalidEndingMarketValueFileName);
	  }
	  catch(ValidationFailException e)
	  {
		  validationEx=true;
	  }
	
	     assertTrue("Ending Market Value Should Be A Number",validationEx);
	   
	}
	  

/**
 * Test for Validating Duplicate Fund Name
 * @throws IOException 
 */
@Test
public void validateDuplicateFundNameTest() throws IOException  {
	  	
	  boolean validationEx = false;
	  PortCalService testInput=new PortCalService();
	  try {
	  testInput.crateTreeAndValidateInput(inputDuplicateFundNameFileName);
	  }
	  catch(ValidationFailException e)
	  {
		  validationEx=true;
	  }
	
	     assertTrue("Duplicate Fund Entry In The List Please Correct It",validationEx);
	   
	}
	  
   }






