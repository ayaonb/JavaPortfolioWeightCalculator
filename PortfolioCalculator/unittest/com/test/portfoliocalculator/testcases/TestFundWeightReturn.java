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

public class TestFundWeightReturn { 
 
private String inputInOrderWeightedReturnFileName;
private String inputInAnyOrderWeightedFileName;



@Before
public void initialize() {
	inputInOrderWeightedReturnFileName=System.getProperty("fileNameWeightedReturnInOrder");
	inputInAnyOrderWeightedFileName=System.getProperty("fileNameWeightedReturnInAnyOrder");
}

/**
 * Test for calculating fund weight return in proper input order
 * Formula Used fund weight return=Ending Fund Weight/Starting Fund Weight
 * @throws ValidationFailException 
 * @throws IOException 
 */
@Test
public void calculateFundWegightReturnInOrderTest() throws IOException, ValidationFailException  {
	  List<CalculatedWeightResult> expectedResultList=new ArrayList<>();
	  expectedResultList.add(new CalculatedWeightResult("A", "D", 0.960));
	  expectedResultList.add(new CalculatedWeightResult("A", "E", 1.440));	
	  expectedResultList.add(new CalculatedWeightResult("A", "F", 1.440));
	  expectedResultList.add(new CalculatedWeightResult("A", "G", 1.080));
	  expectedResultList.add(new CalculatedWeightResult("A", "H", 0.720));
	  expectedResultList.add(new CalculatedWeightResult("B", "D", 0.800));
	  expectedResultList.add(new CalculatedWeightResult("B", "E", 1.200));	 	 
	  expectedResultList.add(new CalculatedWeightResult("B", "F", 1.200));
	  expectedResultList.add(new CalculatedWeightResult("C", "G", 1.200));
	  expectedResultList.add(new CalculatedWeightResult("C", "H", 0.800));
	 
	 
	
	  PortCalService testInput=new PortCalService();
	  System.out.println("Output For Test Results With Input In Proper Order");
	  testInput.crateTreeAndValidateInput(inputInOrderWeightedReturnFileName);
	  testInput.calculateWeightedReturn();
	  System.out.println("------------------------------------------");
	  int rownum=0;
	   for(CalculatedWeightResult eachExpectedResult:expectedResultList)
	   {
	     assertTrue("Fund Weight Did not Match Expected Result Expected: "+eachExpectedResult.toString() + "But Got "+testInput.weightedReturList.get(rownum).toString(),(eachExpectedResult.toString().equalsIgnoreCase(testInput.weightedReturList.get(rownum).toString())));
	     rownum++;
	   }
	  
    }


/**
 * Test for calculating fund weight return in any input order
 * @throws ValidationFailException 
 * @throws IOException 
 */
@Test
public void calculateFundWegightReturnInAnyOrderTest() throws IOException, ValidationFailException  {
	  List<CalculatedWeightResult> expectedResultList=new ArrayList<>();
	  expectedResultList.add(new CalculatedWeightResult("A", "E", 1.440));
	  expectedResultList.add(new CalculatedWeightResult("A", "D", 0.960));
	  expectedResultList.add(new CalculatedWeightResult("A", "F", 1.440));
	  expectedResultList.add(new CalculatedWeightResult("A", "H", 0.720));
	  expectedResultList.add(new CalculatedWeightResult("A", "G", 1.080));
	  expectedResultList.add(new CalculatedWeightResult("B", "E", 1.200));
	  expectedResultList.add(new CalculatedWeightResult("B", "D", 0.800));	 
	  expectedResultList.add(new CalculatedWeightResult("B", "F", 1.200));
	  expectedResultList.add(new CalculatedWeightResult("C", "H", 0.800));
	  expectedResultList.add(new CalculatedWeightResult("C", "G", 1.200));
	  
	  
	
	  PortCalService testInput=new PortCalService();
	  System.out.println("Output For Test Results With Input In Any Order");
	  testInput.crateTreeAndValidateInput(inputInAnyOrderWeightedFileName);
	  testInput.calculateWeightedReturn();
	  System.out.println("------------------------------------------");
	  int rownum=0;
	   for(CalculatedWeightResult eachExpectedResult:expectedResultList)
	   {
	     assertTrue("Fund Weight Did not Match Expected Result Expected: "+eachExpectedResult.toString() + "But Got "+testInput.weightedReturList.get(rownum).toString(),(eachExpectedResult.toString().equalsIgnoreCase(testInput.weightedReturList.get(rownum).toString())));
	     rownum++;
	   }
	  
    } 
  


}
