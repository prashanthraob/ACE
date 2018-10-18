@exercise
Feature: Member Verification

Scenario: To verify that the user is able to create a new contact
	Given The user logins into the application
	When The user navigates to the contact search page
	Then New button should be disabled before first search
	When User searches with the first name and last name and clicks on search
	Then New button should be enabled and new contact should be created

Scenario: To verify that the user is able to verify the member
	Given The user logins into the application
	When The user navigates to the contact search page
	Then User provides the first name and last name and clicks search
	Then User should verify the contacts displayed
	
Scenario: To verify that the error message is displayed when only first name is provided
	Given The user logins into the application
	When The user navigates to the contact search page
	Then User provided first name and clicks on Search
	Then User should be able to verify the error message