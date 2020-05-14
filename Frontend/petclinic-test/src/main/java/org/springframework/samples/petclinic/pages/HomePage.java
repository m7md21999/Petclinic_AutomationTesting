package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.samples.petclinic.pages.owner.AddOwnerPage;
import org.springframework.samples.petclinic.pages.owner.AllOwnersPage;
import org.springframework.samples.petclinic.pages.petTypesPage.PetTypesPage;
import org.springframework.samples.petclinic.pages.vet.AddVetPage;
import org.springframework.samples.petclinic.pages.vet.AllVetsPage;

public class HomePage extends Page {

    private static final String URL = "http://localhost:8081/petclinic/";

    private String pathOwnersDropdown = "body > app-root > div.container-fluid > nav > div > ul > li:nth-child(2) > a";
    private String pathOwners = "body > app-root > div.container-fluid > nav > div > ul > li.dropdown.open > ul > li:nth-child(1) > a";
    private String pathAddOwner = "body > app-root > div.container-fluid > nav > div > ul > li.dropdown.open > ul > li:nth-child(2) > a";
    private String pathVetsDropdown = "body > app-root > div.container-fluid > nav > div > ul > li:nth-child(3) > a";
    private String pathVets = "body > app-root > div.container-fluid > nav > div > ul > li.dropdown.open > ul > li:nth-child(1) > a";
    private String pathAddVet = "body > app-root > div.container-fluid > nav > div > ul > li.dropdown.open > ul > li:nth-child(2) > a";
    private String pathPetTypes = "body > app-root > div.container-fluid > nav > div > ul > li:nth-child(4) > a";
    private String pathSpecialties = "body > app-root > div.container-fluid > nav > div > ul > li:nth-child(5) > a";




    public HomePage() {
        super("Welcome",new ChromeDriver(new ChromeOptions().addArguments("--headless")));
//        super("Welcome",new ChromeDriver());
        goToHome();
    }

    public void goToHome() {
        super.goTo(URL);
    }

    public AddOwnerPage goToAddOwner() {
        cssClick(pathOwnersDropdown);
        cssClick(pathAddOwner);
        return new AddOwnerPage(driver);
    }


    public AllOwnersPage goToOwnersList(){
        cssClick(pathOwnersDropdown);
        cssClick(pathOwners);
        return new AllOwnersPage(driver);
    }


    public AddVetPage goToAddVet(){
        cssClick(pathVetsDropdown);
        cssClick(pathAddVet);
        return new AddVetPage(driver);
    }

    public AllVetsPage goToVetsList(){
        cssClick(pathVetsDropdown);
        cssClick(pathVets);
        return new AllVetsPage(driver);
    }



    public PetTypesPage goToPetTypes(){
        cssClick(pathPetTypes);
        return new PetTypesPage(driver);
    }


}
