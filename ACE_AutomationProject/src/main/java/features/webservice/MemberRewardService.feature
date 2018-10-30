@Webservice
Feature: Verify Member rewards webservice
 
  Scenario Outline: User calls a Webservice to verify Member Rewards
    Given A Member exists in Member Connect Application with unique "<MemberId>"
    When User calls the Member rewards webservice to retreive with Member Id
    Then the status code is 200
    Then user Verifies reward summary as below
    
 |rewardDate|treatment|providerName|providerAddress|points|
 |05/22/2018|Evaluation by Specialist|Smith, Thomas, MD|12 S Michigan Ave, Chicago, IL 60603|90|
 |08/12/2017|General Checkup|University of Chicago Medicine|5841 S Maryland Ave, Chicago, IL 60637|135|
 |01/17/2017|Insertion of Heart Defibrillator|Smith, Thomas, MD|12 S Michigan Ave, Chicago, IL 60603|200|
    
Examples: 
    | MemberId|
    | testID  |
    | 83804824|
   
	Scenario: Valiadte post man api by performing POST Call with Json object 
	Given I want to validate create data api with headers
	And I want to create JSON object for request body
	When I want to perform POST call to "https://postman-echo.com/post"
	Then I want to verify response code as "200"
	
	
	Scenario: Valiadte post man api by performing POST Call with Json file
	Given I want to validate create data api with headers
	And I want to input request body payload as a JSON file "\\test.json"
	When I want to perform POST call to "https://postman-echo.com/post"
	Then I want to verify response code as "200"  
    


    