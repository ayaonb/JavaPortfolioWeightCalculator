package com.portfoliocalculator.domain;


public class Funds {
	/**
	 * fundName-child Name Coming from the input
	 * startingMarketValue-child's market value coming from the input
	 * endingMarketValue-child's ending market value coming from the input
	 */
	private String fundName;
	private Double startingMarketValue;
	private Double endingMarketValue;
	
	public Funds(String fundName,Double startingMarketValue,Double endingMarketValue)
	{
		this.fundName=fundName;
		this.startingMarketValue=startingMarketValue;
		this.endingMarketValue=endingMarketValue;
	}
	

	public String getFundName() {
		return fundName;
	}

	public Double getStartingMarketValue() {
		return startingMarketValue;
	}

	public Double getEndingMarketValue() {
		return endingMarketValue;
	}

	@Override
	public boolean equals(Object funds) {
		boolean isEqual = false;
		if (funds instanceof Funds) {
			Funds other = (Funds) funds;
			if (other.fundName.equalsIgnoreCase(fundName)) {
				isEqual = true;
			}
		}
		return isEqual;
	}

	
	@Override
	public String toString() {
		return "Funds [FundName=" + fundName + ", marketValue=" + startingMarketValue + "]";
	}
	
}
