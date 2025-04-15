package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPageObj {


    @FindBy(how = How.XPATH, using ="//a[text()='Register']")
    public WebElement registerHyperLink;

    @FindBy(how = How.XPATH, using ="//input[@id='gender-male']")
    public WebElement maleRadioButton;

    @FindBy(how = How.XPATH, using ="//input[@id='FirstName']")
    public WebElement firstnameInput;

    @FindBy(how = How.XPATH, using ="//input[@id='LastName']")
    public WebElement lastnameInput;
   //Email
    //Password
    //Confirm Password
   @FindBy(how = How.XPATH, using ="//input[@id='ConfirmPassword']")
   public WebElement confirmPasswordInput;
    @FindBy(how = How.XPATH, using ="//input[@id='register-button']")
    public WebElement registerButton;

    @FindBy(how = How.XPATH, using ="//div[contains(text(),'Your registration completed')]")
    public WebElement registrationSuccessText;
   //Continue Button



    //tester000001@test.com
    //Password01

    @FindBy(how = How.XPATH, using ="//button[contains(text(),'Submit')]")
    public WebElement submitButton;

}
