package SELENIUM_R_8_4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Selenium_13_E_tutorial_contains {
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
        driver.get("https://www.salesforce.com/in/form/signup/freetrial-salesforce-starter/?d=jumbo1-btn-ft");
        // USE CONTAINS to select tag
        driver.findElement(By.xpath("//input[contains(@id,'UserFirstName')]")).sendKeys("sujit");
        driver.findElement(By.xpath("//input[contains(@id,'UserLastName')]")).sendKeys("Manmode");
       WebElement jobTitleDropdown = driver.findElement(By.xpath("//select[contains(@id,'UserTitle')]"));
      new Select(jobTitleDropdown).selectByVisibleText("Developer / Software Engineer");

    }
}
