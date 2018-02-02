package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.How.CSS;
import static org.openqa.selenium.support.How.ID;

public class NonProfitPage extends BasePage{

    WebDriver driver;

    @FindBy(how = ID, using = "whatwedo")
    private WebElement whatWeOffer;
    @FindBy(how = ID, using = "byservice")
    private WebElement byIndustry;
    @FindBy(how = CSS, using = "#byindustry > ul > li:nth-child(10)")
    private WebElement nonProfit;
    @FindBy(how = CSS, using = "div > div.breadcrumb-social-wrap > div.breadcrumb > ul > li.last > a")
    private WebElement nonProfitBreadcrumb;

    public NonProfitPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToNonProfitPage(){
        hoverOverAnElement(driver, whatWeOffer, byIndustry, nonProfit);
    }

    public String nonProfitBreadcrumbText(){
        return nonProfitBreadcrumb.getText();
    }
}
