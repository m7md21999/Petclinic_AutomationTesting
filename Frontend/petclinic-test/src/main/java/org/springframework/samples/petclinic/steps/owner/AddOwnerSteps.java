package org.springframework.samples.petclinic.steps.owner;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.samples.petclinic.pages.owner.AddOwnerPage;
import org.springframework.samples.petclinic.pages.owner.AllOwnersPage;
import org.springframework.samples.petclinic.pages.HomePage;

import java.util.logging.Level;

import static java.util.logging.Logger.getLogger;
import static org.junit.Assert.*;

public class AddOwnerSteps {

    public String shortInputErrorMsg = "First name must be at least 2 characters long";
    public String numericInputErrorMsg = "Phone number only accept digits";

    public static final String FIRST_NAME = "first name tester";

    public static final String LAST_NAME = "lastName tester";
    private AddOwnerPage addOwnerPage;

    private HomePage homePage = new HomePage();
    private AllOwnersPage allOwnersPage;



    @Given("I am on the add-owner form")
    public void iAmOnTheAddOwnerForm() {
        addOwnerPage = homePage.goToAddOwner();

        assertTrue(addOwnerPage.isCurrent());
    }

    @When("I enter valid owner data")
    public void iEnterValidData() {


        addOwnerPage.enterValidData();


    }

    @Then("The add owner submit button is enabled")
    public void eachFieldWillHaveATickOnTheRight() {
        //  assertTrue(addOwnerPage.checkTick());
        assertFalse(addOwnerPage.checkButtonDisability());
        addOwnerPage.closeBrowser();


    }

    @When("I submit the add owner form")
    public void iSubmitTheForm() {
        allOwnersPage = addOwnerPage.submit();
    }

    @Then("The new owner will be displayed at the end of the owner's list")
    public void theNewOwnerWillBeDisplayedAtTheEndOfTheOwnerSList() {
        assertTrue(allOwnersPage.isAdded(FIRST_NAME, LAST_NAME));
        allOwnersPage.closeBrowser();

    }

    @When("I enter owner invalid short data")
    public void iEnterInvalidData() {

        addOwnerPage.enterInvalidData();
    }

    @Then("The add owner submit button is disabled")
    public void theSubmitButtonIsDisabled() {

        assertTrue(addOwnerPage.checkButtonDisability());

    }

//    @Then("I see a specific message for each field specifying that the field must be at least chars long")
//    public void iSeeASpecificMessageForEachFieldSpecifyingThatTheFieldMustBeAtLeastCharsLong() {
//        assertTrue(addOwnerPage.checkErrorMsg(shortInputErrorMsg));
//        addOwnerPage.closeBrowser();
//    }

    @And("I enter a non-numeric value into the phone field")
    public void iEnterANonNumericValueIntoThePhoneField() {
        addOwnerPage.enterInvalidData();

    }
//
//    @And("I see an error message specifying that the phone number only accepts digits")
//    public void iSeeAnErrorMessageSpecifyingThatThePhoneNumberOnlyAcceptsDigits() {
//        assertTrue(addOwnerPage.checkErrorMsg(numericInputErrorMsg));
//        addOwnerPage.closeBrowser();
//    }

    @And("I enter duplicate owner's details")
    public void iEnterDuplicateOwnerSDetails() {
        addOwnerPage.enterValidData();
    }

    @And("I enter symbols and numbers rather than words")
    public void iEnterSymbolsAndNumbersRatherThanWords() {
        addOwnerPage.enterSymbolsAndNumbers();
    }


    @Then("The new owner {string} will be displayed at the end of the owner's list")
    public void theNewOwnerWillBeDisplayedAtTheEndOfTheOwnerSList(String arg0) {
        assertTrue(allOwnersPage.isAdded(arg0, arg0));
        allOwnersPage.closeBrowser();
    }

    @Then("I see a specific message for each field specifying that {string}")
    public void iSeeASpecificMessageForEachFieldSpecifyingThat(String arg0) {

        assertTrue(addOwnerPage.checkErrorMsg(shortInputErrorMsg));
        addOwnerPage.closeBrowser();
    }

    @And("I see an error message specifying that {string}")
    public void iSeeAnErrorMessageSpecifyingThat(String arg0) {
        assertTrue(addOwnerPage.checkErrorMsg(numericInputErrorMsg));
        addOwnerPage.closeBrowser();
    }
}