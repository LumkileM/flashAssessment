package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckoutPageObj {

    @FindBy(how = How.XPATH, using ="//h1[contains(text(),'Checkout')]")
    public WebElement checkoutHeaderText;
    @FindBy(how = How.XPATH, using ="//select[@id='billing-address-select']")
    public WebElement billingAddressDropdown;

    @FindBy(how = How.XPATH, using ="//select[@id='BillingNewAddress_CountryId']")
    public WebElement billingCountryDropdown;
    @FindBy(how = How.XPATH, using ="//input[@id='BillingNewAddress_City']")
    public WebElement billingCityInput;
    @FindBy(how = How.XPATH, using ="//input[@id='BillingNewAddress_Address1']")
    public WebElement billingAddressInput;
    @FindBy(how = How.XPATH, using ="//input[@id='BillingNewAddress_ZipPostalCode']")
    public WebElement billingPostalCodeInput;
    @FindBy(how = How.XPATH, using ="//input[@id='BillingNewAddress_PhoneNumber']")
    public WebElement billingPhoneInput;

    //Re-use continue button
    @FindBy(how = How.XPATH, using ="//li[@id='opc-billing']//input[@value='Continue']")
    public WebElement billingContinueButton;
    @FindBy(how = How.XPATH, using ="//li[@id='opc-shipping']//input[@value='Continue']")
    public WebElement shippingContinueButton;
    @FindBy(how = How.XPATH, using ="//li[@id='opc-shipping_method']//input[@value='Continue']")
    public WebElement shippingMethodContinueButton;
    @FindBy(how = How.XPATH, using ="//li[@id='opc-payment_method']//input[@value='Continue']")
    public WebElement paymentMethodContinueButton;
    @FindBy(how = How.XPATH, using ="//li[@id='opc-payment_info']//input[@value='Continue']")
    public WebElement paymentInfoContinueButton;

    //Confirm
    @FindBy(how = How.XPATH, using ="//input[@value='Confirm']")
    public WebElement confirmButton;
    @FindBy(how = How.XPATH, using ="//strong[contains(text(),'Your order has been successfully processed!')]")
    public WebElement orderSuccessText;

    @FindBy(how = How.XPATH, using ="//ul[@class='details']/li[1]")
    public WebElement orderNumberText;
}
