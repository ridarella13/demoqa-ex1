package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import components.CalendarComponent;
import components.RegistrationResultModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;


public class StudentPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultModal registrationResultModal = new RegistrationResultModal();
    private final String TITLE_TEXT = "Practice Form";
    private SelenideElement
            firstnNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("userEmail");

    public StudentPage openPage() {
        Selenide.open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $(".main-header").shouldHave(text(TITLE_TEXT));

        return this;
    }


    public StudentPage setFirstName(String value) {
        firstnNameInput.setValue(value);

        return this;
    }

    public StudentPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public StudentPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public StudentPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }

    public StudentPage setPhone(String value) {
        $("#userNumber").setValue(value);

        return this;
    }

    public StudentPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public StudentPage verifyResaltsModalAppears() {
        registrationResultModal.verifyModalAppears();

        return this;
    }
    public StudentPage verifyResaltsModalAppears() {
        registrationResultModal.verifyModalAppears();

        return this;
}