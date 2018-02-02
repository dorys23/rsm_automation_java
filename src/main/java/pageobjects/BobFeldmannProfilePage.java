package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.How.CSS;

public class BobFeldmannProfilePage {

    WebDriver driver;

    @FindBy(how = CSS, using = "div.article-header.noindex > hgroup > h1")
    private WebElement profileName;

    public BobFeldmannProfilePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String profileName() {
        return profileName.getText();
    }
}
