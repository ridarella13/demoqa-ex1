package components;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultModal<bytext> {
    public void verifyModalAppears() {
        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

    public void verifyResult(String key, String value) {
        $(".table-responsive").$(bytext(key).parent)
        .shouldhave(text(value));
    }

}

