
Feature: Web Features

  Scenario: Register new user and place an order
    Given User navigates to url "https://demowebshop.tricentis.com/"
    When User clicks on register
    And User fills registration form
    And User clicks register button
    Then Validate registration is successful
    And User logs out
    When User logs in successfully with "" and ""
    And User navigates to Computers and desktop page
    And Sorts items with all options
    And User adds all available items to cart
    And User views shopping cart
    And User removes item from cart
    And User checks out items in cart
    Then Validate order is placed successfully
    And View order details on my account


  Scenario: Register user
    Given User navigates to url "https://demowebshop.tricentis.com/"
    When User clicks on register
    And User fills registration form
    And User clicks register button
    Then Validate registration is successful


  Scenario Outline: Place an order
    Given User navigates to url "https://demowebshop.tricentis.com/"
    When User logs in successfully with "<username>" and "<password>"
    And User navigates to Computers and desktop page
    And Sorts items with all options
    And User adds all available items to cart
    And User views shopping cart
    And User removes item from cart
    And User checks out items in cart
    Then Validate order is placed successfully
    And View order details on my account

    Examples:
    |username|password|
    |tester000001@test.com|Password01|


