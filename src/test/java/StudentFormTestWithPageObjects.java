import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.StudentPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentFormTestWithPageObjects extends TestBase {


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
        String hobby = "Music";
        String img = "cat.jpg";
        String state = "Haryana";
        String city = "Karnal";

        studentPage.openPage()
                .setFirstName(nameFirst)
                .setLastName(nameLast)
                .setUserEmail(email)
                .setGender(gender)
                .setPhone(phone)
                .setBirthDate("11", "November", "2000");



        $("#subjectsInput").setValue(subjects).pressTab();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath("images/" + img);
        $("#currentAddress").setValue(currentAddress);
        $(byText("Select State")).click();
        $(byText(state)).click();
        $(byText("Select City")).click();
        $(byText(city)).click();
        $(byText("Submit")).click();


        studentPage.verifyResaltsModalAppears();
        $$(".table-responsive tr").findBy(text("Student Name" + " " + nameFirst + " " + nameLast)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("Student Email" + " " + email)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("Gender" + " " + gender)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("Mobile" + " " + phone)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("Date of Birth" + " " + "11" + " " + birthDateMonth + "," + birthDateYear)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("Hobbies" + " " + hobby)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("Picture" + " " + img)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("Address" + " " + currentAddress)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("State and City" + " " + state + " " + city)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("Subjects" + " " + subjects)).shouldBe(visible);
    }
}
