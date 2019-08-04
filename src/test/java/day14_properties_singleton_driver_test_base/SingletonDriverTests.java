package day14_properties_singleton_driver_test_base;

import org.testng.annotations.Test;
import utilities.Driver;
import utilities.SeleniumUtils;

public class SingletonDriverTests {

    @Test
    public void test1(){
        Driver.getDriver().get("http://google.com");
        SeleniumUtils.waitPlease(2);
        Driver.closeDriver(); // to completely shutdown driver
    }
}
