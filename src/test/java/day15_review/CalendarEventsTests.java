package day15_review;

import com.cybertek.pages.vytrack.CalendarEventsPage;
import utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.VYTrackUtils;

import java.util.Arrays;
import java.util.List;
//import static com.pages.pages.vytrack.CalendarEventsPage.waitUntillLoaderScreenDisappear;
public class CalendarEventsTests extends TestBase {
    //BeforeMethod is coming from TestBase
    CalendarEventsPage calendarPage = new CalendarEventsPage();

    @Test
    public void verifyRepeatOptions(){
        //we are reading username from .properties file
        String username = ConfigurationReader.getProperty("storemanagerusername");
        //we are reading password from .properties file
        String password = ConfigurationReader.getProperty("storemanagerpassword");

        VYTrackUtils.login(driver, username, password); //login

        //go to Calendar Events
        VYTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");

        VYTrackUtils.waitUntilLoaderScreenDisappear(driver);
        driver.findElement(By.cssSelector(calendarPage.createCalendarEventBtnLocator)).click();

        VYTrackUtils.waitUntilLoaderScreenDisappear(driver);
        driver.findElement(By.cssSelector(calendarPage.repeatCheckBoxLocator)).click();

        List<String> expectedOptions = Arrays.asList("Daily", "Weekly","Monthly", "Yearly");
        List<String> actualOptions = calendarPage.getRepeatOptions();

        //correct way to check if 2 collections are equals
        Assert.assertEquals(actualOptions, expectedOptions);

    }

    //AfterMethod id coming from TestBase
}

