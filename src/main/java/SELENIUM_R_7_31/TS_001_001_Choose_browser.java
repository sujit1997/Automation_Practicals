package SELENIUM_R_7_31;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TS_001_001_Choose_browser {
    public static String browser = "chrome";
    public static WebDriver driver;
    public static void main(String[] args) {
        if (browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://www.krushistore.com/");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Krushi Store - For The Farmers By The Farmers";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Test case passed");
        }
        else {
            System.out.println("test case failed");
        }

    }
}
