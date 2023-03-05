import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.text.SimpleDateFormat;
import java.util.Locale;


public class StudentFormTestWithRandomData extends TestBase {

    @Test
    @Tag("smoke")
    @DisplayName("Проверка заполнения формы регистрации")
    void studentFormTest() {

        Faker faker = new Faker(new Locale("US"));
        String nameFirst = faker.name().firstName(),
                nameLast = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                currentAddress = faker.address().streetAddress(),
                phone = faker.number().digits(10),
                hobby = faker.options().option("Reading", "Sports", "Music"),
                gender = faker.options().option("Female", "Male", "Other"),
                subjects = faker.options().option("Biology", "Englis", "Computer Science", "History"),
                img = "cat.jpg",
                birthDateYear = new SimpleDateFormat("yyyy", Locale.US).format(faker.date().birthday()),
                birthDateMonth = new SimpleDateFormat("MMMM", Locale.US).format(faker.date().birthday()),
                birthDate = new SimpleDateFormat("d", Locale.US).format(faker.date().birthday()),
                state = faker.options().option("Haryana"),
                city = faker.options().option("Karnal","Panipat");


        studentPage.openPage()
                .setFirstName(nameFirst)
                .setLastName(nameLast)
                .setUserEmail(email)
                .setGender(gender)
                .setPhone(phone)
                .setBirthDate(birthDate, birthDateMonth, birthDateYear)
                .setSubjects(subjects)
                .setHobbies(hobby)
                .uploadPicture(img)
                .setcurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmitButton("Submit");



        studentPage.verifyResultsModalAppears()
                .verifyResults("Student Name", nameFirst + " " + nameLast)
                .verifyResults("Student Email", email)
                .verifyResults("Gender", gender)
                .verifyResults("Mobile", phone)
                .verifyResults("Date of Birth", birthDate + " " + birthDateMonth + "," + birthDateYear)
                .verifyResults("Picture", img)
                .verifyResults("Address", currentAddress)
                .verifyResults("State and City", state + " " + city)
                .verifyResults("Subjects", subjects);

    }
}

