package org.springframework.samples.petclinic.steps.owner;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.samples.petclinic.pages.*;
import org.springframework.samples.petclinic.pages.owner.AllOwnersPage;
import org.springframework.samples.petclinic.pages.owner.EditOwnerPage;
import org.springframework.samples.petclinic.pages.owner.OwnerInformationPage;

import java.util.logging.Level;

import static java.util.logging.Logger.getLogger;
import static org.junit.Assert.assertTrue;

public class EditOwnerSteps {

    private HomePage homePage;
    private AllOwnersPage allOwnersPage;
    private OwnerInformationPage ownerInformationPage;
    private EditOwnerPage editOwnerPage;



    @Given("I am on the edit owner information form")
    public void iAmOnTheEditOwnerInformationForm() {
        homePage = new HomePage();
        //homePage.clickOwners();
        allOwnersPage = homePage.goToOwnersList();
        ownerInformationPage = allOwnersPage.clickOnAnOwner();
        editOwnerPage = ownerInformationPage.clickEditOwner();
        assertTrue(editOwnerPage.isCurrent());
    }

    @And("I clear all fields of edit owner form")
    public void iClearAllFields() {
        editOwnerPage.clearField();
    }

    @And("I Enter owner updated valid data")
    public void iEnterUpdatedValidData() {
        editOwnerPage.enterValidUpdatedData();
    }

    @When("I submit the edit owner form")
    public void iSubmitTheEditForm() {
        ownerInformationPage = editOwnerPage.submit();
    }

    @Then("The updated owner will be displayed in the Owner page with updated information")
    public void theUpdatedOwnerWillBeDisplayedInTheOwnerPageWithUpdatedInformation() {
        assertTrue(ownerInformationPage.isUpdated("Updated", "Updated"));
        ownerInformationPage.closeBrowser();
    }


    @Then("The current owner data are pre-set in the fields")
    public void theCurrentOwnerDataArePreSetInTheFields() {
        assertTrue(editOwnerPage.checkRetrieval());
        editOwnerPage.closeBrowser();
    }

    @And("I enter non numeric telephone data")
    public void iEnterNonNumericTelephoneData() {
        editOwnerPage.enterInvalidTelephone();
    }

    @Then("The owner edit submit button is disabled")
    public void theEditSubmitButtonIsDisabled() {
        assertTrue(editOwnerPage.checkButtonDisability());
        editOwnerPage.closeBrowser();
    }
    @And("I Edit key fields with symbols and numbers rather than words")
    public void iEditKeyFieldsWithSymbolsAndNumbersRatherThanWords() {
        editOwnerPage.enterSymbolsAndNumbers();
    }
}