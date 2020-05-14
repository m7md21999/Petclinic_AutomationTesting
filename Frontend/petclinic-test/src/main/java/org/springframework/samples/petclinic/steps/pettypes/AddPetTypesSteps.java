package org.springframework.samples.petclinic.steps.pettypes;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.samples.petclinic.pages.HomePage;
import org.springframework.samples.petclinic.pages.petTypesPage.PetTypesPage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class    AddPetTypesSteps {

    private HomePage homePage = new HomePage();
    private PetTypesPage petTypesPage;


    @Given("I am on the Pet Type form")
    public void iAmOnThePetTypeForm() {
        petTypesPage =  homePage.goToPetTypes();
        assertTrue(petTypesPage.isCurrent());

    }

    @When("I Clinic add button")
    public void iClinicAddButton() {
        petTypesPage.clickAddButton();
    }

    @And("I Enter Valid Pet Type name")
    public void iEnterValidPetTypeName() {
        petTypesPage.fillAddFiled("Dog");
    }

    @Then("The new Pet Type will be displayed at the end of the Pet Type's list")
    public void theNewPetTypeWillBeDisplayedAtTheEndOfThePetTypeSList() {
        assertTrue(petTypesPage.chickAdd());
        petTypesPage.closeBrowser();

    }


    @And("I enter symbols and numbers rather than words data")
    public void iEnterSymbolsAndNumbersRatherThanWordsData() {
        petTypesPage.fillAddFiled("@#@%^&$568");

    }

    @And("I enter then remove value from the field")
    public void iEnterThenRemoveValueFromTheField() {
        petTypesPage.fillAddFiled("Cat");
        petTypesPage.removeText();

    }

    @Then("The add button is give no action")
    public void theAddButtonIsGiveNoAction() {
        petTypesPage.isCurrent("body > app-root > app-pettype-list > div > div > div:nth-child(3) > app-pettype-add > div > div > h2","New Pet Type");
        petTypesPage.closeBrowser();
    }

    @And("I submit the pet-type name")
    public void iSubmitThePetTypeName() {
        petTypesPage.clickSaveButton();

    }

    @Then("The new Pet Type will not be displayed at the end of the Pet Type's list")
    public void theNewPetTypeWillNotBeDisplayedAtTheEndOfThePetTypeSList() {
        assertFalse(petTypesPage.chickAdd());
        petTypesPage.closeBrowser();
    }
}