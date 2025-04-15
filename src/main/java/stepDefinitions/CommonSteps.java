package stepDefinitions;

import common.WebCommonFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonPageObj;
import testdata.RegistrationData;

public class CommonSteps  extends WebCommonFunctions {

    private CommonPageObj commonPageObj = PageFactory.initElements(webDriver,CommonPageObj.class);

    @Given("User navigates to url {string}")
    public void user_navigates_to_url(String _baseUrl) {
        webDriver.navigate().to(_baseUrl);
    }

    @When("User logs in successfully with {string} and {string}")
    public void user_logs_in_successfully_with_and(String username, String password) throws Exception {
        commonPageObj.loginHyperLink.click();
        //
        if(!username.isBlank() && !password.isBlank())
        {
            RegistrationData.setEmail(username);
            RegistrationData.setPassword(password);
        }

        clearAndEnterTextOnElement(commonPageObj.emailInput,RegistrationData.getEmail());
        clearAndEnterTextOnElement(commonPageObj.passwordInput,RegistrationData.getPassword());
        commonPageObj.loginButton.click();
        if(!getElementFromXpath(commonPageObj.loggedInUsernameXpath(RegistrationData.getEmail())).isDisplayed())
        { throw new Exception("Failed to log in");}

        //Set username/email
        RegistrationData.setEmail(username);
    }


    @And("User logs out")
    public void userLogsOut() {
        clickElement(commonPageObj.logoutHyperLink);
        waitForElementVisibility(commonPageObj.loginHyperLink, 5);
    }
}
