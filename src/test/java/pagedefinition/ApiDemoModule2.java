package pagedefinition;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import pageLocators.ApiPageLocator;
import pageLocators.ApiPageLocator2;

public class ApiDemoModule2 {
    private AndroidDriver driver;
    public ApiDemoModule2(AndroidDriver driver) {
    this.driver= driver;
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    public boolean validatebuttonText(){
        return driver.findElement(ApiPageLocator2.btn_text).isDisplayed();

    }
}
