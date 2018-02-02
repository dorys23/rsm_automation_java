package pageobjects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class BasePage {

    public WebElement getUniqueElement(WebDriver driver, By locator) {
        return ExpectedConditions.visibilityOfElementLocated(locator).apply(driver);
    }

    public void selectFromDropdownMenu(WebElement element, String option) {
        Select dropDown = new Select(element);
        dropDown.selectByVisibleText(option);
    }

    public void focusOnANewlyOpenedTab(WebDriver driver) {
        Set<String> Pages = driver.getWindowHandles();
        Object WebPages[] = Pages.toArray();
        driver.switchTo().window(WebPages[1].toString());

    }

    public void hoverOverAnElement(WebDriver driver, WebElement element1, WebElement element2, WebElement element3){
        Actions action = new Actions(driver);
        action.moveToElement(element1).moveToElement(element2).moveToElement(element3).click().build().perform();
    }

    public void takeScreenshot(WebDriver driver, String filename) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(URLS.screenshotLocation + filename + ".png"));
    }
}
