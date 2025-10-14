package TESTNG;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TESTNG_10_Annotation {
    @BeforeSuite
    public void datasetup(){
        System.out.println("commonn data setup");
    }
    @AfterSuite
    public void datateardown(){
        System.out.println("tear down");
    }
}
