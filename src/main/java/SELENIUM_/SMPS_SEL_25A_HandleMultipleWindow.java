package SELENIUM_;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class SMPS_SEL_25A_HandleMultipleWindow {
    public static String browser = "chrome";
    public static WebDriver driver;

    public static void main(String[] args) {
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
            driver.get("https://www.irctc.co.in/nget/train-search");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.findElement(By.xpath("/html/body/app-root/app-home/div[1]/app-header/p-dialog[2]/div/div/div[2]/div/form/div[2]/button")).click();

            driver.findElement(By.xpath("//*[@id=\"stayIcon\"]/a/span")).click();
            Set<String> handles = driver.getWindowHandles();//Parentid, childid,

             Iterator it = handles.iterator();

            String parentid =(String) it.next();
            String childid = (String) it.next();

            driver.switchTo().window(childid);

            driver.findElement(By.xpath("/html/body/app-root/app-home/div[1]/div[3]/div/div/div/ul/li[4]/a/i")).click();

            driver.close();

    }
}