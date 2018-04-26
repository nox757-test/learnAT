package stepDefenition;

import cucumber.api.DataTable;
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

import java.util.List;

import static org.junit.Assert.assertEquals;
import static stepDefenition.InitialSteps.getDriver;

public class StepImplementation extends HelpSteps{



    @Тогда("^открывается (?:страница с )?(?:модальное окно|формой|финансовой организацией|сообщением) \"([^\"]*)\"$")
    public void waitOpenPage(String titleForm) throws Throwable {
        checkElement(titleForm);

    }

    @Когда("^пользователь (?:заполняет|вводит в) поле \"([^\"]*)\" значением \"([^\"]*)\"$")
    public void fillField(String field, String data) throws Throwable {
        enterData(field, data);

    }



    @Тогда("^пользователь (?:нажимает|выбирает).* \"([^\"]*)\".*$")
    public void clickOnElement(String element) throws Throwable {
        clickElement(element);
    }


    @Тогда("^откывается страница с логотипом \"([^\"]*)\"$")
    public void waitLogoPageAgent(String logoTitle) throws Throwable {
        checkLogo(logoTitle);

    }

    @Когда("^пользователь заполняет поля \"([^\"]*)\" и \"([^\"]*)\" значениями$")
    public void fillLoginAndPassword(String field1, String field2, DataTable data) throws Throwable {
        List<String> list = data.asList(String.class);
        enterData(field1, list.get(0));
        enterData(field2, list.get(1));
    }

}
