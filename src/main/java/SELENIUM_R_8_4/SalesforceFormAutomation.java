package SELENIUM_R_8_4;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SalesforceFormAutomation {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("https://www.salesforce.com/in/form/signup/freetrial-salesforce-starter/?d=jumbo1-btn-ft");

        // Fill First Name and Last Name
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'UserFirstName')]"))).sendKeys("Sujit");
        driver.findElement(By.xpath("//input[contains(@id,'UserLastName')]")).sendKeys("Manmode");

        // Work Email
        driver.findElement(By.xpath("//input[contains(@id,'UserEmail')]")).sendKeys("sujit@example.com");

        // Company Name
        driver.findElement(By.xpath("//input[contains(@id,'CompanyName')]")).sendKeys("Tech Solutions");

        // Phone
        driver.findElement(By.xpath("//input[contains(@id,'UserPhone')]")).sendKeys("9876543210");

        // Job Title dropdown
        WebElement jobTitleDropdown = driver.findElement(By.xpath("//select[contains(@id,'UserTitle')]"));
        new Select(jobTitleDropdown).selectByVisibleText("IT Manager");

        // Employees dropdown
        WebElement employeesDropdown = driver.findElement(By.xpath("//select[contains(@id,'CompanyEmployees')]"));
        new Select(employeesDropdown).selectByVisibleText("26 - 50 employees");

        // Country dropdown
        WebElement countryDropdown = driver.findElement(By.xpath("//select[contains(@id,'CompanyCountry')]"));
        new Select(countryDropdown).selectByVisibleText("India");

        // Checkbox for agreement
        WebElement checkbox = driver.findElement(By.xpath("//div[contains(@class,'checkbox-ui')]//input[@type='checkbox']"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        // Optional: Submit the form (uncomment if needed)
        // WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Start my free trial')]"));
        // submitButton.click();

        // Wait to see result before closing
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}

