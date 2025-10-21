import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest {

    @BeforeAll
    static void openPage() {
        open("https://www.saucedemo.com/");
    }

    @Test
    void checkLoginSuccess() {
        $("#user-name").setValue("standard_user");
        $("#password").setValue("secret_sauce");
        $("#login-button").click();
        $("#react-burger-menu-btn").shouldBe(visible);

    }

    @Test
    void checkLoginWrongUser() {
        $("#user-name").setValue("wrong_user");
        $("#password").setValue("secret_sauce");
        $("#login-button").click();
        $("#react-burger-menu-btn").shouldNotBe(visible);
    }

    @Test
    void checkLoginWrongPass() {
        $("#user-name").setValue("standard_user");
        $("#password").setValue("wrong_password");
        $("#login-button").click();
        $("#react-burger-menu-btn").shouldNotBe(visible);
    }

    @Test
    void checkLoginEmptyFields() {
        $("#login-button").click();
        $("#react-burger-menu-btn").shouldNotBe(visible);
    }

    @Test
    void checkLoginEmptyUser() {
        $("#password").setValue("secret_sauce");
        $("#login-button").click();
        $("#react-burger-menu-btn").shouldNotBe(visible);
    }

    @Test
    void checkLoginEmptyPass() {
        $("#user-name").setValue("performance_glitch_user");
        $("#login-button").click();
        $("#react-burger-menu-btn").shouldNotBe(visible);
    }

    @Test
    void checkLoginErrMsgEmptyUser() {
        $("#password").setValue("secret_sauce");
        $("#login-button").click();
        $("[data-test=error]").shouldHave(text("Epic sadface: Username is required"));
    }

    @Test
    void checkLoginErrMsgEmptyPass() {
        $("#user-name").setValue("standard_user");
        $("#login-button").click();
        $("[data-test=error]").shouldHave(text("Epic sadface: Password is required"));
    }

    @Test
    void checkLoginErrMsgUserPassNotMatch() {
        $("#user-name").setValue("standard_user");
        $("#password").setValue("wrong_password");
        $("#login-button").click();
        $("[data-test=error]").shouldHave(text("Epic sadface: Username and password do not match any user in this service"));
    }

}