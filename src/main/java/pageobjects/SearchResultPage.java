package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.How.CSS;
import static org.openqa.selenium.support.How.LINK_TEXT;

public class SearchResultPage extends BasePage {

    WebDriver driver;

    @FindBy(how = LINK_TEXT, using = "RSM Nomad Security Testing Appliance")
    private WebElement rsmNomadSecurity;
    @FindBy(how = CSS, using = "article:nth-child(1) > hgroup > h3 > a")
    private WebElement bobFeldmann1;
    @FindBy(how = CSS, using = "article:nth-child(5) > hgroup > h3 > a")
    private WebElement bobFeldmann2;
    @FindBy(how = CSS, using = "#sp_sorting")
    private WebElement sortBy;

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void rsmNomadSecurityPresent() {
        assert rsmNomadSecurity.isDisplayed();
    }

    public void navigateToRSMNOmadSecurity() {
        rsmNomadSecurity.click();
    }

    public void selectDateInSortBy() {
        selectFromDropdownMenu(sortBy, "Date");
    }

    public void selectRelevanceInSortBy() {
        selectFromDropdownMenu(sortBy, "Relevance");
    }

    public void bobFeldmann1Present() {
        assert bobFeldmann1.isDisplayed();
    }

    public void bobFeldmann2Present() {
        assert bobFeldmann2.isDisplayed();
    }

    public void navigateToBobFeldmannProfilePage() {
        bobFeldmann1.click();
    }
}
