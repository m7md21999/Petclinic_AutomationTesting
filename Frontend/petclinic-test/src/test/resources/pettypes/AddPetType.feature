Feature: Add PetTypes
  As a employee
  I want to add new PetType
  So that we can add new PetType

  Scenario: Successfully enter a new Pet Type
    Given  I am on the Pet Type form
    When   I Clinic add button
    And    I Enter Valid Pet Type name
    And    I submit the pet-type name
    Then   The new Pet Type will be displayed at the end of the Pet Type's list

  Scenario: Enter symbols and numbers
    Given I am on the Pet Type form
    When  I Clinic add button
    And   I enter symbols and numbers rather than words data
    And    I submit the pet-type name
    Then  The new Pet Type will not be displayed at the end of the Pet Type's list

  Scenario: Unsuccessfully add an Pet Type
    Given I am on the Pet Type form
    When  I Clinic add button
    And   I enter then remove value from the field
    And    I submit the pet-type name
    Then  The add button is give no action