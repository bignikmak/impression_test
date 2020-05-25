import PO.MainPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestSetUp {
    WebDriver driver;
    MainPage mainPage;

    @BeforeMethod
    public void setUp(ITestContext context) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        context.setAttribute("webDriver", driver);
        mainPage = new MainPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
