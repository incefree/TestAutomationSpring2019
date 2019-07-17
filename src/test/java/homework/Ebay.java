package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Ebay {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("wooden spoon" + Keys.ENTER);

        String result = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']")).getText();
        driver.findElement(By.xpath("//span[text()='All']")).click();
        String result2 = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']")).getText();


        System.out.println(result);
        System.out.println(result2);


        String resultWithoutComma = result.replaceAll(",", "");
        String[] split = resultWithoutComma.split(" ");

        String result2WithoutComma = result2.replaceAll(",", "");
        String[] split2 = result2WithoutComma.split(" ");

        int r1 = Integer.parseInt(split[0].toString());
        int r2 = Integer.parseInt(split2[0].toString());

        if (r2 > r1) {
            System.out.println("Test is PASSED. \n All link search result is  " + r2 + " bigger than single search " + r1);
        } else {
            System.out.println("Test is failed");
        }
    }
}