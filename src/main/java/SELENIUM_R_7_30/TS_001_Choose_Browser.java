package SELENIUM_R_7_30;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TS_001_Choose_Browser {
    public static String browser = "chrome";
    public static WebDriver driver;
    public static void main(String[] args) {
        if (browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://www.krushistore.com/");

        //Check title
        String actualTitle = driver.getTitle();
        String expectedTitle = "Krushi Store - For The Farmers By The Farmers";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("test case passed");
        }
        else {
            System.out.println("test case failed");
        }
        driver.quit();
    }
}
