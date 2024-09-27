Feature: User Registration - Password Requirements

  As a new MoneyGaming.com player
  I want to ensure that my password meets the specified criteria
  So that my account is secure

  Background:
    Given I am on the registration page
    And I have filled in the Title with "Mr."
    And I have entered "Steve" as my First Name
    And I have entered "Smith" as my Surname
    And I have entered "2000-01-01" as my Date of Birth
    And I have accepted the Terms and Conditions

  Scenario: Successful registration with a valid password
    When I enter "Password$6" as my password
    And I submit the registration form
    Then I should see a message "Registration successful"

  Scenario: Registration fails with a password that is too short
    When I enter "12345" as my password
    And I submit the registration form
    Then I should see an error message "Password must be at least 6 characters long"

  Scenario: Registration fails with a password that lacks a number
    When I enter "abcdef$" as my password
    And I submit the registration form
    Then I should see an error message "Password must contain at least one number"

  Scenario: Registration fails with a password that lacks a special character
    When I enter "abc123" as my password
    And I submit the registration form
    Then I should see an error message "Password must contain at least one special character"

  Scenario: Registration fails with a password that is only numeric
    When I enter "123456" as my password
    And I submit the registration form
    Then I should see an error message "Password must contain at least one special character"

  Scenario: Registration fails with a password consisting only of letters
    When I enter "abcdef" as my password
    And I submit the registration form
    Then I should see an error message "Password must contain at least one number and at least one special character"

  Scenario: Registration fails with an empty password
    When I enter "" as my password
    And I submit the registration form
    Then I should see an error message "Password cannot be empty"
