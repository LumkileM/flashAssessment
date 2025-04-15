package stepDefinitions;

import common.WebCommonFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CheckoutPageObj;
import pageObjects.CommonPageObj;
import pageObjects.ShoppingCartPageObj;
import testdata.OrderData;

import java.util.List;

import static java.lang.System.in;
import static java.lang.System.out;

public class PlaceOrder extends WebCommonFunctions {

    private CommonPageObj commonPageObj = PageFactory.initElements(webDriver,CommonPageObj.class);
    private CheckoutPageObj checkoutPageObj = PageFactory.initElements(webDriver,CheckoutPageObj.class);
    private ShoppingCartPageObj shoppingCartPageObj = PageFactory.initElements(webDriver,ShoppingCartPageObj.class);
    @When("User navigates to Computers and desktop page")
    public void user_navigates_to_computers_ans_desktop_page() {
        commonPageObj.computersHeaderMenu.click();
        clickElement(commonPageObj.desktopSubMenu);
    }
    @And("Sorts items with all options")
    public void sortsItemsWithAllOptions() throws Exception{
        //Sort items with all options available
        //Get number of options available to sort by
        commonPageObj.sortByDropdown.click();
        List<WebElement> sortByOptions;
        List<WebElement> noOfSortOptions = getElementsFromXpath(commonPageObj.sortByOptionXpath());
        if(noOfSortOptions !=null && !noOfSortOptions.isEmpty()) {

            for(int i=0;i<noOfSortOptions.size();i++)
            {
                 sortByOptions = getElementsFromXpath(commonPageObj.sortByOptionXpath());
                 clickElement(sortByOptions.get(i));
                 waitForElementVisibility(commonPageObj.productGridDiv,5);
            }
            //Sort by default
            List<WebElement> defaultSortOptions = getElementsFromXpath(commonPageObj.sortByOptionXpath());
            clickElement(defaultSortOptions.get(0));
        }
        else {out.println("No Sort Options found");}
    }
    @When("User adds all available items to cart")
    public void user_adds_all_available_items_to_cart() throws Exception {
        //Get item lists available
        List<WebElement> itemsAvailable;
        List<WebElement> noOfItemsAvailable = getElementsFromXpath(commonPageObj.productItemsAvailableXpath());

        if(noOfItemsAvailable !=null && !noOfItemsAvailable.isEmpty())
        {
            out.println("No of items available = "+noOfItemsAvailable.size());
            for(int i=0;i<noOfItemsAvailable.size();i++)
            {
                itemsAvailable = getElementsFromXpath(commonPageObj.productItemsAvailableXpath());
                clickElement(itemsAvailable.get(i));

                //Wait for page load, check required fields then add to cart
                isElementClickable(commonPageObj.addToCartItemButton, 5);
                isRequiredFieldsSelected();
                commonPageObj.addToCartItemButton.click();
                waitForElementVisibility(commonPageObj.addedToCartSuccessText, 5);
                //Return to desktop page to add more items to cart
                clickElement(commonPageObj.desktopsBreadCrumbMenu);
                out.println("item added = "+i);
            }

        }
        else {out.println("No items available to be added to cart");}

    }


    public  void isRequiredFieldsSelected()
    {
        List<WebElement> requiredSelections = getElementsFromXpath(commonPageObj.requiredSelectionXpath());

        if(requiredSelections != null && !requiredSelections.isEmpty())
        {
            for(int i=1; i<=requiredSelections.size();i++)
            {
                List<WebElement> radioButtons = getElementsFromXpath(commonPageObj.requiredRadioButtonsXpath(String.valueOf(i)));
                if(radioButtons!=null && !radioButtons.isEmpty())
                {
                    boolean isRequiredSelected = false;
                    for(WebElement radioButton:radioButtons)
                    {
                        if(radioButton.isSelected())
                        {
                            isRequiredSelected = true;
                            break;
                        }
                    }
                    //Select required field if none is selected
                    if(!isRequiredSelected)
                    {
                        radioButtons.get(0).click();
                    }
                }
                else {out.println("No required fields unselected");}

            }
        }
    }

    @When("User views shopping cart")
    public void user_views_shopping_cart() {
      shoppingCartPageObj.shoppingCartHyperLink.click();
      waitForElementVisibility(shoppingCartPageObj.shoppingCartHeaderText, 5);
      //Assert totals
        assertTotalsOnCartPage();
    }

    public void assertTotalsOnCartPage()
    {
        waitForElementVisibility(shoppingCartPageObj.cartSubTotalText, 3);
        double cartTotal = Double.parseDouble(shoppingCartPageObj.cartSubTotalText.getText().trim());
        double aggregatedItemsTotal = 0;

        //Add up totals
        List<WebElement> itemTotals = getElementsFromXpath(shoppingCartPageObj.itemsTotalTextXpath());

        if(itemTotals !=null && !itemTotals.isEmpty())
        {
            out.println("Items Total = "+itemTotals.size());
            for(WebElement itemTotal:itemTotals)
            {
                aggregatedItemsTotal += Double.parseDouble(itemTotal.getText().trim());
            }
        }
        out.println("Cart Total = "+cartTotal);
        out.println("Aggregated Total = "+aggregatedItemsTotal);
        Assert.assertEquals(String.valueOf(cartTotal),String.valueOf(aggregatedItemsTotal));
    }

    @When("User removes item from cart")
    public void user_removes_item_from_cart() {
        shoppingCartPageObj.removeItemCheckbox.click();
        shoppingCartPageObj.updateCartButton.click();
        waitForElementVisibility(shoppingCartPageObj.updateCartButton, 4);
        //Assert totals
        assertTotalsOnCartPage();
    }

    @When("User checks out items in cart")
    public void user_checks_out_items_in_cart() throws Exception{

        shoppingCartPageObj.countryDropdown.sendKeys(OrderData.getCountry());
        shoppingCartPageObj.serviceTermsCheckbox.click();
        shoppingCartPageObj.checkoutButton.click();
        waitForElementVisibility(checkoutPageObj.checkoutHeaderText, 5);
        //if billing address is not available, add address
        if(!waitForElementVisibility(checkoutPageObj.billingAddressDropdown, 5)) {
            checkoutPageObj.billingCountryDropdown.sendKeys(OrderData.getCountry());
            clearAndEnterTextOnElement(checkoutPageObj.billingCityInput, OrderData.getCity());
            clearAndEnterTextOnElement(checkoutPageObj.billingAddressInput, OrderData.getAddress());
            clearAndEnterTextOnElement(checkoutPageObj.billingPostalCodeInput, OrderData.getPostalCode());
            clearAndEnterTextOnElement(checkoutPageObj.billingPhoneInput, OrderData.getPhoneNumber());
        }
        //Continue with checkout sections
        clickElement(checkoutPageObj.billingContinueButton);
        clickElement(checkoutPageObj.shippingContinueButton);
        clickElement(checkoutPageObj.shippingMethodContinueButton);
        clickElement(checkoutPageObj.paymentMethodContinueButton);
        clickElement(checkoutPageObj.paymentInfoContinueButton);
        clickElement(checkoutPageObj.confirmButton);
    }

    @Then("Validate order is placed successfully")
    public void validate_order_is_placed_successfully() throws Exception{

        if(!waitForElementVisibility(checkoutPageObj.orderSuccessText, 5))
        {
            throw new Exception("Order not placed successfully");
        }
        // Set order number for later use
        waitForElementVisibility(checkoutPageObj.orderNumberText, 5);
        OrderData.setOrderNumber(checkoutPageObj.orderNumberText.getText().split(":")[1].trim());
        out.println("Order No = "+OrderData.getOrderNumber());
    }



}
