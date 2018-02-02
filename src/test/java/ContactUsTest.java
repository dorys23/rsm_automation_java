import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.ContactUsPage;
import pageobjects.HeaderSection;
import pageobjects.URLS;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class ContactUsTest {
    private WebDriver driver;
    private Browser browser;
    private HeaderSection headerSection;
    private ContactUsPage contactUsPage;

    @BeforeClass
    public void beforeClass(){
        browser = new Browser();
        driver = browser.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        headerSection = new HeaderSection(driver);
        contactUsPage = new ContactUsPage(driver);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @Test
    public void completeAndSubmitTheForm() throws InterruptedException {
        String firstName = "John";
        String lastName = "Snow";
        String email = "john_snow@test.com";
        String street = "Black Wall, 4/67";
        String state = "Outside of U.S.";
        String zipCode = "1234";
        String title = "Lord";
        String company = "NightWatch";
        String phoneNumber = "123-4567-8901";
        String topic = "Billing";
        String comment = "You know nothing, Jon Snow.";

        driver.get(URLS.baseurl);
        Thread.sleep(5000);
        headerSection.clickOnContactUsButton();
        Thread.sleep(5000);
        assertEquals(driver.getCurrentUrl(), "http://rsmus.com/contact.html");
        contactUsPage.completeTheForm(firstName, lastName, email, street, state, zipCode, title, company, phoneNumber, topic, comment);
    }
}
