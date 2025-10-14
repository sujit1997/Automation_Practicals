package TESTNG;

import org.testng.annotations.*;

public class TESTNG_3_Annotation {
    @BeforeTest
    public void login(){
        System.out.println("There you login");
    }
    @BeforeMethod
    public void connectDB(){
        System.out.println("DBconnect");
    }
    @AfterMethod
    public void disconnectDB(){
        System.out.println("Disconnect");
    }
    @Test
    public void test1(){
        System.out.println("This is first test");
    }
    @Test
    public void test2(){
        System.out.println("This is second test");
    }
    @Test
    public void test3(){
        System.out.println("This is third test");
    }
    @Test
    public void test4(){
        System.out.println("This is fourth test");
    }
    @AfterTest
    public void logout(){
        System.out.println("There you logout");
    }
}
