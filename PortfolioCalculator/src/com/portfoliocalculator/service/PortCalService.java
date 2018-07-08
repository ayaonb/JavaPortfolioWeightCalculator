package com.portfoliocalculator.service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.portfoliocalculator.domain.CalculatedWeightResult;
import com.portfoliocalculator.domain.Funds;
import com.portfoliocalculator.exception.ExceptionConstant;
import com.portfoliocalculator.exception.ValidationFailException;

/**
 * @author Ayaon Bakshi
 *
 */
public class PortCalService {

	/**
	 * parentChildTreeFundMap is a map which contains the parent name as key and list of child elements as it's value. 
	 * sumParentBeginningValueMap is a map which contains the parent name as key and sum of it's immediate child's market value as it's value. 
	 * sumParentEndingMarketValueMap is a map which	contains the parent name as key and sum of it's immediate child's ending market value as it's value if present. 
	 * childNameSet is a set which contains unique list of Child name. 
	 * parentNameSet is a set which contains unique list of Parent name except root.
	 * rootSet is a set which contains unique list of root name except parent. 
	 * endMarketValuePresent is a boolean value which returns true if ending market value is also present in file.
	 * fundWeightList contains fund weight within portfolio with respect to each leaf node.
	 * weightedReturList contains fund weight return within portfolio with respect to each leaf node if end market value present.
	 */
	private Map<String, List<Funds>> parentChildTreeFundMap = new HashMap<>();
	private Map<String, Double> sumParentBeginningValueMap = new HashMap<>();
	private Map<String, Double> sumParentEndingMarketValueMap = new HashMap<>();

	private Set<String> childNameSet = new HashSet<>();
	private Set<String> parentNameSet = new HashSet<>();
	private Set<String> rootSet = new HashSet<>();

	Boolean endMarketValuePresent = false;

	public List<CalculatedWeightResult> fundWeightList = new ArrayList<>();

	public List<CalculatedWeightResult> weightedReturList = new ArrayList<>();

	/**
	 * @param fileName
	 * @throws IOException
	 * @throws ValidationFailException
	 * Reads a file whose file name along with directory path is passed from command line.
	 * Each line is split and stored in list of strings and split based on comma.
	 * Text file is parsed and validation check is performed. 
	 * If validation is passed finally a tree is created.
	 */
	public void crateTreeAndValidateInput(String fileName) throws IOException, ValidationFailException {

		List<String> inputList = Files.lines(Paths.get(fileName), Charset.defaultCharset())
				.flatMap(line -> Arrays.stream(line.split("\\r?\\n"))).collect(Collectors.toList());

		for (String eachInput : inputList) {
			String[] eachInputValArr = eachInput.split(",");
			ValidationService.validateInput(eachInputValArr[0], eachInputValArr[1], eachInputValArr[2]);
			String parentName = eachInputValArr[0];
			String childName = eachInputValArr[1];
			Double startingMarketValue = Double.parseDouble(eachInputValArr[2]);
			Double endingMarketValue = null;
			if (eachInputValArr.length > 3) {
				ValidationService.validateEndMarketValue(parentName, childName, startingMarketValue,
						eachInputValArr[3]);
				endingMarketValue = Double.parseDouble(eachInputValArr[3]);
				endMarketValuePresent = true;
			} else {
				endMarketValuePresent = false;
			}
			parentNameSet.add(parentName);
			childNameSet.add(childName);
			rootSet.add(parentName);

			List<Funds> fundsList;
			Double sumBeginMV;
			Double sumEndMV;

			Funds eachFund = new Funds(childName, startingMarketValue, endingMarketValue);
			if (parentChildTreeFundMap.containsKey(parentName)) {
				fundsList = parentChildTreeFundMap.get(parentName);
				sumBeginMV = sumParentBeginningValueMap.get(parentName);
				sumEndMV = sumParentEndingMarketValueMap.get(parentName);
			}

			else {
				fundsList = new ArrayList<>();
				sumBeginMV = 0.0;
				sumEndMV = 0.0;
			}
			if (fundsList.contains(eachFund)) {
				throw new ValidationFailException(ExceptionConstant.DUPLICATE_FUND + " " + eachFund);
			}
			fundsList.add(eachFund);
			sumBeginMV = sumBeginMV + startingMarketValue;
			parentChildTreeFundMap.put(parentName, fundsList);
			sumParentBeginningValueMap.put(parentName, sumBeginMV);
			if (null != endingMarketValue) {
				sumEndMV += endingMarketValue;
				sumParentEndingMarketValueMap.put(parentName, sumEndMV);
			}

		}

		rootSet.removeAll(childNameSet);
		parentNameSet.removeAll(rootSet);

	}
	
	
	/**
	 * Iterate over root set first and calculates the fund weight. 
	 * Iterate over rest of the parent set and calculates the fund weight. 
	 * Prints the fund weight individually.
	 */
	public void calulateFundWeight() {

		for (String rootName : rootSet) {
			calculateFundWeight(rootName, rootName, 0.0);
		}

		for (String rootName : parentNameSet) {
			calculateFundWeight(rootName, rootName, 0.0);

		}
		fundWeightList.forEach(System.out::println);

	}

	/**
	 * Iterate over root set first and calculates the fund weight return. 
	 * Iterate over rest of the parent set and calculates the fund weight return. 
	 * Prints the fund weight return individually.
	 */
	public void calculateWeightedReturn() {
		if (endMarketValuePresent) {
			for (String rootName : rootSet) {
				calculateWeightedReturn(rootName, rootName, 0.0, 0.0);
			}

			for (String rootName : parentNameSet) {
				calculateWeightedReturn(rootName, rootName, 0.0, 0.0);
			}
		}
		weightedReturList.forEach(System.out::println);
	}
	
	

	/**
	 * @param rootName
	 * @param parentName
	 * @param beginMV
	 * @param endMV
	 * Recursive Logic to calculate fund weight return of all the leaf nodes for the corresponding parent name.
	 * Formula Used Fund Weight Return=Ending Market Fund Weight/Starting Market Fund Weight
	 */ 
	private void calculateWeightedReturn(String rootName, String parentName, Double beginMV, Double endMV) {

		if (!parentChildTreeFundMap.containsKey(parentName)) {
			Double sumBeginParentVal = sumParentBeginningValueMap.get(rootName);
			Double fundWeightBegin = beginMV / sumBeginParentVal;
			Double sumEndParentVal = sumParentEndingMarketValueMap.get(rootName);
			Double fundWeightEnd = endMV / sumEndParentVal;
			Double weighTedReturn = fundWeightEnd / fundWeightBegin;

			CalculatedWeightResult fundWeightReturn = new CalculatedWeightResult(rootName, parentName, weighTedReturn);
			weightedReturList.add(fundWeightReturn);
			return;
		}

		else {
			List<Funds> childList = parentChildTreeFundMap.get(parentName);

			for (Funds eachFund : childList) {
				calculateWeightedReturn(rootName, eachFund.getFundName(), eachFund.getStartingMarketValue(),
						eachFund.getEndingMarketValue());
			}

		}

	}

	
	/**
	 * @param rootName
	 * @param parentName
	 * @param marketValue
	 * Recursive Logic to calculate fund weight of all the leaf nodes for the corresponding parent name.
	 */
	private void calculateFundWeight(String rootName, String parentName, Double marketValue) {

		if (!parentChildTreeFundMap.containsKey(parentName)) {
			Double sum = sumParentBeginningValueMap.get(rootName);
			Double fundWeight = marketValue / sum;
			CalculatedWeightResult fundWeightResult = new CalculatedWeightResult(rootName, parentName, fundWeight);
			fundWeightList.add(fundWeightResult);

			return;
		}

		else {
			List<Funds> childList = parentChildTreeFundMap.get(parentName);

			for (Funds eachFund : childList) {
				calculateFundWeight(rootName, eachFund.getFundName(), eachFund.getStartingMarketValue());
			}

		}
	}
}
