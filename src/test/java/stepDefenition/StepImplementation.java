package stepDefenition;

import cucumber.api.DataTable;
import cucumber.api.java.ru.*;
import org.openqa.selenium.By;


import java.util.List;



public class StepImplementation extends HelpSteps{



    @Тогда("^открывается (?:страница с )?(?:модальное окно|формой|финансовой организацией|сообщением) \"([^\"]*)\"$")
    public void waitOpenPage(String text) throws Throwable {
        checkVisibilityOfElement(text);

    }

    @Когда("^пользователь (?:заполняет|вводит в) поле \"([^\"]*)\" значением \"([^\"]*)\"$")
    public void fillFieldValue(String field, String value) throws Throwable {
        fillInField(field, value);

    }


    @Тогда("^пользователь (?:нажимает|выбирает).* \"([^\"]*)\".*$")
    public void clickOnElement(String element) throws Throwable {
        clickElement(element);
    }


    @Тогда("^откывается страница с логотипом \"([^\"]*)\"$")
    public void waitLogoPageAgent(String logoTitle) throws Throwable {
        checkVisibilityOfElement(By.xpath("//self::node()[@title='" + logoTitle + "']"));

    }

    @Когда("^пользователь заполняет поля \"([^\"]*)\" и \"([^\"]*)\" значениями$")
    public void fillLoginAndPassword(String field1, String field2, DataTable data) throws Throwable {
        List<String> list = data.asList(String.class);
        fillInField(field1, list.get(0));
        fillInField(field2, list.get(1));
    }

}
