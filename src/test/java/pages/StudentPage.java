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
            lastNameInput = $("#lastName");

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
        $("#userEmail").setValue(value);

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

    public StudentPage setSubjects(String value) {
        $("#subjectsInput").setValue(value).pressTab();

        return this;
    }

    public StudentPage setHobbies(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();

        return this;
    }

    public StudentPage uploadPicture(String value) {
        $("#uploadPicture").uploadFromClasspath("images/" + value);

        return this;
    }

    public StudentPage setcurrentAddress(String value) {
        $("#currentAddress").setValue(value);

        return this;
    }

    public StudentPage setState(String value) {
        $(byText("Select State")).click();
        $(byText(value)).click();

        return this;
    }

    public StudentPage setCity(String value) {
        $(byText("Select City")).click();
        $(byText(value)).click();

        return this;
    }

    public StudentPage clickSubmitButton(String value) {
        $(byText(value)).click();

        return this;
    }

    public StudentPage verifyResultsModalAppears() {
        registrationResultModal.verifyModalAppears();

        return this;
    }

    public StudentPage verifyResults(String key, String value) {
        registrationResultModal.verifyResult(key, value);

        return this;
    }
}