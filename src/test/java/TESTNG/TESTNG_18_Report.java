package TESTNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TESTNG_18_Report {
    @Test
    public void reporttest1(){
        Reporter.log("This is test 1");
        System.out.println("THis is test 1");
    }

    @Test
    public void reporttest2(){
        System.out.println("THis is test 2");
    }

    @Test
    public void reporttest3(){
        System.out.println("THis is test 3");
    }

    @Test
    public void reporttest4(){
        System.out.println("THis is test 4");
    }
}
