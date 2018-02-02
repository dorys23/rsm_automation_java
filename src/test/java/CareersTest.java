import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.CareersPage;
import pageobjects.HeaderSection;
import pageobjects.URLS;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class CareersTest {
    private WebDriver driver;
    private HeaderSection headerSection;
    private CareersPage careersPage;

    @BeforeClass
    public void beforeClass(){
        Browser browser = new Browser();
        driver = browser.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        headerSection = new HeaderSection(driver);
        careersPage = new CareersPage(driver);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @Test
    public void careersPageTest() throws InterruptedException {
        driver.get(URLS.baseurl);
        Thread.sleep(5000);
        headerSection.clickOnContactUsButton();
        Thread.sleep(5000);
        assertEquals(driver.getCurrentUrl(), "http://rsmus.com/careers.html");
        assertEquals(careersPage.breadcrumbText(), "Careers at RSM");
    }
}
