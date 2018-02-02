import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.HeaderSection;
import pageobjects.OurOfficesPage;
import pageobjects.URLS;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class OurOfficesTest {
    private WebDriver driver;
    private OurOfficesPage ourOfficesPage;
    private HeaderSection headerSection;

    @BeforeClass
    public void beforeClass(){
        Browser browser = new Browser();
        driver = browser.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ourOfficesPage = new OurOfficesPage(driver);
        headerSection = new HeaderSection(driver);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @Test(priority = 1)
    public void mapFunctionForLincoln() throws InterruptedException {
        driver.get(URLS.baseurl);
        Thread.sleep(5000);
        headerSection.clickOnOurOfficesButton();
        Thread.sleep(5000);
        assertEquals(driver.getCurrentUrl(),"http://rsmus.com/locations.html");
        ourOfficesPage.lincolnLocationPresent();
        ourOfficesPage.clickOnLincolnLocation();
        ourOfficesPage.locationPopupDisplayed();
        assertEquals(ourOfficesPage.getLocationPopupContent(), "Lincoln\n" + "1221 N Street Suite 221\n" + "Lincoln, NE 68508\n" + "531.289.3200");
    }

    @Test(priority = 2)
    public void redirectToALocation() throws InterruptedException {
        driver.get(URLS.baseurl);
        Thread.sleep(5000);
        headerSection.clickOnOurOfficesButton();
        Thread.sleep(5000);
        assertEquals(driver.getCurrentUrl(),"http://rsmus.com/locations.html");
        ourOfficesPage.minnesotaLocationPresent();
        ourOfficesPage.clickOnMinnesotaLocation();
        assertEquals(driver.getCurrentUrl(), "http://rsmus.com/locations/minnesota.html");
        assertEquals(ourOfficesPage.getMinnesotaBreadcrumbText(), "Minnesota");
    }
}
