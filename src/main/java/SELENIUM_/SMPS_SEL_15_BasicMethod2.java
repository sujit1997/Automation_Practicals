package SELENIUM_;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SMPS_SEL_15_BasicMethod2 {
    public static String browser = "chrome";
    public static WebDriver driver;
    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://www.irctctourism.com/");
        driver.findElement(By.xpath("/html/body/app-root/tourpkgs/div[2]/div[2]/ul/li[3]/a/div")).click();

        Set<String> handles = driver.getWindowHandles();
        Iterator it = handles.iterator();
        String parentid =(String) it.next();
        String childid = (String) it.next();
        driver.switchTo().window(childid);

        driver.findElement(By.xpath("//*[@id=\"departFrom\"]")).sendKeys("Amravati");
        System.out.println(parentid);
        System.out.println(childid);


    }
}
