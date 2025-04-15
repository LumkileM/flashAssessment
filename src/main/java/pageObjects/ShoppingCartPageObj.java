package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ShoppingCartPageObj {

    @FindBy(how = How.XPATH, using ="//a/span[contains(text(),'Shopping cart')]")
    public WebElement shoppingCartHyperLink;

    @FindBy(how = How.XPATH, using ="//h1[contains(text(),'Shopping cart')]")
    public WebElement shoppingCartHeaderText;


    @FindBy(how = How.XPATH, using ="//span[@class='product-subtotal']")
    public WebElement itemPriceOnCartPageText;

    @FindBy(how = How.XPATH, using ="//input[@name='updatecart']")
    public WebElement updateCartButton;

    @FindBy(how = How.XPATH, using ="//td[@class='qty nobr']//input")
    public WebElement quantityFieldInputs;

    @FindBy(how = How.XPATH, using ="//input[@name='removefromcart']")
    public WebElement removeItemCheckbox;

    @FindBy(how = How.XPATH, using ="//tr[@class='cart-item-row']//span[@class='product-subtotal']")
    public WebElement itemsTotalText;
    public String itemsTotalTextXpath()
    {return "//tr[@class='cart-item-row']//span[@class='product-subtotal']";}

    @FindBy(how = How.XPATH, using ="//span[@class='product-price order-total']")
    public WebElement cartTotalText;

    @FindBy(how = How.XPATH, using ="//span[contains(text(),'Sub-Total')]//..//..//span[@class='product-price']")
    public WebElement cartSubTotalText;


    //Type country
    @FindBy(how = How.XPATH, using ="//select[@id='CountryId']")
    public WebElement countryDropdown;

    @FindBy(how = How.XPATH, using ="//input[@id='termsofservice']")
    public WebElement serviceTermsCheckbox;

    @FindBy(how = How.XPATH, using ="//button[@id='checkout']")
    public WebElement checkoutButton;
}
