Feature: Edit Pet
  As an employee
  I want to edit pets information
  So that we can trust that their information is correct

  Scenario: Successfully edit a pet
    Given I am on the edit-pet form
    And   I update with valid pet data
    When  I submit the edit-pet form
    Then  The pet information will be updated and displayed at the owner information page


  Scenario: Edit pet with symbols and numbers in the name field
    Given I am on the edit-pet form
    And   I update the name field with symbols and numbers rather than words
    When  I submit the edit-pet form
    Then  The new pet will not updated

  Scenario: Birth data must be in a date format
    Given I am on the edit-pet form
    And   I update the birth date field with a non-date formatted value
    When  I submit the edit-pet form
    Then  I remain in the edit pet page