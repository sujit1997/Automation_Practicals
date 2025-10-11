package SELENIUM_R_9_8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class A1_webpage_load {
    public static String browser = "chrome";
    public static WebDriver driver;
    public static void main(String[] args) {
        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }else {
            System.out.println("Enter proper browser name");
        }

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/");


    }
}
