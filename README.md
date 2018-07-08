# Portfolio Weight Calculator
Refer the below link for problem statement<br />
<a href="https://gist.github.com/rprabhat/3b8cc6e47a822d63b844e3d3d0d67ea7">Portfolio Weight Calculator</a><br />


## Getting Started

Download the project in your local.<br />
Import it as a Java Project in your IDE.<br />
You can also run from command promt directly using "java -jar"<br />

### Prerequisites

JDK 1.8 or higher <br />
JUNIT 4 or higher <br />

## Running the Program From the Command Line
* Clone this repository:<br />
```
    $ git clone https://github.com/ayaonb/JavaPortfolioWeightCalculator.git <br />
```
* Create jar of in the root directory of Portfolio Calculator <br />
* Run the test case by passing the filename with the path in the command prompt. For example: <br />
```
     > java -jar target/PortFolioCalculator.jar [fileName] 
```
e.g.
```
     > java -jar target/PortFolioCalculator.jar C:\Users\1555058\eclipse-workspace\PortfolioCalculator\testInputFiles\PortFolioInputFundWeightInOrder.txt
```

## Running the Program From the IDE
 Download the project into your local. <br />
 Import it as a Java Project. <br />
 Run the main class named MainPortfolioCalculatorTest.java by passing the file name in Program Arguments.<br />
 
 
 ## Running the JUNIT Test Cases
JUNIT test cases can either be ran from command prompt or IDE <br />
If you are running from command prompt you can run by using the below commands<br />

java -cp junit.jar org.junit.runner.JUnitCore [test class name] [fileName] <br />
PortFolioInputInvalidEndingMarketValue.txt
You can also run the JUNIT classes individually from IDE.<br />

Below are the list of classes and it's purposes.<br />
**Class Name:** TestFundWeight <br />
**Purpose:** Calculate the fund weight of the portfolio with input in proper order and in any order.<br />
**Reference Input Files:** <br /> PortFolioInputFundWeightInOrder.txt<br />PortFolioInputFundWeightInAnyOrder.txt<br />in InputFiles folder.<br />
**Sample Arguments Passed In Command Line:** <br /> -DfileNameInOrder="\testInputFiles\PortFolioInputFundWeightInOrder.txt"<br /> -DfileNameInAnyOrder="\testInputFiles\PortFolioInputFundWeightInAnyOrder.txt"<br />

**Class Name:** TestFundWeightReturn <br />
**Purpose:** Calculate the fund weight return of the portfolio with input in proper order and in any order. <br />
Note:Fund Weight Return will only be calculated when ending market value is provided in the input. <br />
**Formula Used : Fund Weight Return= Ending Portfolio Fund Weight/ Starting Portfolio Fund Weight**
**Reference Input Files:** <br /> PortFolioInputWeightedReturnInOrder.txt<br />PortFolioInputWeightedReturnInAnyOrder.txt <br /> in InputFiles folder.<br />
**Sample Arguments Passed In Command Line:** <br /> -DfileNameWeightedReturnInOrder="\testInputFiles\PortFolioInputWeightedReturnInOrder.txt"<br /> -DfileNameWeightedReturnInAnyOrder="\testInputFiles\PortFolioInputWeightedReturnInAnyOrder.txt"<br />

**Class Name:** TestMultipleParentFundWeight <br />
**Purpose:** Calculate the fund weight of the portfolio with input having multiple parents in proper order and in any order.<br />
**Reference Input Files:** <br /> PortFolioInputFundWeightMultipleParentInOrder.txt<br /> PortFolioInputFundWeightMultipleParentInAnyOrder.txt <br /> in InputFiles folder.<br />
**Sample Arguments Passed In Command Line:** <br /> -DfileNameMultipleParentInOrder="\testInputFiles\PortFolioInputFundWeightMultipleParentInOrder.txt"<br /> -DfileNameMultipleParentInAnyOrder="\testInputFiles\PortFolioInputFundWeightMultipleParentInAnyOrder.txt"<br />

**Class Name:** TestValidationOfFunds <br />
**Purpose:** Validates the input present in the text files on various scenarios.<br />
**Reference Input Files:**<br /> PortFolioInputBlankEndingMarketValue.txt<br />PortFolioInputDuplicateFundName.txt<br />PortFolioInputInvalidEndingMarketValue.txt<br />PortFolioInputValidateBlankFundName.txt<br />PortFolioInputValidateBlankMarketValue.txt<br />PortFolioInputValidateInvalidMarketValue.txt <br /> in InputFiles folder.<br />
**Sample Arguments Passed In Command Line:** <br /> -DfileNameBlankFundName="\testInputFiles\PortFolioInputValidateBlankFundName.txt"<br /> -DfileNameBlankMarketValue="\testInputFiles\PortFolioInputValidateBlankMarketValue.txt"<br /> -DfileNameInvalidMarketValue="\testInputFiles\PortFolioInputValidateInvalidMarketValue.txt"<br /> -DfileNameBlankEndingMarketValue="\testInputFiles\PortFolioInputBlankEndingMarketValue.txt"<br /> -DfileNameInvalidEndingMarketValue="\testInputFiles\PortFolioInputInvalidEndingMarketValue.txt"<br /> -DfileNameDuplicateFundName="\testInputFiles\PortFolioInputDuplicateFundName.txt"<br />

 
