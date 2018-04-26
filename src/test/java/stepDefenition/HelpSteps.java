package stepDefenition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class HelpSteps {
    WebDriver driver = InitialSteps.driver;


    public void enterData(String placeholder, String data) {
        WebElement el = driver.findElement(By.xpath(String.format("//input[@placeholder='%s']", placeholder)));
        el.clear();
        el.sendKeys(data);
    }


    public void click(By locator){
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(locator)));
        driver.findElement(locator).click();
    }

    public void clickElement(String element) {
        click(By.xpath("//self::node()[text()='" + element + "']"));
    }

    public void checkElement(String element) {
        WebElement el = driver.findElement(By.xpath("//self::node()[text()='" + element + "']"));
        isElementPresent(el, 30);
        el.isDisplayed();
        assertEquals(el.getText(), element);
    }

    public void checkLogo(String logoTitle) {
        WebElement el = driver.findElement(By.xpath("//self::node()[@title='" + logoTitle + "']"));
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(el));
        el.isDisplayed();
    }

    public boolean isElementPresent(WebElement elementName, int timeout){
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(elementName));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
