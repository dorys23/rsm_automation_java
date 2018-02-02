package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.How.CSS;

public class CareersPage {

    WebDriver driver;

    @FindBy(how = CSS, using = "div.par.parsys > div.richTextEditor.parbase.section.text")
    private WebElement careersAtRsm;
    @FindBy(how = CSS, using = "div.parsys_column.three-col-control-c0 > div.section.campaignSpotlight > div")
    private WebElement workingAtRsm;
    @FindBy(how = CSS, using = "div.parsys_column.three-col-control-c1 > div")
    private WebElement joinTheRsmTeam;
    @FindBy(how = CSS, using = "div.parsys_column.three-col-control-c2 > div")
    private WebElement socialResponsability;
    @FindBy(how = CSS, using = "div.parsys_column.three-col-control-c0 > div.richTextEditor.parbase.section.text")
    private WebElement learnMoreAbout;
    @FindBy(how = CSS, using = "div.parsys_column.three-col-control-c1 > div.richTextEditor.parbase.section.text")
    private WebElement followRsmCareers;
    @FindBy(how = CSS, using = "div.breadcrumb > ul > li.last > a")
    private WebElement breadcrumbRsm;

    public CareersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String breadcrumbText(){
        return breadcrumbRsm.getText();
    }

    public void navigateToCareersAtRsmPage(){
        careersAtRsm.click();
    }

}
