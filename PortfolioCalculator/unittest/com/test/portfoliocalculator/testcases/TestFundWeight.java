package com.test.portfoliocalculator.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.portfoliocalculator.domain.CalculatedWeightResult;
import com.portfoliocalculator.exception.ValidationFailException;
import com.portfoliocalculator.service.PortCalService;

public class TestFundWeight { 
 
private String inputInOrderFileName;
private String inputInAnyOrderFileName;



@Before
public void initialize() {
	inputInOrderFileName=System.getProperty("fileNameInOrder");
	inputInAnyOrderFileName=System.getProperty("fileNameInAnyOrder");
}

/**
 * Test for calculating fund weight in proper input order
 * @throws ValidationFailException 
 * @throws IOException 
 */
@Test
public void calculateFundWegightInOrderTest() throws IOException, ValidationFailException  {
	  List<CalculatedWeightResult> expectedResultList=new ArrayList<>();
	  expectedResultList.add(new CalculatedWeightResult("A", "D", 0.167));
	  expectedResultList.add(new CalculatedWeightResult("A", "E", 0.083));
	  expectedResultList.add(new CalculatedWeightResult("A", "F", 0.083));
	  expectedResultList.add(new CalculatedWeightResult("A", "G", 0.333));
	  expectedResultList.add(new CalculatedWeightResult("A", "H", 0.333));
	  expectedResultList.add(new CalculatedWeightResult("B", "D", 0.500));
	  expectedResultList.add(new CalculatedWeightResult("B", "E", 0.250));
	  expectedResultList.add(new CalculatedWeightResult("B", "F", 0.250));
	  expectedResultList.add(new CalculatedWeightResult("C", "G", 0.500));
	  expectedResultList.add(new CalculatedWeightResult("C", "H", 0.500));
	
	  PortCalService testInput=new PortCalService();
	  System.out.println("Output For Test Results With Input In Proper Order");
	  testInput.crateTreeAndValidateInput(inputInOrderFileName);
	  testInput.calulateFundWeight();
	  System.out.println("------------------------------------------");
	  int rownum=0;
	   for(CalculatedWeightResult eachExpectedResult:expectedResultList)
	   {
	     assertTrue("Fund Weight Did not Match Expected Result Expected: "+eachExpectedResult.toString() + "But Got "+testInput.fundWeightList.get(rownum).toString(),(eachExpectedResult.toString().equalsIgnoreCase(testInput.fundWeightList.get(rownum).toString())));
	     rownum++;
	   }
	  
    }


/**
 * Test for calculating fund weight in any input order
 * @throws ValidationFailException 
 * @throws IOException 
 */
@Test
public void calculateFundWegightInAnyOrderTest() throws IOException, ValidationFailException  {
	  List<CalculatedWeightResult> expectedResultList=new ArrayList<>();
	  expectedResultList.add(new CalculatedWeightResult("A", "H", 0.333));
	  expectedResultList.add(new CalculatedWeightResult("A", "G", 0.333));
	  expectedResultList.add(new CalculatedWeightResult("A", "F", 0.083));
	  expectedResultList.add(new CalculatedWeightResult("A", "D", 0.167));
	  expectedResultList.add(new CalculatedWeightResult("A", "E", 0.083));
	  expectedResultList.add(new CalculatedWeightResult("B", "F", 0.250));	 
	  expectedResultList.add(new CalculatedWeightResult("B", "D", 0.500));
	  expectedResultList.add(new CalculatedWeightResult("B", "E", 0.250));
	  expectedResultList.add(new CalculatedWeightResult("C", "H", 0.500));
	  expectedResultList.add(new CalculatedWeightResult("C", "G", 0.500));
	  
	
	  PortCalService testInput=new PortCalService();
	  System.out.println("Output For Test Results With Input In Any Order");
	  testInput.crateTreeAndValidateInput(inputInAnyOrderFileName);
	  testInput.calulateFundWeight();
	  System.out.println("------------------------------------------");
	  int rownum=0;
	   for(CalculatedWeightResult eachExpectedResult:expectedResultList)
	   {
	     assertTrue("Fund Weight Did not Match Expected Result Expected: "+eachExpectedResult.toString() + "But Got "+testInput.fundWeightList.get(rownum).toString(),(eachExpectedResult.toString().equalsIgnoreCase(testInput.fundWeightList.get(rownum).toString())));
	     rownum++;
	   }
	  
    } 
  


}
