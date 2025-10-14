package TESTNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TESTNG_11_a_DataProvider {

    @Test(dataProvider="dataset1")
    public void test1(String username, String password, String test){
        System.out.println(username +"=="+password+"=="+test);
    }
    @DataProvider
    public Object[][] dataset1(){
        return new Object[][]{
                {"username0","password0","test0"},
                {"username1","password1","test1"},
                {"username2","password2","test2"},
                {"username3","password3","test3"}
        };
    }
}
