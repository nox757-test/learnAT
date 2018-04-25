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
    WebDriver driver;



    public WebDriver getDriver() {
        if(driver == null) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("dom.webnotifications.enabled");
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public void enterData(String id, String placeholder, String data) {
        WebElement el = driver.findElement(By.xpath(String.format("//input[@id='%s' and @placeholder='%s']", id, placeholder)));
        el.clear();
        el.sendKeys(data);
    }

    public void pushButton(String button) {
        WebElement el = driver.findElement(By.xpath("//self::node()[text()='" + button+ "']"));
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(el));
        el.click();
    }

    public void checkElement(String element) {
        WebElement el = driver.findElement(By.xpath("//self::node()[text()='" + element + "']"));
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(el));
        el.isDisplayed();
        assertEquals(el.getText(), element);
    }
}
