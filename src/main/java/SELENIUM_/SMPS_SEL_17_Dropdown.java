package SELENIUM_;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SMPS_SEL_17_Dropdown {
    public static String browser = "chrome";
    public static WebDriver driver;
    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://www.sugarcrm.com/au/request-demo/?utm_source=sugarcrm.com&utm_medium=referral");


        //SELECT
        WebElement ddown = driver.findElement(By.name("input_8"));
        Select select = new Select(ddown);
        select.selectByValue("level1");

        WebElement ddown1 = driver.findElement(By.name("input_84"));
        Select select1 = new Select(ddown1);
        select1.selectByVisibleText("India");



    }
}
