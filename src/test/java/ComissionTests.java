import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ComissionTests {
    @Test
    //Тест01 проверяет, что для суммы 2000 рублей форма работает
    //(для сумм от 1000 до 10000 рублей)
    void test01UsualSum() {
        //Открыть страницу
        open("https://slqa.ru/cases/fc/v01");
        //Ввести 2000 в поле "Сумма перевода"
        $(By.name("sum")).setValue("2000");
        //Нажать на кнопку
        $(By.name("submit")).click();
        //Проверить комиссию и проверить общую сумму к оплате
        $(By.name("com")).shouldHave(text("20"));
        $(By.name("total")).shouldHave(text("2020"));
    }
}