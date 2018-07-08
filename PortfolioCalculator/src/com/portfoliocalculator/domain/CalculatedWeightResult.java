package com.portfoliocalculator.domain;

public class CalculatedWeightResult {
	
	
   /**
 * parentName - the first element that is the parent name expected in the output
 * leafName- the second element that is the leaf name expected in the output
 * fundWeightedResult- the third element that is fund weight or fund return weight expected in the output
 */
private String parentName;
   private String leafName;
   private Double fundWeightedResult;
   
public CalculatedWeightResult(String parentName, String leafName, Double fundWeightedResult) {
	
	this.parentName = parentName;
	this.leafName = leafName;
	this.fundWeightedResult = fundWeightedResult;
}


public String getParentName() {
	return parentName;
}

public String getLeafName() {
	return leafName;
}

public Double getFundWeightedResult() {
	return fundWeightedResult;
}
  
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 * Overriding expected output format in the form e.g:A,D,0.167
 */
@Override
public String toString() {
	return parentName+","+leafName+","+String.format("%.3f", fundWeightedResult);
}


}
