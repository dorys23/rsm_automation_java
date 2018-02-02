package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.How.*;

public class HeaderSection extends BasePage {

    WebDriver driver;

    @FindBy(how = XPATH, using = "//div[1]/a/img")
    private WebElement rsmLogo;
    @FindBy(how = CLASS_NAME, using = "localRegion.desktop-hide")
    private WebElement region;
    @FindBy(how = CSS, using = "div.regionDropdown.desktop-hide > select")
    private WebElement locationDropdown;
    @FindBy(how = CSS, using = "input[id='q']")
    private WebElement searchField;
    @FindBy(how = CSS, using = "#searchform > input[type='submit']:nth-child(2)")
    private WebElement searchButton;
    @FindBy(how = CSS, using = "#navWrapper > div > ul > li.last > a")
    private WebElement contactUsButton;
    @FindBy(how = PARTIAL_LINK_TEXT, using = "Careers")
    private WebElement careersButton;
    @FindBy(how = CSS, using = "#navWrapper > div > ul > li:nth-child(1) > a")
    private WebElement ourOffices;

    public HeaderSection(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchForAContent(String searchText) throws InterruptedException {
        searchField.click();
        searchField.sendKeys(searchText);
        searchButton.click();
        Thread.sleep(5000);
    }

    public void selectALocation(String location) {
        selectFromDropdownMenu(locationDropdown, location);
    }

    public void clickOnContactUsButton() {
        contactUsButton.click();
    }

    public void clickOnCareersButton() {
        careersButton.click();
    }

    public void clickOnOurOfficesButton() {
        ourOffices.click();
    }


}
