package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.How.CLASS_NAME;
import static org.openqa.selenium.support.How.CSS;
import static org.openqa.selenium.support.How.ID;

public class JobsAtRsmUsPage extends BasePage{
    WebDriver driver;

    @FindBy(how = ID, using = "Job-Type")
    private WebElement jobType;
    @FindBy(how = ID, using = "Category")
    private WebElement jobCategory;
    @FindBy(how = ID, using = "StateList")
    private WebElement jobState;
    @FindBy(how = ID, using = "keyword-search")
    private WebElement keywordSearch;
    @FindBy(how = ID, using = "search-button")
    private WebElement searchButton;
    @FindBy(how = CLASS_NAME, using = "JobListTable")
    private WebElement jobListTable;
    @FindBy(how = CSS, using = "#job-list-table > div > div:nth-child(4)")
    private WebElement pager;
    @FindBy(how = CSS, using = "#job-list-table > div > div:nth-child(1)")
    private WebElement resultsSection;

    public JobsAtRsmUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String resultSectionText(){
        return resultsSection.getText();
    }

    public void selectOptionsForAJob(String type, String category, String state){
        selectFromDropdownMenu(jobType, type);
        selectFromDropdownMenu(jobCategory, category);
        selectFromDropdownMenu(jobState, state);
        searchButton.click();
    }

}
