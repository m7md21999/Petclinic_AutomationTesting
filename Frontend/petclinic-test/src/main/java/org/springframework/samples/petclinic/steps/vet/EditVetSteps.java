package org.springframework.samples.petclinic.steps.vet;

import io.cucumber.java.en.*;
import org.springframework.samples.petclinic.pages.HomePage;
import org.springframework.samples.petclinic.pages.vet.AllVetsPage;
import org.springframework.samples.petclinic.pages.vet.EditVetPage;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;



public class EditVetSteps {

    private HomePage homePage = new HomePage();
    private AllVetsPage allVets;
    private EditVetPage editVet;
    private String fname = "Edited Foo";
    private String lname = "Edited Bar";
    private String validEdited = fname + " " + lname;

    //   Scenario: Successfully editing a Vet without changing type
    @Given("I am navigated to the All Veterinarian page")
    public void iAmNavigatedToTheAllVeterinarianPage() {
        allVets = homePage.goToVetsList();
        assertTrue(allVets.isCurrent());
    }

    @When("I click edit button the for the first vet")
    public void iClickEditButtonTheForTheFirstVet() {
        editVet = allVets.editFirst();
    }

    @And("I enter valid data")
    public void iEnterValidData() {
        editVet.fillData(fname, lname);
        allVets = editVet.saveAndRedirect();
    }

    @Then("The edited vet will be displayed at the end of the vets's list")
    public void theEditedVetWillBeDisplayedAtTheEndOfTheVetsSList() {
        assertTrue(allVets.exists(validEdited));
        allVets.closeBrowser();
    }

    //   Scenario: Unsuccessfully edit a Vet to be blank
    @And("I clear all data")
    public void iClearAllData() {
        editVet.fillData(" ", " ");
    }

    @But("two errors show up")
    public void twoErrorsShowUp() {
        editVet.isFieldsBlankErrorShowing();
    }

    @Then("save button is disabled")
    public void saveButtonIsDisabled() {
        assertFalse(editVet.saveButtonDisabled());
        assertTrue(editVet.isCurrent());
        editVet.closeBrowser();
    }

    //   Scenario: Successfully editing a Vet with two spaces as names
    @And("I fill fields with two spaces")
    public void iFillFieldsWithTwoSpaces() {
        editVet.fillData("  ", "  ");
        allVets = editVet.saveAndRedirect();
    }

    @Then("The edited spaces vet should not be displayed in all vets list")
    public void theEditedSpacesVetShouldNotBeDisplayedInAllVetsList() {
        assertTrue(allVets.exists("  "+" "+"  "));
        allVets.closeBrowser();

    }


    // Scenario: editing a Vet to have numbers as names
    @And("I fill fields with numbers")
    public void iFillFieldsWithNumbers() {
        editVet.fillData("123", "123");
        allVets = editVet.saveAndRedirect();

    }

    @Then("The edited numbers vet should not be displayed in all vets list")
    public void theEditedNumbersVetShouldNotBeDisplayedInAllVetsList() {
        assertFalse(allVets.exists("123 123"));
        allVets.closeBrowser();
    }

    //   Scenario: Successfully click back button from edit form
    @And("I click back button in edit vet form")
    public void iClickBackButtonInEditVetForm() {
        allVets = editVet.backAndRedirect();
    }

    @Then("I am back again in All vets page")
    public void iAmBackAgainInAllVetsPage() {
        assertTrue(allVets.isCurrent());
        allVets.closeBrowser();
    }


}

