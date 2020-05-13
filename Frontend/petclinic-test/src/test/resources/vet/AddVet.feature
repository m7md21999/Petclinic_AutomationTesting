Feature: Add Vet
  As an admin
  I want to add new vets in our pet clinic
  So that customers can book them for visits

  Scenario: add a Vet choosing type
    Given I am on the New Veterinarian form
    When   I enter valid vet data with choosing type
    Then  The new vet will be displayed at the end of the vets's list

  Scenario: add a Vet without choosing type
    Given I am on the New Veterinarian form
    When   I enter valid vet data without choosing type
    Then  The new vet will be displayed at the end of the vets's list

  Scenario: add a Vet with blank fields
    Given I am on the New Veterinarian form
    When  I click Save Vet Button
    Then  page is not redirected

  Scenario: Short data Error Message
    Given I am on the New Veterinarian form
    When  I enter a single character in both fields
    Then  I see error message specifying at least two chars long


  Scenario: Submit Short data
    Given I am on the New Veterinarian form
    When  I enter one character in both fields
    Then  The new short vet should not be submitted

  Scenario: Create Vet with symbols and numbers in fields
    Given I am on the New Veterinarian form
    When   I enter symbols and numbers rather in fields
    Then  The new numeric vet should not be submitted

  Scenario: add a Vet with one space in each field
    Given I am on the New Veterinarian form
    When  I enter a single space in both fields
    Then  the new empty vet should not be submitted

  Scenario: SQL Injection Should not be submitted
    Given I am on the New Veterinarian form
    When I enter a select phrase in both fields
    Then  the new sql vet should not be submitted