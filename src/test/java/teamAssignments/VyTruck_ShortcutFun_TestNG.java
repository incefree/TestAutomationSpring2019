package teamAssignments;
/*
Vytrack shortcut functionality
1. Open browser
2. Go to Vytrack login page
3. Login as a sales manager
4. Verify Dashboard page is open
5. Click on Shortcuts icon
6. Click on link See full list
7. Click on link Opportunities
8. Verify Open opportunities page is open
9. Click on Shortcuts icon
10. Click on link Vehicle Service Logs
11. Verify error message text is You do not have permission to perform this action.
12. Verify Open opportunities page is still open
 */


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.SeleniumUtils;

import java.util.concurrent.TimeUnit;

public class VyTruck_ShortcutFun_TestNG {
    //********* STEP 1-3 *********
    //1. Open browser
    //2. Go to Vytrack login page
    //3. Login as a sales manager

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");

        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager129");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.waitPlease(4);
    }


    //********* STEP 4 *********
    // Verify Dashboard page is open

    @Test (priority = 1)
    public void testDashboard() {


        Assert.assertEquals(driver.findElement(By.cssSelector("h1[class='oro-subtitle']")).getText(),"Dashboard");
        SeleniumUtils.waitPlease(2);
    }

    //********* STEP 5-8 *********
    //5. Click on Shortcuts icon
    //6. Click on link See full list
    //7. Click on link Opportunities
    //8. Verify Open opportunities page is open
    @Test (priority = 2)
    public void openOpportunities() {
        driver.findElement(By.xpath("//i[@class='fa-share-square']")).click();
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.xpath("//*[@id=\"oroplatform-header\"]/div[1]/div/div[2]/div/ul/li[2]/form/div/div/a")).click();
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.xpath("(//a[@href='/opportunity'])[4]")).click();
        SeleniumUtils.waitPlease(2);
        Assert.assertEquals(driver.getTitle(),"Open Opportunities - Opportunities - Sales");

//        Assert.assertEquals(driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText(),"Open Opportunities");
    }

    //********* STEP  *********
    //9. Click on Shortcuts icon
    //10. Click on link Vehicle Service Logs
    //11. Verify error message text is You do not have permission to perform this action.
    //12. Verify Open opportunities page is still open
    @Test(priority = 3)
    public void vehicleServiceLogs() {
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.xpath("//i[@class='fa-share-square']")).click();
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.xpath("//*[@id=\"oroplatform-header\"]/div[1]/div/div[2]/div/ul/li[2]/form/div/div/a")).click();
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.xpath("(//a[.='Vehicle Services Logs'])[2]")).click();
        SeleniumUtils.waitPlease(2);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='message']")).getText(),"You do not have permission to perform this action.");
        Assert.assertEquals(driver.getTitle(),"Shortcut Actions List");

    }

    @AfterClass
    public void teardown(){
        SeleniumUtils.waitPlease(2);
        driver.quit();

    }
}



