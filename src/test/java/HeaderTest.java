import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class HeaderTest extends BasePage{
    private WebDriver driver;
    private HeaderSection headerSection;
    private ChadPage chadPage;
    private CanadaPage canadaPage;
    private RomaniaPage romaniaPage;

    @BeforeClass
    public void beforeClass(){
        Browser browser = new Browser();
        driver = browser.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        headerSection = new HeaderSection(driver);
        chadPage = new ChadPage(driver);
        canadaPage = new CanadaPage(driver);
        romaniaPage = new RomaniaPage(driver);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @Test(priority = 1)
    public void locationDropdownFunctionForChad() throws InterruptedException {
        driver.get(URLS.baseurl);
        Thread.sleep(5000);
        headerSection.selectALocation("Chad");
        focusOnANewlyOpenedTab(driver);
        Thread.sleep(5000);
        assertEquals (driver.getCurrentUrl(), "https://www.rsm.global/chad");
        chadPage.worldwideLocationHeaderPresent();
        chadPage.globalRegionPresent();
        chadPage.pageTitlePresent();
        assertEquals(chadPage.pageTitleText(), "Chad");
        assertEquals(chadPage.chadRegionTitleText(), "Global site");
    }

    @Test(priority = 2)
    public void locationDropdownFunctionForCanada() throws InterruptedException {
        driver.get(URLS.baseurl);
        Thread.sleep(5000);
        headerSection.selectALocation("Canada");
        focusOnANewlyOpenedTab(driver);
        Thread.sleep(5000);
        assertEquals (driver.getCurrentUrl(), "http://rsmcanada.com/");
        canadaPage.regionTitlePresent();
        assertEquals(canadaPage.getRegionText(), "Canada");
    }

    @Test(priority = 3)
    public void locationDropdownFunctionForRomania() throws InterruptedException {
        driver.get(URLS.baseurl);
        Thread.sleep(5000);
        headerSection.selectALocation("Romania");
        focusOnANewlyOpenedTab(driver);
        Thread.sleep(5000);
        assertEquals(driver.getCurrentUrl(), "https://www.rsm.global/romania/");
        romaniaPage.romaniaRegionPresent();
        assertEquals(romaniaPage.regionName(),"Romania");
        assertEquals(romaniaPage.whatWeOfferText(), "What we offer");
        romaniaPage.selectRoLanguage();
        assertEquals(romaniaPage.whatWeOfferText(), "Serviciile noastre");
    }



}
