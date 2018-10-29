@website
Feature: Verification for member rewards scenarios 

Scenario: 002 Verify that Users can receive incentives for choosing a designated lower-cost provider (Member rewards) 

	Given User logins in to member connect Application with "sumani@memberconnect.v3" and "Aug#2018" 
	When  User navigates to "Customer Search" tab. 
	When  User enters "Erica" in "First Name" field 
	Then  selected Member details are displayed "Erica" 
	Then  Agent clicks on Verify button 
	When  User navigates to "Member 360" tab. 
	And   User clicks on "View Details" under "Rewards" section. 
	Then  User should be able to view the rewards summary. 
	#And   User should be able to view total rewards points earned on Member Details page.
	
	############################################ End of Scenario 002 #########################################################################
	
Scenario: 003 Verify that Users can receive incentives for choosing a designated lower-cost provider (Member rewards) 

	Given User logins in to member connect Application with "sumani@memberconnect.v3" and "Aug#2018" 
	When  User navigates to "Customer Search" tab. 
	When  User enters "Erica" in "First Name" field 
	Then  selected Member details are displayed "Erica" 
	Then  Agent clicks on Verify button 
	When  User navigates to "Member 360" tab. 
	And   User clicks on "View Details" under "Rewards" section. 
	Then  User should be able to view the rewards summary. 
	And   User should be able to view total rewards points earned on Member Details page. 
	