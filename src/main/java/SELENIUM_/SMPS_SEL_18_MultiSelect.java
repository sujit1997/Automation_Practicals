package SELENIUM_;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SMPS_SEL_18_MultiSelect {
    public static String browser = "chrome";
    public static WebDriver driver;

    public static void main(String[] args) {
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
        driver.manage().window().maximize();
        driver.get("https://admirhodzic.github.io/multiselect-dropdown/demo.html?utm_source=chatgpt.com");

        WebElement ddown = driver.findElement(By.className("smart-drop-down-button"));
        Select select = new Select(ddown);
        select.selectByVisibleText("Affogato");
        select.selectByVisibleText("Bicerin");
        List<WebElement> allItem = select.getAllSelectedOptions();
        System.out.println(allItem.size());

        select.deselectAll();
    }
}