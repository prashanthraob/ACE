@US2
Feature: Case Creation

Scenario: To verify user able to create a case
 Given The user login into to application
 When The user naviagtes to contact search page and search contact "Devarasetty"
 Then User contact "Devarasetty" should be displayed in the search result
 And User clicks on contact 
 Then Contact details page should be opened
 When User fills the fields "Status,Origin,Comments" in case template with values "New,Phone,Testing" and click on create case button 
 Then Verify case is created successfully
 
 Scenario: To verify user able to clear the case template infomation when clicks on clear button
 Given The user login into to application
 When The user naviagtes to contact search page and search contact "Devarasetty"
 Then User contact "Devarasetty" should be displayed in the search result
 And User clicks on contact 
 Then Contact details page should be opened
 When User fills the fields "Status,Origin,Comments" in case template with values "New,Phone,Testing" and click on clear button 
 Then Verify case template information is cleared successfully
 
 Scenario: To verify that admin should not be able to create case without providing mandatory values
 Given The user login into to application
 When The user naviagtes to contact search page and search contact "Devarasetty"
 Then User contact "Devarasetty" should be displayed in the search result
 And User clicks on contact 
 Then Contact details page should be opened
 When User fills the fields "Status,Origin" in case template with values "New,Phone" and click on create case button 
 Then Verify validation message displayed in case template
 
 Scenario: To verify that admin should see text comments is text case comments after the case is created
 Given The user login into to application
 When The user naviagtes to contact search page and search contact "Devarasetty"
 Then User contact "Devarasetty" should be displayed in the search result
 And User clicks on contact 
 Then Contact details page should be opened
 When User fills the fields "Status,Origin,Comments" in case template with values "New,Phone,Testing" and click on create case button
 Then Verify case is created successfully
 Then User clicks on created case and should verify "RestAssured" in the comments
 
 

