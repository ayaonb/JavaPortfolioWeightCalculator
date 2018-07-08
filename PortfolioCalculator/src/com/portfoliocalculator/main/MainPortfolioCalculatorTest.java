package com.portfoliocalculator.main;

import java.io.IOException;

import com.portfoliocalculator.exception.ValidationFailException;
import com.portfoliocalculator.service.PortCalService;

public class MainPortfolioCalculatorTest {

	public static void main(String[] args) throws IOException, ValidationFailException {
	
		String fileName=args[0];
	    PortCalService testInput=new PortCalService();
	    testInput.crateTreeAndValidateInput(fileName);
	    testInput.calulateFundWeight();
	}

}
