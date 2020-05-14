Feature: Add Owner
  As a employee
  I want to add new customers (owners)
  So that we can track their pets and visits

  Scenario: Successfully enter a new owner's details
    Given I am on the add-owner form
    When  I enter valid owner data
    Then  The add owner submit button is enabled
#
  Scenario: Successfully add an owner
    Given I am on the add-owner form
    And   I enter valid owner data
    When  I submit the add owner form
    Then  The new owner will be displayed at the end of the owner's list
##
  Scenario: Unsuccessfully add an owner
    Given I am on the add-owner form
    When  I enter owner invalid short data
    Then  The add owner submit button is disabled
#
  Scenario: Short data to add an owner
    Given I am on the add-owner form
    When  I enter owner invalid short data
    Then  I see a specific message for each field specifying that "First name must be at least 2 characters long"

#  Scenario: Remove values from all the fields
#    Given I am on the add-owner form
#    And   I enter then remove values from each field
#    Then  The submit button is disabled
#    And   I see a specific message for each field specifying that it is required
#    And   Each field has an x at the end
##
  Scenario: Phone number must be numeric
    Given I am on the add-owner form
    And   I enter a non-numeric value into the phone field
    Then  The add owner submit button is disabled
    And   I see an error message specifying that "Phone number only accept digits"


  Scenario: Unsuccessfully Create owner with symbols and numbers in key fields
    Given I am on the add-owner form
    And   I enter symbols and numbers rather than words
    When  I submit the add owner form
    Then  I see a specific message for each field specifying that "First name must not contain symbols and numbers"

  Scenario: Duplicate an owner
    Given I am on the add-owner form
    And   I enter duplicate owner's details
    When  I submit the add owner form
    Then  I see an error message specifying that "Owner exists already!"