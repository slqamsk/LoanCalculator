import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class SimpleTest {
    @Test
    void test01() {
        open("https://slqamsk.github.io/cases/simple-pages/page01.html");
        $(By.tagName("h1")).shouldHave(text("Добро пожаловать"));
        $(By.tagName("p")).shouldHave(text("HTML"));
        $(By.tagName("a")).shouldHave(text("Яндекс"));
    }
    @Test
    void test02() {
        open("https://slqamsk.github.io/cases/simple-pages/page01.html");
        $(By.tagName("h1")).shouldNotHave(text("До свидания"));
    }

    @Test
    void test03FillForm() {
        //Открытие страницы
        open("https://slqamsk.github.io/cases/simple-pages/page02.html");
        //Проверяем, что поле лога не заполнено в начале
        $(By.id("log-form1")).shouldHave(text("Лог нажатий появится здесь..."));
        //Заполняем имя, пароль и email
        $(By.name("username")).setValue("Сергей");
        $(By.name("password")).setValue("Qwery12345*");
        $(By.name("contact")).setValue("slqamsk@gmail.com");
        //Нажимаем на кнопку "Отправить"
        $(By.name("submit-btn")).click();
        //Проверяем, что поле лога заполнено введёнными значениями
        $(By.id("log-form1")).shouldHave(text("username: Сергей"));
        //Пауза на 5 секунд в демонстрационных целях. После отлкдки - удалить.
        sleep(5_000);
    }

    @Test
    void test04() {
        open("https://slqamsk.github.io/cases/simple-pages/page02.html");
        $(By.className("unique-class")).shouldHave(text("Элемент с уникальным классом"));
    }
}
