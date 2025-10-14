package TESTNG;

import org.testng.annotations.*;

public class TESTNG_8_Annotations {
    @BeforeClass
    public void test1(){
        System.out.println("before class");
    }
    @BeforeGroups(value = "regression")
    public void test2(){
        System.out.println("test2");
    }
    @Test(groups = "functional")
    public void test3(){
        System.out.println("test3");
    }
    @Test(groups = "regression")
    public void test4(){
        System.out.println("test4");
    }
    @AfterGroups(value = "regression")
    public void test5(){
        System.out.println("test5");
    }
    @AfterClass
    public void test6(){
        System.out.println("after class");
    }
}
