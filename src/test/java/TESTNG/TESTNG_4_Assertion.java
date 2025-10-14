package TESTNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TESTNG_4_Assertion {

    @Test
    public void gettitle(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        String title = driver.getTitle();
        System.out.println(title);
    }

    @Test
    public void titleTest(){
        String expectedTitle  = "Electronics, Cars, Fashion, Collectibles & More | eBay";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        String actualtitle = driver.getTitle();
        driver.quit();
        Assert.assertEquals(actualtitle,expectedTitle);

    }
}
