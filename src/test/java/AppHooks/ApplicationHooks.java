package AppHooks;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;

    @Before(order=0)
    public void launchBrowser() {
        String browserName = ConfigReader.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browserName);
    }

    @After(order=0)
    public void quitBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
    @AfterStep
    public void takeScreenshotAfterEachStep(Scenario scenario) throws IOException {
        if (scenario.isFailed() || !scenario.isFailed()) {
        	
        	File sourcePath=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        	
            byte[] screenshot =FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(screenshot, "image/png", "Step Screenshot");
        }
    }

//    @After(order = 1)
//    public void tearDown(Scenario scenario) {
//        if (scenario.isFailed()) {
//            // take screenshot:
//            String screenshotName = scenario.getName().replaceAll(" ", "_");
//            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(sourcePath, "image/png", screenshotName);
//        }
//    }
}
