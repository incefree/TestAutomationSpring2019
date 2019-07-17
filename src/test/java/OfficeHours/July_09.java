package OfficeHours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.SeleniumUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class July_09 {
    public static void main(String[] args) {



/*
Topic: Select class

    Select class is used for handling drop down boxes with tag name of Select

    declaration of select class:
             Select variableName= new Select(drop down box WebElement)

     Methods of Select class:
                selectByIndex(int):  --->> selects option by the index number
                selectByValue(String): --->>   selects the options in drop down box by the value
                selectByVisibleText(String): --->> select the options in drop down box by visible text
                getOptions();   ---->>>
*/
        test1();


    }


    public static void test1() {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        SeleniumUtils.waitPlease(2);


       /*

      <select aria-label="Month" name="birthday_month" id="month" title="Month" class="_5dba">
      .//select[@aria-label="Month"]
        */

        WebElement monthDB = driver.findElement(By.xpath("//select[@aria-label='Month']"));
        Select month = new Select(monthDB);

        //select by index:
        month.selectByIndex(5);
        SeleniumUtils.waitPlease(2);

        //select of ByValue
        month.selectByValue("11");
        SeleniumUtils.waitPlease(2);

        //select ByVisible text
        month.selectByVisibleText("Sep");

        List<WebElement> lst1 = month.getOptions();

        WebElement september = lst1.get(9);
        System.out.println(september.isSelected());


    }
    public static void test2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        SeleniumUtils.waitPlease(3);

        WebElement yeardb = driver.findElement(By.xpath("//select[@name='birthday_year']"));
        Select year = new Select (yeardb);

        year .selectByVisibleText("1909");



        List <WebElement> list = year.getOptions();

        WebElement Y1909 =  null ;

        for( WebElement each : list) {
            if (each.getText().equals("1909"))
                Y1909 = each;
        }
        System.out.println(Y1909.isSelected());

    }
}
