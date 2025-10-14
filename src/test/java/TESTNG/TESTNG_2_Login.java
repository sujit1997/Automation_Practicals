package TESTNG;

import org.testng.annotations.Test;

public class TESTNG_2_Login {

    @Test(priority = 1,description = "This is first test")
    public void loginTest(){

        System.out.println("log in successful");

    }
    @Test(priority = 2, description = "This is second test")
    public void logout(){
        System.out.println("logout is successful");
    }

}
