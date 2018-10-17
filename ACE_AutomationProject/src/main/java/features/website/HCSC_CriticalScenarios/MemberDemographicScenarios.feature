@criticalScenario
Feature: Verify Member Demographics scenarios on Member360 Page 

Scenario: 007 Verify that Member Details are displayed on Member360 Page 
	Given User logins in to member connect Application with "sumani@memberconnect.v3" and "Aug#2018" 
	When User navigates to "Customer Search" tab on "Home Page". 
	And User searches for member using field "First Name" as "Erica". 
	And User verifies member as "Erica ". 
	When User navigates to "Member 360" tab on "Member Details Page". 	
	And User verifies visibility and clicks on "See More" button. 
	Then User verifies Member Personal Information. 
		|Gender|Date of Birth |Email|Primary Phone Number|HICI|HBX|CIN|SSN|Alternate Phone|Subscriber Home Address|Mailing Address|Spoken|Written|
		| Female  |February 5, 1977 |eschiff@gmail.com  |617-306-4574| null|null|null|340-34-3948 |null|100 State Street, Boston, Massachusetts, 02113, United States|100 State Street, Boston, Massachusetts, 02113, United States|English|English|
	And User verifies the buttons under Personal Information section. 
		|Button 1                 |Button 2    |Button 3           |Button 4     |
		|Update Information |Update PCP |Request Id Card        |Find A Doctor|
		
		#####################################################End Of Scenario#######################################################
		
Scenario: 008 Verify that Find a Doctor option is available in Member Information Section 
	Given User logins in to member connect Application with "sumani@memberconnect.v3" and "Aug#2018" 
	When User navigates to "Customer Search" tab on "Home Page". 
	And User searches for member using field "First Name" as "Erica". 
	And User verifies member as "Erica ". 
	When User navigates to "Member 360" tab on "Member Details Page". 
	And User verifies visibility and clicks on "See More" button. 
	And User clicks on "Find a Doctor" button. 
	Then User is able to see list of doctors in popup. 
	
	#####################################################End Of Scenario#######################################################
	
	
	
	
	
	
