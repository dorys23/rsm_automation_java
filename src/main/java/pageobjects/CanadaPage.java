package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.How.CSS;

public class CanadaPage {

    WebDriver driver;

    @FindBy(how = CSS, using = "div.localRegion.localRegion-en_ca.desktop-hide")
    private WebElement region;


    public CanadaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getRegionText() {
        return region.getText();
    }

    public void regionTitlePresent() {
        assert region.isDisplayed();
    }
}
