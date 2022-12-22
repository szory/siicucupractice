package siicucupractice.config;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

import static siicucupractice.config.WebDriverSingleton.quit;
import static siicucupractice.config.WebDriverSingleton.getInstance;

public class TestConfig {

    private WebDriver driver;
    static String browserType=System.getProperty("browserType")==null?"chrome":System.getProperty("browserType");
    //static String incrementVar=System.getProperty("incrementVar");

    public TestConfig(){

    }

    @Before
    public void setUp() {
        String baseUrl = "http://automationpractice.com/index.php";
        System.out.println("browserType "+browserType);
        driver = getInstance();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) getInstance()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "name");
            scenario.log("HEJ JEST Błąd");
        }
        quit();
    }
}