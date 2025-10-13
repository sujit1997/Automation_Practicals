package SELENIUM_;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SMPS_SEL_33_implicitWait {
    public static String browser = "chrome";
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        //  Setup browser driver
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

        driver.get("https://www.ebay.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement element = driver.findElement(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[3]"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions action = new Actions(driver);
        action.moveToElement(element).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firsstSubMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[3]/div[2]/div[1]/nav[2]/ul/li[1]/a")));
        firsstSubMenu.click();
        driver.quit();
    }
}
