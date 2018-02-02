import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class SearchTest {
    private WebDriver driver;
    private Browser browser;
    private HeaderSection headerSection;
    private SearchResultPage searchResultPage;
    private NomadSecurityPage nomadSecurityPage;
    private BobFeldmannProfilePage bobFeldmannProfilePage;

    @BeforeClass
    public void beforeClass(){
        browser = new Browser();
        driver = browser.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        headerSection = new HeaderSection(driver);
        searchResultPage = new SearchResultPage(driver);
        nomadSecurityPage = new NomadSecurityPage(driver);
        bobFeldmannProfilePage = new BobFeldmannProfilePage(driver);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @Test(priority = 1)
    public void searchForAnArticle() throws InterruptedException {
        driver.get(URLS.baseurl);
        Thread.sleep(5000);
        headerSection.searchForAContent("test");
        Thread.sleep(5000);
        searchResultPage.rsmNomadSecurityPresent();
        searchResultPage.navigateToRSMNOmadSecurity();
        Thread.sleep(5000);
        assertEquals(driver.getCurrentUrl(), URLS.nomadRSMApplianceUrl);
        assertEquals(nomadSecurityPage.getTextFromBreadcrumb(), "RSM Nomad Security Testing Appliance");
    }

    @Test(priority = 2)
    public void searchForAProfile() throws InterruptedException {
        driver.get(URLS.baseurl);
        Thread.sleep(5000);
        headerSection.searchForAContent("Bob Feldmann");
        Thread.sleep(5000);
        searchResultPage.selectDateInSortBy();
        searchResultPage.bobFeldmann2Present();
        searchResultPage.selectRelevanceInSortBy();
        searchResultPage.bobFeldmann1Present();
        searchResultPage.navigateToBobFeldmannProfilePage();
        Thread.sleep(5000);
        assertEquals(driver.getCurrentUrl(), URLS.bobFeldmannProfileUrl);
        assertEquals(bobFeldmannProfilePage.profileName(), "Bob Feldmann");
    }

}
