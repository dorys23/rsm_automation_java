package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.How.CSS;
import static org.openqa.selenium.support.How.ID;

public class ChadPage {

    WebDriver driver;

    @FindBy(how = CSS, using = "div.container-fluid > div > div > h1")
    private WebElement pageTitle;
    @FindBy(how = CSS, using = "div.local-region.hidden-xs")
    private WebElement region;
    @FindBy(how = ID, using = "worldwide-locations-header")
    private WebElement worldwideLocationHeader;


    public ChadPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void worldwideLocationHeaderPresent() {
        assert worldwideLocationHeader.isDisplayed();
    }

    public void pageTitlePresent() {
        assert pageTitle.isDisplayed();
    }

    public void globalRegionPresent() {
        assert region.isDisplayed();
    }

    public String pageTitleText() {
        return pageTitle.getText();
    }

    public String chadRegionTitleText() {
        return region.getText();
    }


}
