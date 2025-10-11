package SELENIUM_R_11_10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SMPS_SEL_1_Choose_Browser{

    public static String browser = "chrome";
    public static WebDriver driver;
    public static void main(String[] args) {

      if(browser.equalsIgnoreCase("chrome")){
          WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver();
      } else if (browser.equalsIgnoreCase("firefox")) {
          WebDriverManager.firefoxdriver().setup();
          driver = new FirefoxDriver();
      } else if (browser.equalsIgnoreCase("Edge")) {
          WebDriverManager.edgedriver().setup();
          driver = new EdgeDriver();
      }
      driver.manage().window().maximize();
      driver.get("https://www.saucedemo.com/v1/");
        System.out.println(driver.getCurrentUrl());
        driver.close();

    }
}