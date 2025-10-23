import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LocatorsTests {
    @Test
    void test01ById() {
        open("https://slqa.ru/cases/DeepSeekFlights/");
        $(By.id("loginContainer")).shouldHave(text("Аутентификация"));
        $("#loginContainer").shouldHave(text("Аутентификация"));
        $x("//*[@id='loginContainer']").shouldHave(text("Аутентификация"));
    }

    @Test
    void test02ByIdExamTickets() {
        open("http://92.51.36.108:7777/sl.qa/exam_tickets/");
        sleep(3_000);
        //Поиск через CSS-селектор
        $("#quantity_of_tickets").clear();
        sleep(3_000);
        //Поиск через специфичный метод By.id
        $(By.id("quantity_of_tickets")).sendKeys("10");
        sleep(10_000);
    }
}
