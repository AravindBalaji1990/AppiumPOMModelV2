package TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagedefinition.ApiDemoModule;
import utilitypack.CommonUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AndroidRun{
    public AndroidDriver driver ;
    public ApiDemoModule apidemomodule;
//    AppiumDriverLocalService service =AppiumDriverLocalService.buildDefaultService();
AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();

    @BeforeMethod
    public void start() throws InterruptedException, MalformedURLException {
        System.out.println("this is start of my project");
//        service.start();
        serviceBuilder.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(200))
                .build().start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);

        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");
        options.setAppWaitForLaunch(true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        Thread.sleep(3000);


    }

    @AfterMethod
    public void teardown() {
        System.out.println("this is teardown of my project");
//        service.stop();
    }

    @Test
    public void testcase() {

        apidemomodule = new ApiDemoModule(driver);
        Assert.assertTrue(apidemomodule.validatebutton());

    }

}
