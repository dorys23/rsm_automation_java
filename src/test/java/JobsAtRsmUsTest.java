import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class JobsAtRsmUsTest extends BasePage{

    private WebDriver driver;
    private HeaderSection headerSection;
    private CareersPage careersPage;
    private JobsAtRsmUsPage jobsAtRsmUsPage;

    @BeforeClass
    public void beforeClass(){
        Browser browser = new Browser();
        driver = browser.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        headerSection = new HeaderSection(driver);
        careersPage = new CareersPage(driver);
        jobsAtRsmUsPage = new JobsAtRsmUsPage(driver);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @Test(priority = 1)
    public void noAvailableJobs() throws InterruptedException {
        driver.get(URLS.baseurl);
        Thread.sleep(5000);
        headerSection.clickOnCareersButton();
        Thread.sleep(5000);
        careersPage.navigateToCareersAtRsmPage();
        focusOnANewlyOpenedTab(driver);
        Thread.sleep(5000);
        assertEquals(driver.getCurrentUrl(), "http://jobs.rsmus.com/ListJobs/All");
        jobsAtRsmUsPage.selectOptionsForAJob("Temporary", "Tax", "Missouri");
        assertEquals(jobsAtRsmUsPage.resultSectionText(), "0 Temporary Tax jobs in Missouri");
    }

    @Test(priority = 2)
    public void availableJobs() throws InterruptedException{
        driver.get(URLS.baseurl);
        Thread.sleep(5000);
        headerSection.clickOnCareersButton();
        Thread.sleep(5000);
        careersPage.navigateToCareersAtRsmPage();
        focusOnANewlyOpenedTab(driver);
        Thread.sleep(5000);
        assertEquals(driver.getCurrentUrl(), "http://jobs.rsmus.com/ListJobs/All");
        jobsAtRsmUsPage.selectOptionsForAJob("Experienced", "Category", "Iowa");
        assertNotEquals(jobsAtRsmUsPage.resultSectionText(), null);
    }
}
