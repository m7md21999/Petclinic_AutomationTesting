Feature: Edit Owner
  As a employee
  I want to Edit owner information
  So that it remains up to date


  Scenario: Successfully owner data retrieved to be updated
    Given I am on the edit owner information form
    Then  The current owner data are pre-set in the fields

  Scenario: Successfully update owner information
    Given I am on the edit owner information form
    And  I clear all fields of edit owner form
    And I Enter owner updated valid data
    When  I submit the edit owner form
    Then  The updated owner will be displayed in the Owner page with updated information


  Scenario: Unsuccessfully edit an owner with non-numeric telephone
    Given I am on the edit owner information form
    When  I clear all fields of edit owner form
    And I Enter owner updated valid data
    And  I enter non numeric telephone data
    Then  The owner edit submit button is disabled

  Scenario: Unsuccessfully edit an owner with empty fields
    Given I am on the edit owner information form
    When  I clear all fields of edit owner form
    Then  The owner edit submit button is disabled


  Scenario: Unsuccessfully edit an owner with symbols and numbers
    Given I am on the edit owner information form
    When  I clear all fields of edit owner form
    And I Edit key fields with symbols and numbers rather than words
    Then  The owner edit submit button is disabled