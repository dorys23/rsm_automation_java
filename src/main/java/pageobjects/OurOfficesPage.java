package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.How.CSS;
import static org.openqa.selenium.support.How.PARTIAL_LINK_TEXT;

public class OurOfficesPage {

    WebDriver driver;
    @FindBy(how = CSS, using = "img[title='Lincoln']")
    private WebElement linkolnLocation;
    @FindBy(how = CSS, using = "div > div.leaflet-popup-content-wrapper")
    private WebElement locationPopup;
    @FindBy(how = CSS, using = "div.leaflet-popup-content-wrapper > div")
    private WebElement locationPopupContent;
    @FindBy(how = PARTIAL_LINK_TEXT, using = "Minnesota")
    private WebElement minnesotaLocation;
    @FindBy(how = CSS, using = "div.breadcrumb-social-wrap > div.breadcrumb > ul > li.last > a")
    private WebElement minnesotaBreadcrumb;

    public OurOfficesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void lincolnLocationPresent() {
        assert linkolnLocation.isDisplayed();
    }

    public void clickOnLincolnLocation() {
        linkolnLocation.click();
    }

    public void locationPopupDisplayed() {
        assert locationPopup.isDisplayed();
    }

    public String getLocationPopupContent() {
        return locationPopupContent.getText();
    }

    public void minnesotaLocationPresent() {
        assert minnesotaLocation.isDisplayed();
    }

    public void clickOnMinnesotaLocation(){
        minnesotaLocation.click();
    }

    public String getMinnesotaBreadcrumbText(){
        return minnesotaBreadcrumb.getText();
    }

}
