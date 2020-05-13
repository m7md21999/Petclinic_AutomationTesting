package org.springframework.samples.petclinic.steps.pet;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.samples.petclinic.pages.HomePage;
import org.springframework.samples.petclinic.pages.owner.AllOwnersPage;
import org.springframework.samples.petclinic.pages.owner.OwnerInformationPage;
import org.springframework.samples.petclinic.pages.pet.AddPetPage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AddPetSteps {

    private HomePage homePage = new HomePage();
    private AllOwnersPage allOwnersPage;
    private OwnerInformationPage ownerInformationPage;
    private AddPetPage addPetPage;
    private String name = "Test";
    private String birthDate = "2020/04/13";
    private int index = 2;
    private String nameWithSymbols = "^5$%^";

    @Given("I am on the add-pet form")
    public void iAmOnTheAddPetForm() {
        allOwnersPage = homePage.goToOwnersList();
        ownerInformationPage = allOwnersPage.getFirstOwner();
        addPetPage = ownerInformationPage.addNewPet();
        assertTrue(addPetPage.isCurrent());
    }

    @And("I enter valid pet data")
    public void iEnterValidPetData() {
        addPetPage.fillInForm(name, birthDate, index);
    }
    @When("I submit the add-pet form")
    public void iSubmitTheAddPetForm() {
        ownerInformationPage = addPetPage.submit();

    }

    @Then("The new pet will be displayed at the owner information page")
    public void theNewPetWillBeDisplayedAtTheOwnerInformationPage() {
        assertTrue(ownerInformationPage.petNames().contains(name));
        ownerInformationPage.closeBrowser();
    }

    @And("I leave all the fields empty")
    public void iLeaveAllTheFieldsEmpty() {
        ownerInformationPage = addPetPage.submit();
    }

    @And("I enter a non-date formatted value into the birth date field")
    public void iEnterANonDateFormattedValueIntoTheBirthDateField() {
        addPetPage.fillInForm(name, "abc", index);
    }

    @And("I enter symbols and numbers rather than words in the name field")
    public void iEnterSymbolsAndNumbersRatherThanWordsInTheNameField() {
        addPetPage.fillInForm(nameWithSymbols, birthDate, index);
    }

    @Then("I remain in the add pet page")
    public void iRemainInTheAddPetPage() {
        assertTrue(addPetPage.isCurrent());
        addPetPage.closeBrowser();
    }


    @Then("The new pet will not be added")
    public void theNewPetWillNotBeAdded() {
        assertFalse(ownerInformationPage.petNames().contains(nameWithSymbols));
        ownerInformationPage.closeBrowser();
    }
}