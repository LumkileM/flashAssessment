package stepDefinitions;

import common.WebCommonFunctions;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonPageObj;
import pageObjects.MyAccountPageObj;
import testdata.OrderData;
import testdata.RegistrationData;
import utils.WebDriverUtil;

public class MyAccount extends WebCommonFunctions {

    private CommonPageObj commonPageObj = PageFactory.initElements(webDriver,CommonPageObj.class);
    private MyAccountPageObj myAccountPageObj = PageFactory.initElements(webDriver,MyAccountPageObj.class);
    @And("View order details on my account")
    public void viewOrderDetailsOnMyAccount() throws Exception {

        clickElement(commonPageObj.accountHeaderHyperLink);
        clickElement(myAccountPageObj.ordersMenuLink);
        //Verify order is displayed
        WebElement orderElement = getElementFromXpath(myAccountPageObj.orderDetailsXpath(OrderData.getOrderNumber()));
        if (orderElement == null)
            throw new Exception("Order Not found on my account");


    }
}
