package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverUtil;

import java.time.Duration;
import java.util.List;

import static java.lang.System.out;

public class WebCommonFunctions extends WebDriverUtil {



    public boolean waitForElementVisibility(WebElement ele, int timeOutSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeOutSeconds));
            wait.until(ExpectedConditions.visibilityOf(ele));
            return true;
        }catch (Exception e){
            return  false;
        }
    }

    public boolean isElementClickable(WebElement ele, int timeOutSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeOutSeconds));
            wait.until(ExpectedConditions.elementToBeClickable(ele));
            return true;
        }catch (Exception e){
            return  false;
        }
    }
    public boolean isElementClickableAfterRefresh(WebElement ele, int timeOutSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeOutSeconds));
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(ele)));
            return true;
        }catch (Exception e){
            out.println("isElementClickableAfterRefresh: - "+e.getMessage());
            return  false;
        }
    }
    public WebElement getElementFromXpath(String xpathToUse) {
        try {
            WebElement element = webDriver.findElement(By.xpath(xpathToUse));
            if(waitForElementVisibility(element,5)) {
                return element;
            }
            return null;
        }catch (Exception e){
            return  null;
        }
    }
    public WebElement getElementFromXpath(WebElement _element,String xpathToUse) {
        try {
            WebElement element = _element.findElement(By.xpath(xpathToUse));
            if(waitForElementVisibility(element,5)) {
                return element;
            }
            return null;
        }catch (Exception e){
            return  null;
        }
    }
    public void clearAndEnterTextOnElement(WebElement element, String textToEnter) {
        element.clear();
        element.sendKeys(textToEnter);
    }

    public List<WebElement> getElementsFromXpath(String xpathToUse) {
        try {
            List<WebElement> elements = webDriver.findElements(By.xpath(xpathToUse));
            if(waitForElementVisibility(elements.get(0),5)) {
                return elements;
            }
            return null;
        }catch (Exception e){
            return  null;
        }
    }
    public List<WebElement> getElementsFromXpath(WebElement element,String xpathToUse) {
        try {
            List<WebElement> elements = element.findElements(By.xpath(xpathToUse));
            if(waitForElementVisibility(elements.get(0),5)) {
                return elements;
            }
            return null;
        }catch (Exception e){
            return  null;
        }
    }
    public void clickElement(WebElement element)
    {
        isElementClickable(element,5);
        element.click();
    }

}
