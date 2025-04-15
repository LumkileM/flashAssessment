package stepDefinitions;

import common.WebCommonFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonPageObj;
import pageObjects.RegistrationPageObj;
import testdata.RegistrationData;

import static java.lang.System.out;

public class Register extends WebCommonFunctions {

    private CommonPageObj commonPageObj = PageFactory.initElements(webDriver,CommonPageObj.class);
    private RegistrationPageObj registrationPageObj = PageFactory.initElements(webDriver,RegistrationPageObj.class);

    @When("User clicks on register")
    public void userClicksOnRegister() {
        registrationPageObj.registerHyperLink.click();
    }

    @And("User fills registration form")
    public void userFillsRegistrationForm() {

        clickElement(registrationPageObj.maleRadioButton);
        clearAndEnterTextOnElement(registrationPageObj.firstnameInput, RegistrationData.getFirstName());
        clearAndEnterTextOnElement(registrationPageObj.lastnameInput, RegistrationData.getLastName());
        clearAndEnterTextOnElement(commonPageObj.emailInput, RegistrationData.getEmail());
        clearAndEnterTextOnElement(commonPageObj.passwordInput, RegistrationData.getPassword());
        clearAndEnterTextOnElement(registrationPageObj.confirmPasswordInput, RegistrationData.getPassword());
    }

    @And("User clicks register button")
    public void userClicksRegisterButton() {
        clickElement(registrationPageObj.registerButton);
    }

    @Then("Validate registration is successful")
    public void validateRegistrationIsSuccessful() {
        waitForElementVisibility(registrationPageObj.registrationSuccessText,5);
        registrationPageObj.registrationSuccessText.isDisplayed();
        out.println("Email Add - "+RegistrationData.getEmail());

    }
}
