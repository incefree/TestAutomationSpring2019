package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

public class EbaySearch01 {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException, ParseException {

        openBrowserURl("chrome", "http://ebay.com");
        driver.manage().window().maximize(); //maximize screen
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@placeholder='Search for anything']")).sendKeys("wooden spoon" + Keys.ENTER);
        String count1 = driver.findElement(By.className("srp-controls__count-heading")).getText();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@_sp='p2351460.m4118.l9012']")).click();
        String count2 = driver.findElement(By.className("srp-controls__count-heading")).getText();

        String s1 = count1.replace("result", "").replace(",", "");
        String s2 = count2.replace("result", "").replace(",", "");
        DecimalFormat decFor = new DecimalFormat("#");
        int a = 0;
        int b = 0;
        try {
            a = decFor.parse(s1).intValue();
            b = decFor.parse(s2).intValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println((b > a) ? "There are more search item on All link" : "There are not more search item on All link");
        Thread.sleep(3000);

        driver.navigate().back();
        Thread.sleep(3000);


        WebElement _nkw1 = driver.findElement(By.id("gh-ac"));
        String st1 = _nkw1.getAttribute("value");
        System.out.println((st1.equals("wooden spoon")) ? "wooden spoon is on the search box" : "wooden spoon is not on the search box");
        Thread.sleep(3000);

        driver.navigate().back();

        WebElement _nkw2 = driver.findElement(By.id("gh-ac"));
        String st2 = _nkw2.getAttribute("value");
        System.out.println((st2.equals("")) ? "search box is emty" : "search box is not emty");


        Thread.sleep(3000);

        driver.close();

    }


    public static void openBrowserURl(String browser, String url) {

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            default:

                System.out.println("Wrong browser");

        }

        driver.get(url);

    }

}