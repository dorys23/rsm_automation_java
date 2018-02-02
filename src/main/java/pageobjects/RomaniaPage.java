package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.How.CSS;

public class RomaniaPage {

    WebDriver driver;

    @FindBy(how = CSS, using = "div.local-region.hidden-xs")
    private WebElement region;
    @FindBy(how = CSS, using = "#block-locale-language > div > ul > li.en.first.active")
    private WebElement enLanguageSelector;
    @FindBy(how = CSS, using = "#block-locale-language > div > ul > li.ro.last")
    private WebElement roLanguageSelector;
    @FindBy(how = CSS, using = "li.first-item > a")
    private WebElement whatWeOffer;

    public RomaniaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void romaniaRegionPresent() {
        assert region.isDisplayed();
    }

    public String regionName() {
        return region.getText();
    }

    public void selectRoLanguage() {
        roLanguageSelector.click();
    }

    public String whatWeOfferText() {
        return whatWeOffer.getText();
    }
}
