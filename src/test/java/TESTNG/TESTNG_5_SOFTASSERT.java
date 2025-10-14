package TESTNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class TESTNG_5_SOFTASSERT {
   @Test
    public void titlecase(){
       SoftAssert softAssert = new SoftAssert();
        String expectedTitle  = "Electronics, Cars, Fashion, Collectibles & More | eBay";
        String expectedText = "Search";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        String actualtitle = driver.getTitle();
       System.out.println("Veryfying title");

       softAssert.assertEquals(actualtitle,expectedTitle,"Title verification failed");
       String actualText = driver.findElement(By.xpath("//*[@id=\"gh-search-btn\"]")).getAttribute("value");
       System.out.println("veryfying text");
       softAssert.assertEquals(actualText,expectedText,"Text verification pass");
       System.out.println("closing the browser");
        driver.quit();
        softAssert.assertAll();
    }
}