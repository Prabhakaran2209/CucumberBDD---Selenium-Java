Feature: Account page feature

Background: 
Given User is logged in to the application
|Username | Password |
|93prabha@gmail.com| 22091993 |

Scenario: Accounts page title
Given User is on accounts page
When User gets the title of the page
Then Page title should be "My account - My Store"

Scenario: My accounts section count
Given User is on accounts page
And User gets the account section count
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
|Home|
Then Account section count should be 6



