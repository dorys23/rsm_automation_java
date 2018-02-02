import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.AssurancePage;
import pageobjects.URLS;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class AssuranceTest {
    private WebDriver driver;
    private Browser browser;
    private AssurancePage assurancePage;

    @BeforeClass
    public void beforeClass(){
        browser = new Browser();
        driver = browser.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assurancePage = new AssurancePage(driver);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @Test
    public void checkAssurancePage() throws InterruptedException {
        driver.get(URLS.baseurl);
        Thread.sleep(5000);
        assurancePage.reachTheAuditPage();
        Thread.sleep(5000);
        assertEquals(driver.getCurrentUrl(), "http://rsmus.com/what-we-do/services/assurance.html");
        assertEquals(assurancePage.assuranceBreadcrumbText(), "Audit");
    }

}
