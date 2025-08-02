package SELENIUM_R_8_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTutorial_012 {
    public static String browser = "chrome";
    public static WebDriver driver;
    public static void main(String[] args) {
    if(browser.equals("chrome")){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    } else if (browser.equals("Edge")) {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    } else if (browser.equals("forefox")) {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
    driver.manage().window().maximize();
    driver.get("https://www.krushistore.com/");

    //LOCATORS
    // Class Name
    // Link Text
    driver.findElement(By.linkText("Solar Fence")).click();
    // X-path
    driver.findElement(By.xpath("//*[@id='app-header']/div[2]/div/div[2]/div[2]/div/div[1]")).click();
    // driver.findElement(By.xpath("//*[contains(@class, 'w-[29px]')]")).click();



    }
}
