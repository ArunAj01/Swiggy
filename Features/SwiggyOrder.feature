Feature: Buy a dish on swiggy

Scenario: A user must able to buy a dish on swiggy
Given a user is on the landing page on Amazon
When he type Hyderabad and select the first option
And he click on first restaurant under Top Restaurant chains in Hyderabad
And he click Add button on the first listed dish
And he hover over Cart icon
And he click on Check Out button
Then verify the text "To place your order now, log in to your existing account or sign up."