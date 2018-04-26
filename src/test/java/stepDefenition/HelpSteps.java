package stepDefenition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HelpSteps {
    WebDriver driver = InitialSteps.driver;


    public void fillFieldValue(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public void fillInField(String field, String value) {
        WebElement element = driver.findElement(By.xpath(String.format("//input[@placeholder='%s']", field)));
        if (element.getAttribute("placeholder").contains(field)) {
            fillFieldValue(element, value);
        }
    }


    public void click(By locator) {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(locator)));
        driver.findElement(locator).click();
    }

    public void clickElement(String element) {
        click(By.xpath("//self::node()[text()='" + element + "']"));
    }


    public void checkVisibilityOfElement(String element) {
        checkVisibilityOfElement(By.xpath("//self::node()[text()='" + element + "']"));
    }

    public void checkVisibilityOfElement(By locator) {
        assertTrue(presentOfElementLocated(locator, 20));
        findElementLocated(driver.findElement(locator));
    }


    public void findElementLocated(WebElement element) {
        assertTrue(isElementVisible(element, 10));
    }


    public boolean isElementVisible(WebElement elementName, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(elementName));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean presentOfElementLocated(By locator, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
