Feature: Add Pet
  As an employee
  I want to add new pets to a specific customer (owner)
  So that we can track their visits

  Scenario: Successfully add a pet
    Given I am on the add-pet form
    And   I enter valid pet data
    When  I submit the add-pet form
    Then  The new pet will be displayed at the owner information page


  Scenario: Submit with empty fields
    Given I am on the add-pet form
    And   I leave all the fields empty
    When  I submit the add-pet form
    Then I remain in the add pet page

  Scenario: Birth data must be in a date format
    Given I am on the add-pet form
    And   I enter a non-date formatted value into the birth date field
    When  I submit the add-pet form
    Then  I remain in the add pet page


  Scenario: Create pet with symbols and numbers in the name field
    Given I am on the add-pet form
    And   I enter symbols and numbers rather than words in the name field
    When  I submit the add-pet form
    Then  The new pet will not be added