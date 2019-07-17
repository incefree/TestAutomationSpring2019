package teamAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;

import java.util.concurrent.TimeUnit;

public class Vytrack {

    public static void main(String[] args) throws Exception {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://qa2.vytrack.com/user/login");
        Thread.sleep(2000);
        driver.findElement(By.id("prependedInput")).sendKeys("user183");
        Thread.sleep(2000);
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        Thread.sleep(2000);
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"user-menu\"]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"user-menu\"]/ul/li[5]/a")).click();
        Thread.sleep(3000);

        driver.close();

    }
}

