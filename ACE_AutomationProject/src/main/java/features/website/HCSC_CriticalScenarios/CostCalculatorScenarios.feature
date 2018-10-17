@criticalScenario
Feature: Verify CostCalculator Scenarios 
#Change Provider link on Cost Calculator screen is not working hence the scenario is tested only till verification of change provider link

Scenario: 002 Verify that MSR is able to change Provider from Cost Calculator page 
	Given User logins in to member connect Application with "sumani@memberconnect.v3" and "Aug#2018" 
	When User navigates to "Customer Search" tab on "Home Page". 
	And User searches for member using field "First Name" as "Erica". 
	And User verifies member as "Erica ". 
	When User navigates to "Cost Calculator" tab on "Member Details Page". 	 
	And User enters "ab" in "Search" textbox.
	Then  User verifies the result set is displayed and contains Text "ab" 
	Then  User verifies that recommended providers are displayed with change Provider link 
		
	#####################################################End Of Scenario#######################################################
	
	
   