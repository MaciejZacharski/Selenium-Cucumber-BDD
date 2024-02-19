Feature: User Register

  User Register Functionality for internet shop seleniumdemo.com

  Background: User is on My account page
    Given User is on shop Home Page
    When User navigates to MyAccount Page

  Scenario: User Register with Valid Data

    And User enters valid data to register form
    Then  User is navigated to Logged User Page
    But Register form is not present

  Scenario Outline: User Register with Invalid Email and valid password
    And Data for email "test@test.com" and password "<password>"
    Then Error message for invalid email is displayed
    Examples:
      |password|
      |Test@123!45|
      |Test@123!4545667457|
      |Test@123!455435636gkgukfgy|
