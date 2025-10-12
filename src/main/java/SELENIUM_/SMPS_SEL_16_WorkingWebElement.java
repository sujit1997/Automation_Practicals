package SELENIUM_;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SMPS_SEL_16_WorkingWebElement {
    public static String browser = "chrome";
    public static WebDriver driver;
    public static void main(String[] args) {
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://www.sugarcrm.com/au/request-demo/?utm_source=sugarcrm.com&utm_medium=referral");
        driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[1]/div/div[2]/button[4]")).click();
        //WebElement
        // SENDKEYS
        driver.findElement(By.xpath("//*[@id=\"input_1_1\"]")).sendKeys("sujit@krushistore.com");

        // Clear
        driver.findElement(By.xpath("//*[@id=\"input_1_1\"]")).clear();

        // Get Attribute
        System.out.println(driver.findElement(By.name("input_1")).getAttribute("class"));

        //Get CSS VALUE
        System.out.println(driver.findElement(By.id("gform_submit_button_1")).getCssValue("text-transform"));

        // Get Size
        System.out.println(driver.findElement(By.id("gform_submit_button_1")).getSize());

        //Get Location
        System.out.println(driver.findElement(By.id("gform_submit_button_1")).getLocation());

        //Get Tagname
        System.out.println(driver.findElement(By.id("gform_submit_button_1")).getTagName());

        //Get Text
        System.out.println(driver.findElement(By.className("mb-5")).getText());

        //isDisplayed
        System.out.println(driver.findElement(By.id("gform_submit_button_1")).isDisplayed());

        //isEnabled
        System.out.println(driver.findElement(By.id("gform_submit_button_1")).isEnabled());

        //isSelected
        System.out.println(driver.findElement(By.id("gform_submit_button_1")).isSelected());

    }
}
