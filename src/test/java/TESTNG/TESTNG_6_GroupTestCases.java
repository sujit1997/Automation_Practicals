package TESTNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TESTNG_6_GroupTestCases {
    @Test(priority = 1,description = "choose your browser",groups = "functional")
    public void browser(){
        System.out.println("enter browser");
    }
    @Test(priority = 2,groups = {"regression","bvt"})
    public void signup(){
        System.out.println("enter url");
        System.out.println("enter mail id & password");
    }
    @Test(priority = 3,groups = {"regression","bvt"})
public void login(){
    System.out.println("enter login id");

}
@Test(priority = 4,groups = "functional")
public void logout(){
    System.out.println("press logout button");
}
}
