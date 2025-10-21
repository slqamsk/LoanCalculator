import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LoanCalculatorTests {

    @Test
    void testSimpleAnnuitet() {
        open("https://slqamsk.github.io/cases/loan-calc/v01/");
        $x("//input[@id='amount']").setValue("100000");
        $x("//input[@id='term']").setValue("12");
        $x("//input[@id='rate']").setValue("20");
        $x("//button[@id='calculate-btn']").click();

        $x("//button[@id='show-schedule-btn']").shouldBe(visible, Duration.ofSeconds(20));

        $x("//button[@id='show-schedule-btn']").click();

        switchTo().window(1);

        $x("//tr[13]/td[5]").shouldHave(text("0.00"));
        $x("//tr/td[.='12']/../td[5]").shouldHave(text("0.00"));
    }
}
