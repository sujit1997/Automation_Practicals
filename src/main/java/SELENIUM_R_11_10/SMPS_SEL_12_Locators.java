package SELENIUM_R_11_10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class SMPS_SEL_12_Locators {
    public static String browser = "chrome";
    public static WebDriver driver;
    public static void main(String[] args) {
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            // Remove alert box
            ChromeOptions options = new ChromeOptions();

            // Disable built-in password manager prefs (still good to keep)
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("autofill.profile_enabled", false);
            prefs.put("autofill.credit_card_enabled", false);
            prefs.put("autofill.address_enabled", false);
            options.setExperimentalOption("prefs", prefs);

            // ✅ Key part: launch with a brand-new temporary profile
            String tempProfile = System.getProperty("java.io.tmpdir") + "chromeProfile_" + System.currentTimeMillis();
            options.addArguments("--user-data-dir=" + tempProfile);
            options.addArguments("--no-first-run");
            options.addArguments("--no-default-browser-check");
            options.addArguments("--disable-first-run-ui");

            // Optional: run incognito to double-block password manager
            options.addArguments("--incognito");

            // Usual convenience flags
            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--disable-autofill");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-extensions");
            options.addArguments("--start-maximized");

            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/");

        // Locators BY Name
        driver.findElement(By.name("user-name")).sendKeys("standard_user");

        // LOcators By ID
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Locators By ClassName
        // click login button
        driver.findElement(By.className("btn_action")).click();

        //CSS SELECTOR
        // click add to cart button
        driver.findElement(By.cssSelector("#inventory_container > div > div:nth-child(1) > div.pricebar > button")).click();


        //XPath
        // click on basket logo
        //driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div[2]/a/svg")).click();
        driver.findElement(By.cssSelector("#shopping_cart_container > a > svg > path")).click();

        //Link Text
        driver.findElement(By.linkText("CHECKOUT")).click();

        // FUll Xpath
        driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/form/div[1]/input[1]")).sendKeys("sujit");

        // Relative Locators
        WebElement firstname = driver.findElement(By.id("first-name"));
        WebElement lastname =  driver.findElement(with(By.tagName("input")).below(firstname));
        lastname.sendKeys("Manmode");

        // Relative LOcators
        WebElement postalcode = driver.findElement(with(By.tagName("input")).below(lastname));
        postalcode.sendKeys("442203");

        // Relative LOcators
        driver.findElement(By.xpath("//input[contains(@value,'CONTINUE')]")).click();

       // Final
        driver.findElement(By.xpath("//a[contains(@class,'btn_action cart_button')]")).click();
        driver.close();
        if (driver!= null){
            driver.quit();
            System.out.println("All test Cases Passed");
        }
            }
}