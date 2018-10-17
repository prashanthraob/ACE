@criticalScenario 
Feature: Verify Manage PCP scenarios 

Scenario: 009 Verify MSR is able to select an eligible PCP and assign the same to the member 
	Given User logins in to member connect Application with "sumani@memberconnect.v3" and "Aug#2018" 
	When User navigates to "Customer Search" tab on "Home Page". 
	And User searches for member using field "First Name" as "Erica". 
	And User verifies member as "Erica ". 
	When User navigates to "Member 360" tab on "Member Details Page". 
	And User verifies visibility and clicks on "See More" button. 
	And User clicks on Update PCP button 
	And User clicks on search button 
	And User Clicks on Provider Name 
	Then User verifies Update PCP popup 
	
	
	#####################################################End Of Scenario#######################################################
	
Scenario: 010 Verify that MSR is able to perform PCP search 
	Given User logins in to member connect Application with "sumani@memberconnect.v3" and "Aug#2018" 
	When User navigates to "Customer Search" tab on "Home Page". 
	And User searches for member using field "First Name" as "Erica". 
	And User verifies member as "Erica ". 
	When User navigates to "Member 360" tab on "Member Details Page". 
	And User verifies visibility and clicks on "See More" button. 
	And User clicks on Update PCP button 
	When User searches Provider Id with "8283746" 
	And User clicks on search button 
	Then User verifies search results with Provider Id "8283746" 
	
	
	#####################################################End Of Scenario#######################################################

Scenario: 011 Verify that MSR is able to perform PCP search by applying advance search criteria 
	Given User logins in to member connect Application with "sumani@memberconnect.v3" and "Aug#2018" 
	When User navigates to "Customer Search" tab on "Home Page". 
	And User searches for member using field "First Name" as "Erica". 
	And User verifies member as "Erica ". 
	When User navigates to "Member 360" tab on "Member Details Page". 
	And User verifies visibility and clicks on "See More" button. 
	And User clicks on Update PCP button 
	When User clicks on Advance Search Criteria button 
	And User selects provider gender with "Female" 
	And User clicks on search button 
	Then User verifies search results with Provider Id "8283746" 
	
	#####################################################End Of Scenario#######################################################
	
Scenario: 012 Verify that MSR is able to update PCP 
	Given User logins in to member connect Application with "sumani@memberconnect.v3" and "Aug#2018" 
	When User navigates to "Customer Search" tab on "Home Page". 
	And User searches for member using field "First Name" as "Erica". 
	And User verifies member as "Erica ". 
	When User navigates to "Member 360" tab on "Member Details Page". 
	And User verifies visibility and clicks on "See More" button. 
	And User clicks on Update PCP button 
	And User clicks on search button 
	And User Clicks on Provider Name 
	Then User verifies Update PCP popup details below details 
		| ID: |
		|8283746|
	And User clicks on submit button 
	
	#####################################################End Of Scenario#######################################################
	
	
	
	
	
	
	
