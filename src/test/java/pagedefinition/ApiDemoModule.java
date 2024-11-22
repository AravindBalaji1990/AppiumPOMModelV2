package pagedefinition;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageLocators.ApiPageLocator;

public class ApiDemoModule  {
    private AndroidDriver driver;
    public ApiDemoModule(AndroidDriver driver) {
    this.driver= driver;
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    // we can mention the actions to be perfomed here or else we can just do
    // a return of the element and validate it in the main class
    public boolean validatebutton(){
        return driver.findElement(ApiPageLocator.btn_views).isDisplayed();

    }
}
