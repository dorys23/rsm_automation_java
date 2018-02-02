package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.How.CSS;
import static org.openqa.selenium.support.How.ID;

public class ContactUsPage extends BasePage{

    WebDriver driver;

    @FindBy(how = CSS, using = "div.elqPCFirstDiv > input")
    private WebElement firstNameField;
    @FindBy(how = CSS, using = "div:nth-child(7) > input")
    private WebElement lastNameField;
    @FindBy(how = CSS, using = "div:nth-child(8) > input")
    private WebElement emailAddressField;
    @FindBy(how = CSS, using = "div:nth-child(9) > input")
    private WebElement streetAddressField;
    @FindBy(how = CSS, using = "#RSMMcGladreyContactUs_corporate > div:nth-child(10) > select")
    private WebElement stateDropdonwMenu;
    @FindBy(how = CSS, using = "div:nth-child(11) > input")
    private WebElement zipCodeField;
    @FindBy(how = CSS, using = "div:nth-child(12) > input")
    private WebElement titleField;
    @FindBy(how = CSS, using = "div:nth-child(13) > input")
    private WebElement companyField;
    @FindBy(how = ID, using = "C_BusPhone")
    private WebElement phoneNumberField;
    @FindBy(how = ID, using = "Areaofinterest")
    private WebElement topicOfInterestDropdownMenu;
    @FindBy(how = ID, using = "RSMiWebSiteComments")
    private WebElement tellUsMoreField;
    @FindBy(how = ID, using = "submit")
    private WebElement sendButton;
    @FindBy(how = CSS, using = "div.richTextEditor.parbase.section.text > h1")
    private WebElement thankYouMessage;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void completeTheForm(String firstName, String lastName, String email, String street, String state, String zipCode, String title, String comapny, String phone, String topic, String comment) throws InterruptedException {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailAddressField.sendKeys(email);
        streetAddressField.sendKeys(street);
        selectFromDropdownMenu(stateDropdonwMenu, state);
        zipCodeField.sendKeys(zipCode);
        titleField.sendKeys(title);
        companyField.sendKeys(comapny);
        phoneNumberField.sendKeys(phone);
        selectFromDropdownMenu(topicOfInterestDropdownMenu, topic);
        tellUsMoreField.sendKeys(comment);
        sendButton.click();
        Thread.sleep(5000);
        assert thankYouMessage.isDisplayed();
    }

}
