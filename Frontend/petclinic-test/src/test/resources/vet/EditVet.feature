Feature: Edit an existing Vet
  As an admin
  I want to edit existing vets in our pet clinic
  So that I can resolve any error made in their data

  Scenario: Valid editing a Vet
    Given I am navigated to the All Veterinarian page
    When  I click edit button the for the first vet
    And   I enter valid data
    Then  The edited vet will be displayed at the end of the vets's list

  Scenario: editing a Vet to have numbers as names
    Given I am navigated to the All Veterinarian page
    When  I click edit button the for the first vet
    And   I fill fields with numbers
    Then  The edited numbers vet should not be displayed in all vets list

  Scenario: editing a Vet with two spaces as names
    Given I am navigated to the All Veterinarian page
    When  I click edit button the for the first vet
    And   I fill fields with two spaces
    Then  The edited spaces vet should not be displayed in all vets list


  Scenario: edit a Vet to be blank
    Given I am navigated to the All Veterinarian page
    When  I click edit button the for the first vet
    And   I clear all data
    But   two errors show up
    Then  save button is disabled

  Scenario: click back button from edit form
    Given I am navigated to the All Veterinarian page
    When  I click edit button the for the first vet
    And   I click back button in edit vet form
    Then  I am back again in All vets page


