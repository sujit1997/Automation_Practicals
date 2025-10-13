package SELENIUM_;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.description.field.FieldList;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class SMPS_SEL_38_Screenshot {
    public static String browser = "chrome";
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException, IOException {
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
//          Capture screenshot
//        driver.get("https://www.w3schools.com/");
//        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(screenshotFile,new File(".//screenshot/screen.png"));


        // Example 2 date name
        Date currentdate = new Date();
        //System.out.println(currentdate);
        String screenshotfilename = currentdate.toString().replace(" ","_").replace(":","_");
        System.out.println(screenshotfilename);

        // Screenshot with date name program 3
        driver.get("https://www.w3schools.com/");
       File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       FileUtils.copyFile(screenshotFile,new File(".//screenshot//"+screenshotfilename+".png"));


        driver.quit();

    }
}
