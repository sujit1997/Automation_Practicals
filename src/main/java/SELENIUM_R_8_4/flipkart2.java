package SELENIUM_R_8_4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class flipkart2 {
    public static String browser = "chrome"; // Change to "firefox" or "edge" as needed
    public static WebDriver driver;

    public static void main(String[] args) {

        // Setup browser driver
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            System.out.println("Unsupported browser!");
            return;
        }

        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Close login popup if it appears
        try {
            WebElement closePopup = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'✕')]"))
            );
            closePopup.click();
        } catch (Exception e) {
            System.out.println("Login popup not displayed or already closed.");
        }

        // Search for "Kitchen Trolleys"
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
        searchBox.sendKeys("Kitchen Trolleys");
        searchBox.submit();

        // Wait until the title contains the search term
        wait.until(ExpectedConditions.titleContains("Kitchen Trolleys"));

        // Validate the title
        String actualTitle = driver.getTitle();
        if (actualTitle.contains("Kitchen Trolleys")) {
            System.out.println("✅ Page loaded successfully with title: " + actualTitle);
        } else {
            System.out.println("❌ Page title does not match. Found: " + actualTitle);
        }

        driver.quit();
    }
}
