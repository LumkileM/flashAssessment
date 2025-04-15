package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CommonPageObj {


    //Login Elements
    @FindBy(how = How.XPATH, using ="//a[text()='Log in']")
    public WebElement loginHyperLink;
    @FindBy(how = How.XPATH, using ="//a[text()='Log out']")
    public WebElement logoutHyperLink;

    @FindBy(how = How.XPATH, using ="//div[@class='header-links']//a[@class='account']")
    public WebElement accountHeaderHyperLink;


    @FindBy(how = How.XPATH, using ="//input[@id='Email']")
    public WebElement emailInput;
    @FindBy(how = How.XPATH, using ="//input[@id='Password']")
    public WebElement passwordInput;
    @FindBy(how = How.XPATH, using ="//input[@value='Log in']")
    public WebElement loginButton;

    public String loggedInUsernameXpath(String username){
        if(!username.isEmpty())
        {
            return  "//a[contains(text(),'"+username+"')]";
        }
        else
            return  "username not provided";
    }



    //Computers
    @FindBy(how = How.XPATH, using ="//a[contains(text(),'Computers')]")
    public WebElement computersHeaderMenu;

    @FindBy(how = How.XPATH, using ="//div[@class='sub-category-item']//a[contains(text(),'Desktops')]")
    public WebElement desktopSubMenu;

    @FindBy(how = How.XPATH, using ="//select[@id='products-orderby']")
    public WebElement sortByDropdown;


    @FindBy(how = How.XPATH, using ="//div[@class='product-grid']")
    public WebElement productGridDiv;

    public String sortByOptionXpath()
    {return "//select[@id='products-orderby']/option";}


    public String productItemsAvailableXpath()
    {return "//div[@class='item-box']//input";}


    //Add to cart item
    @FindBy(how = How.XPATH, using ="//div[@class='product-essential']//input[@value='Add to cart']")
    public WebElement addToCartItemButton;
    @FindBy(how = How.XPATH, using ="//div[@class='product-price']//span")
    public WebElement itemPriceText;
    @FindBy(how = How.XPATH, using ="//p[@class='content'][contains(text(),'The product has been added to your')]")
    public WebElement addedToCartSuccessText;

    @FindBy(how = How.XPATH, using ="//div[@class='breadcrumb']//span[contains(text(),'Desktops')]")
    public WebElement desktopsBreadCrumbMenu;


    public String requiredSelectionXpath()
    {return "//dt//span[@class='required']";}

    public String requiredRadioButtonsXpath(String _index){
        if(!_index.isEmpty())
        {
            return  "(//dt//span[@class='required']/../following-sibling::dd)["+_index+"]//input";
        }
        else
            return  "index not provided";
    }
    @FindBy(how = How.XPATH, using ="//input[@value='Continue']")
    public WebElement continueButton;



}
