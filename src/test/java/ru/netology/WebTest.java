package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebTest {
    @Test
    void WebTest() {
        open("http://localhost:9999");
        SelenideElement form = $("form.form_size_m.form_theme_alfa-on-white");
        form.$("[data-test-id=name] input").setValue("Ким-Чан Ин");
        form.$("[data-test-id=phone] input").setValue("+79270000000");
        form.$("[data-test-id=agreement]").click();
        form.$("[class=button__content]").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
    @Test
    void WithoutMinus() {
        open("http://localhost:9999");
        SelenideElement form = $("form.form_size_m.form_theme_alfa-on-white");
        form.$("[data-test-id=name] input").setValue("КимЧан Ин");
        form.$("[data-test-id=phone] input").setValue("+79270000000");
        form.$("[data-test-id=agreement]").click();
        form.$("[class=button__content]").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
    @Test
    void WithoutSpace() {
        open("http://localhost:9999");
        SelenideElement form = $("form.form_size_m.form_theme_alfa-on-white");
        form.$("[data-test-id=name] input").setValue("КимЧанИн");
        form.$("[data-test-id=phone] input").setValue("+79270000000");
        form.$("[data-test-id=agreement]").click();
        form.$("[class=button__content]").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}