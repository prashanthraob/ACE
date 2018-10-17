@criticalScenario
Feature: Verify Benefit and Plan Scenarios 

Scenario: 001 Verify that Member Details are displayed on Member360 Page 
	Given User logins in to member connect Application with "sumani@memberconnect.v3" and "Aug#2018" 
	When User navigates to "Customer Search" tab on "Home Page". 
	And User searches for member using field "First Name" as "Erica". 
	And User verifies member as "Erica". 
	When User navigates to "Benefits" tab on "Member Details Page". 
	Then User verifies Plan details. 
		|Plan Type|Effective Date|Termination Date|Re-certification Date|Enrollment County|Effectuated Date|Reason Description|
	And User verifies Benefit details. 
	
	
		
		#####################################################End Of Scenario#######################################################
		
     