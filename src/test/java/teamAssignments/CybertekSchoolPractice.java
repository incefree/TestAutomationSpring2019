package teamAssignments;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;
import utilities.SeleniumUtils;

import java.util.concurrent.TimeUnit;
public class CybertekSchoolPractice {

    public static void main(String[] args) throws Exception {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // I first tested the positive scenario to make sure the website is functioning.
        driver.get("http://practice.cybertekschool.com/login");
        Thread.sleep(2000);
        driver.findElement(By.name("username")).sendKeys("tomsmith"); // positive scenario
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword"); // positive scenario
        Thread.sleep(2000);
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"content\"]/div/a/i")).click(); // I log out here
        Thread.sleep(3000);

        driver.findElement(By.name("username")).sendKeys("isaac"); // negative scenario
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("98765"); // negative scenario
        Thread.sleep(2000);
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(3000);
        // TO TEST AN INVALID SCENARIO IF ACTUAL RESULT IS MATCHING THE EXPECTED RESULT
        String actual = driver.findElement(By.id("flash")).getText(); // html ID is flash
        String expected = "Your username is invalid!\n" + "×";

        SeleniumUtils.verifyEquals(expected, actual);
        // I created seleniumUtils class and verify equals method is located in this class to compare
        // and verify actual and expected results.
        driver.close();
    }
}