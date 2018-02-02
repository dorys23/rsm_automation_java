package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.How.CSS;

public class AssurancePage extends BasePage {

    WebDriver driver;

    @FindBy(how = CSS, using = "#whatwedo")
    private WebElement whatWeOffer;
    @FindBy(how = CSS, using = "#byservice")
    private WebElement byService;
    @FindBy(how = CSS, using = "#byservice > ul > li.has-flyout.first")
    private WebElement audit;
    @FindBy(how = CSS, using = "div.breadcrumb-social-wrap > div.breadcrumb > ul > li.last > a")
    private WebElement assuranceBreadcrumb;

    public AssurancePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void reachTheAuditPage() {
        hoverOverAnElement(driver, whatWeOffer, byService, audit);
    }

    public String assuranceBreadcrumbText() {
        return assuranceBreadcrumb.getText();
    }
}
