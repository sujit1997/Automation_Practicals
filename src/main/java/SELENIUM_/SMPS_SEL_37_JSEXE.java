package SELENIUM_;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SMPS_SEL_37_JSEXE {
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

        driver.get("http://w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");


        JavascriptExecutor jsecex = (JavascriptExecutor) driver;

        //print the title
        String script = "return document.title;";
       String title = (String) jsecex.executeScript(script);
        System.out.println(title);

        //click the button
//        driver.switchTo().frame("iframeResult");
//        jsecex.executeScript("myFunction()");
//        Thread.sleep(2000);
//        driver.switchTo().alert().accept();


        //Scroll
        driver.navigate().to("https://www.w3schools.com/");
        WebElement certifiedbutton = driver.findElement(By.xpath("//*[@id=\"howto_padding\"]/a"));
        jsecex.executeScript("arguments[0].scrollIntoView(true);",certifiedbutton);
    }
}
