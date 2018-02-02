package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.How.CSS;
import static org.openqa.selenium.support.How.ID;

public class TaxServicesPage extends BasePage {

    WebDriver driver;

    @FindBy(how = ID, using = "whatwedo")
    private WebElement whatWeOffer;
    @FindBy(how = ID, using = "byservice")
    private WebElement byService;
    @FindBy(how = CSS, using = "#byservice > ul > li:nth-child(2)")
    private WebElement tax;
    @FindBy(how = CSS, using = "div.breadcrumb-social-wrap > div.breadcrumb > ul > li.last > a")
    private WebElement breadcrumb;

    public TaxServicesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void reachTaxServicesPage() {
        hoverOverAnElement(driver, whatWeOffer, byService, tax);
    }

    public String taxServicesBreadcrumb() {
        return breadcrumb.getText();
    }

}
