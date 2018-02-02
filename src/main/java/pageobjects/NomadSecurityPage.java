package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.How.CSS;

public class NomadSecurityPage {

    WebDriver driver;

    @FindBy(how = CSS, using = "div.breadcrumb > ul > li.last")
    private WebElement breadCrumbSection;

    public NomadSecurityPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTextFromBreadcrumb() {
        return breadCrumbSection.getText();
    }
}
