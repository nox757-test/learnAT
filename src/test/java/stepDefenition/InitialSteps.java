package stepDefenition;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InitialSteps {

    static WebDriver driver;

    public static WebDriver getDriver() {
        if(driver == null) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("dom.webnotifications.enabled");
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    @Дано("^открыт браузер и осуществлен переход по ссылке$")
    public void openBrowser() throws Throwable {
        driver = getDriver();
        driver.get("http://172.26.25.86:8081/sua/login");

    }

    @Тогда("^браузер закрыт$")
    public void closeBrowser() throws Throwable {
        driver.quit();
        driver = null;
    }

}
