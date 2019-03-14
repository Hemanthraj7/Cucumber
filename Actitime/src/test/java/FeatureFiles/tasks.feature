@tasks
Feature: Tasks

@createcustomer
Scenario: This scenario is to create customer

Given an user opens browsers and url
Then a login page should be displayed
When user enters valid username & password 
And click on login button
Then the application should be logged in
When user clicks on TASKS tab
And user click on add new and create customer
#Then a pop should be displayed to enter details
When the user enters name and descripion 
And click on create customer  
Then customer should be creatred
And click on logout button and close the browser

@deletecustomer
Scenario: This is delete customer

Given an user opens browsers and url
Then a login page should be displayed
When user enters valid username & password 
And click on login button
Then the application should be logged in
When user clicks on TASKS tab
And search customer name in search text box
And click on customersettings button
Then popup page should display
When user click on Actions button
And click on delete button
And click on delete permanently button  
And click on logout button and close the browser
