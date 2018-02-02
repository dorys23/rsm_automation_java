import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.NonProfitPage;
import pageobjects.URLS;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class NonProfitTest {
    private WebDriver driver;
    private NonProfitPage nonProfitPage;

    @BeforeClass
    public void beforeClass() {
        Browser browser = new Browser();
        driver = browser.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        nonProfitPage = new NonProfitPage(driver);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void checkNonProfitPage() throws InterruptedException {
        driver.get(URLS.baseurl);
        Thread.sleep(5000);
        nonProfitPage.navigateToNonProfitPage();
        Thread.sleep(5000);
        assertEquals(driver.getCurrentUrl(), "http://rsmus.com/what-we-do/industries/not-for-profit.html");
        assertEquals(nonProfitPage.nonProfitBreadcrumbText(), "Nonprofit");
    }
}
