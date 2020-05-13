package org.springframework.samples.petclinic.steps.visit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.samples.petclinic.pages.HomePage;
import org.springframework.samples.petclinic.pages.owner.AllOwnersPage;
import org.springframework.samples.petclinic.pages.owner.OwnerInformationPage;
import org.springframework.samples.petclinic.pages.visit.AddVisitPage;
import org.springframework.samples.petclinic.pages.visit.EditVisitPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class EditVisitSteps {

    private HomePage homePage = new HomePage();
    private AllOwnersPage allOwnersPage;
    private OwnerInformationPage ownerInformationPage;
    private EditVisitPage editVisitPage;
    private AddVisitPage addVisitPage;

    @Given("I am on the Edit-visit form")
    public void iAmOnTheEditVisitForm() {
        allOwnersPage = homePage.goToOwnersList();
        ownerInformationPage = allOwnersPage.getSixthOwner();
        editVisitPage = ownerInformationPage.editVisitPage();
    }

    @When("I re-enter the visit-form data")
    public void iReEnterTheVisitFormData() {
        editVisitPage.reFillEditForm();
    }

    @And("I click submit update button")
    public void iClickSubmitUpdateButton() {
        ownerInformationPage = editVisitPage.submitEditForm();
    }

    @Then("The updated visit will be displayed in the owner's page list")
    public void theUpdatedVisitWillBeDisplayedInTheOwnerSPageList() {
        assertEquals("This will be deleted after update",ownerInformationPage.visitUpdatedSuccessfully());
        ownerInformationPage.closeBrowser();
    }

    @And("I remove all values from all fields")
    public void iRemoveAllValuesFromAllFields() {
        editVisitPage.emptyFields();
    }

    @Given("I am on the add-visit page")
    public void iAmOnTheAddVisitPage() {
        allOwnersPage = homePage.goToOwnersList();
        ownerInformationPage = allOwnersPage.getSixthOwner();
        addVisitPage = ownerInformationPage.addNewVisit();
        addVisitPage.isCurrent();
    }

    @When("I re-enter the visit-form data with invalid data")
    public void iReEnterTheVisitFormDataWithInvalidData() {
        editVisitPage.reFillInvalidData();

    }

    @Then("I will stay on the same page")
    public void iWillStayOnTheSamePage() {
        assertFalse(ownerInformationPage.isCurrent());
        ownerInformationPage.closeBrowser();
    }
}