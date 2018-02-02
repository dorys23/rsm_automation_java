import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.TaxServicesPage;
import pageobjects.URLS;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TaxServicesTest {

    private WebDriver driver;
    private TaxServicesPage taxServicesPage;

    @BeforeClass
    public void beforeClass(){
        Browser browser = new Browser();
        driver = browser.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        taxServicesPage = new TaxServicesPage(driver);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @Test
    public void taxServicesPageTest() throws InterruptedException {
        driver.get(URLS.baseurl);
        Thread.sleep(5000);
        taxServicesPage.reachTaxServicesPage();
        Thread.sleep(5000);
        assertEquals(driver.getCurrentUrl(), "http://rsmus.com/what-we-do/services/tax.html");
        assertEquals(taxServicesPage.taxServicesBreadcrumb(), "Tax");
    }
}
