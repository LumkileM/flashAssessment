package stepDefinitions;

import common.CommonFunctions;
import io.cucumber.java.*;
import testdata.RegistrationData;
import utils.WebDriverUtil;

public class WebHook extends WebDriverUtil {

    @Before()
    public  void BeforeScenario() throws Exception{
        webDriver = getWebDriver();
        //Set Up test data
        CommonFunctions commonFunctions = new CommonFunctions();
        RegistrationData.setEmail(commonFunctions.generateEmailAddress());
    }

    @After()
    public void AfterScenario(Scenario scenario) throws Exception{
        if(webDriver != null)
            webDriver.quit();
    }

//    @BeforeAll()
//    public static void before_all() throws Exception
//    {
//        //Set Up test data
//        CommonFunctions commonFunctions = new CommonFunctions();
//        RegistrationData.setEmail(commonFunctions.generateEmailAddress());
//    }

    @AfterAll()
    public static void after_all() throws Exception
    {
        if(webDriver != null)
            webDriver.quit();

    }

}