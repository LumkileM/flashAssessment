package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MyAccountPageObj {
    //re-use account link
    @FindBy(how = How.XPATH, using ="//div[@class='block block-account-navigation']//a[text()='Orders']")
    public WebElement ordersMenuLink;

    //order details
    public String orderDetailsXpath(String _option){
        if(!_option.isEmpty())
        {
            return  "//div[@class='section order-item']//strong[contains(text(),'"+_option+"')]";
        }
        else
            return  "order details not provided";
    }
}
