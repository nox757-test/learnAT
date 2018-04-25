package stepDefenition;

import cucumber.api.PendingException;
import cucumber.api.java.ru.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class StepImplementation extends HelpSteps{


    @Дано("^открыт браузер и осуществлен переход по ссылке$")
    public void openBrowser() throws Throwable {
        driver = getDriver();
        driver.get("http://172.26.25.86:8081/sua/login");
      
    }


    @Дано("^открывается страница с формой \"([^\"]*)\"$")
    public void waitOpenPage(String titleForm) throws Throwable {
        checkElement(titleForm);
       
    }

    @Когда("^пользователь заполняет поле \"Имя полььзователя\" значением \"([^\"]*)\"$")
    public void fillLogin(String username) throws Throwable {
        enterData("username", "Имя пользователя",username);
       
    }

    @Когда("^пользователь вводт в поле \"Пароль\" значением \"([^\"]*)\"$")
    public void fillPassword(String password) throws Throwable {
        enterData("password", "Пароль", password);
       
    }

    
    @Тогда("^открывается модальное окно \"([^\"]*)\"$")
    public void waitOpenModalWindow(String title) throws Throwable {
        checkElement(title);
    }

    @Тогда("^пользователь выбирает финансовую организацию \"([^\"]*)\" типа КО$")
    public void selectOrganisation(String finOrg) throws Throwable {
        pushButton(finOrg);
    }


    @Тогда("^откывается страница с логотипом \"([^\"]*)\"$")
    public void waitLogoPageAgent(String logoTitle) throws Throwable {
        WebElement el = driver.findElement(By.xpath("//img[@title='" + logoTitle + "']"));
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(el));
        el.isDisplayed();
       
    }
   
    @Тогда("^открывается страница с финансовой организацией \"([^\"]*)\"$")
    public void waitPageOrganisation(String finOrg) throws Throwable {
        checkElement(finOrg);
       
    }

    @Тогда("^пользователь нажимает кнопку \"([^\"]*)\"$")
    public void clickEl(String button) throws Throwable {
        pushButton(button);

    }

    @Тогда("^пользователь нажимает кнопку \"([^\"]*)\" в контекстном меню$")
    public void clickButtonExit(String buttonExit) throws Throwable {
        pushButton(buttonExit);
       
    }

    @Тогда("^браузер закрыт$")
    public void closeBrowser() throws Throwable {
       driver.quit();
    }

}
