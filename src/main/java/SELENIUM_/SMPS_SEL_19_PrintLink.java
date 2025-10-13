package SELENIUM_;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class SMPS_SEL_19_PrintLink {
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
        driver.get("https://www.sugarcrm.com/au/?utm_source=google.com&utm_medium=organic");

        List<WebElement> alltags = driver.findElements(By.tagName("a"));
        System.out.println("Total tags are :" +alltags.size());

        for(int i=0;i<alltags.size();i++){
            System.out.println("Links on the page are" +alltags.get(i).getAttribute("href"));
            System.out.println("Links on the page are" +alltags.get(i).getText());

        }
    }
}
