import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.browserVersion = System.getProperty("browserVersion", "100.0");
        Configuration.browser = System.getProperty("BrowserName", "chrome");
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.remote = System.getProperty("remoteURL");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }
    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Test
    void studentFormTest() {

        String nameFirst = "Tatiana";
        String nameLast = "Ivanova";
        String email = "tat@gmail.com";
        String gender = "Female";
        String phone = "9234333899";
        String subjects = "History";
        String currentAddress = "currentAddress";
        String birthDateYear = "2000";
        String birthDateMonth = "November";
        String birthDate = "11";
        String hobby = "Music";
        String img = "cat.jpg";
        String state = "Haryana";
        String city = "Karnal";

        Selenide.open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").setValue(nameFirst);
        $("#lastName").setValue(nameLast);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(birthDateMonth);
        $(".react-datepicker__year-select").selectOption(birthDateYear);
        $(".react-datepicker__day--011:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue(subjects).pressTab();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath("images/" + img);
        $("#currentAddress").setValue(currentAddress);
        $(byText("Select State")).click();
        $(byText(state)).click();
        $(byText("Select City")).click();
        $(byText(city)).click();
        $(byText("Submit")).click();


        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $$(".table-responsive tr").findBy(text("Student Name" + " " + nameFirst + " " + nameLast)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("Student Email" + " " + email)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("Gender" + " " + gender)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("Mobile" + " " + phone)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("Date of Birth" + " " + birthDate + " " + birthDateMonth + "," + birthDateYear)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("Hobbies" + " " + hobby)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("Picture" + " " + img)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("Address" + " " + currentAddress)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("State and City" + " " + state + " " + city)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("Subjects" + " " + subjects)).shouldBe(visible);
    }
}