@criticalScenario 
Feature: Verify Manage Alert Scenarios 

Scenario: 003 Verify member is able to create alert 
	Given User logins in to member connect Application with "sumani@memberconnect.v3" and "Aug#2018" 
	When User navigates to "Manager Alert" tab on "Home Page". 
	When User clicks on Manager Alert tab and creates an Alert with "TestAlert123" and "General" and "Alert for General" and "Musculoskeletal" and "Normal" 
	Then User verifies that an Alert is created successfully "TestAlert123" 
	
	############################################End of Scenario#################################################
	
Scenario: 004 Verify member is able to delete an alert 
	Given User logins in to member connect Application with "sumani@memberconnect.v3" and "Aug#2018" 
	When User navigates to "Manager Alert" tab on "Home Page". 
	When User navigates to Created alert section and deletes an Alert 
	Then User verifies that an Alert is deletd 
	
	############################################End of Scenario#################################################
	
Scenario: 005 Verify user is able to resolve an alert 
	Given User logins in to member connect Application with "sumani@memberconnect.v3" and "Aug#2018" 
	When User navigates to "Manager Alert" tab on "Home Page". 
	When User clicks on an alert and changes the alert status to "Active" 
	Then User verifies that the alert status has changed to "Active" 
	
	############################################End of Scenario#################################################
	
Scenario: 006 Verify an alert is visible on member 360 where today's date lies between start date and end date 
	Given User logins in to member connect Application with "sumani@memberconnect.v3" and "Aug#2018" 
	When User navigates to "Manager Alert" tab on "Home Page".
	When User clicks on an alert and verifies alert tab details 
	Then User verifies if the current date is in between start date and end date 
	
	############################################End of Scenario#################################################
       