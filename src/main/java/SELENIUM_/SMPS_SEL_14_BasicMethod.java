package SELENIUM_;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SMPS_SEL_14_BasicMethod {

    public static String browser = "chrome";
    public static WebDriver driver;
    public static void main(String[] args) {

        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")) {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    } else if (browser.equalsIgnoreCase("Edge")) {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }

        // Locator (get)
        driver.get("https://www.google.com/");

        // Locator(manage)
        driver.manage().window().maximize();

        // Locator (get Current Url)
        System.out.println(driver.getCurrentUrl());

        // LOcator (get title)
        System.out.println(driver.getTitle());

        //Locator (get Page Source)
        System.out.println(driver.getPageSource());

        //Locator (navigate)
        driver.navigate().back();

        //Locator (close)
        //driver.close();

        // Locator (quit)
        driver.quit();
    }
}
