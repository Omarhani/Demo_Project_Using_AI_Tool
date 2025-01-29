package base;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.collections.Lists;
import pages.HomePage;

import java.lang.reflect.Method;

public class VisualBaseTests {
    protected WebDriver driver;
    protected HomePage homePage;
    protected Eyes eyes;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void goHome(Method method) {
        driver.get("https://automationexercise.com/");
        eyes = new Eyes();
        eyes.setApiKey(System.getenv("APPLITOOLS_API_KEY"));
        openEyes(method.getName());

    }

    private void openEyes(String testName) {
        eyes.open(driver,
                "Demo Automation Exercise",
                testName,
                new RectangleSize(1440, 900)
        );
    }

    @AfterMethod
    public void afterMethod() {
        eyes.closeAsync();
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
