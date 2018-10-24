@exercise
Feature: Member Verification

Scenario: To verify that the user is able to verify the member
	Given User logins into the application
	When User navigates to the contact search page
	Then User is in the contact search page
	When User enters the First Name and Last Name and clicks on Search
	Then User should verify the contacts displayed
	
Scenario: To verify that the error message is displayed when only first name is provided
	Given User logins into the application
	When User navigates to the contact search page
	Then User is in the contact search page
	When User enters the First Name and clicks on Search
	Then User should be able to verify the error message