Feature: Login

Scenario: Login page title validation
Given User is on login page
When User gets the title of the page
And Page title should be "Login - My Store"

Scenario: Forgot password link
Given User is on login page
Then Forgot password link should be displayed

Scenario: Login with correct credentials
Given User is on login page
And User enters "93prabha@gmail.com" on the username field
And User enters "22091993" on the password field
And User clicks on login button
Then User gets the title of the page
And Page title should be "My account - My Store"