package SELENIUM_;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SMPS_SEL_22_RadioButton {
    public static String browser = "chrome";
    public static WebDriver driver;
    public static void main(String[] args) {
        if(browser.equalsIgnoreCase("chrome")){
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
        driver.get("https://www.facebook.com/r.php?entry_point=login");
       WebElement radio1 =  driver.findElement(By.xpath("//*[@id=\"sex\"]"));
       radio1.click();
        System.out.println(radio1.isSelected());

        System.out.println(driver.findElements(By.className("_8esa")).size());

    }
}
