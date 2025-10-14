package TESTNG;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class
TESTNG_1_BrowserSelect {
    public static String browser = "chrome";
    public static WebDriver driver;
  @BeforeTest
    public void selectBrowser(){
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
    }
    @Test
    public void test() {
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        System.out.println("Page title is :" + driver.getTitle());
        assertTrue(driver.getTitle().contains("Google"));
    }
    @AfterTest
    public void tearDownTest(){
      driver.quit();
    }
}