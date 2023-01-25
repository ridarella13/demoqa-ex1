import org.junit.jupiter.api.Test;


public class StudentFormTestWithRandomData extends TestBase {


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
                .verifyResults("Student Name", "Tatiana Ivanova ")
                .verifyResults("Student Email", "tat@gmail.com")
                .verifyResults("Gender", "Female")
                .verifyResults("Mobile", "9234333899")
                .verifyResults("Date of Birth", "11 November,2000")
                .verifyResults("Picture", "cat.jpg")
                .verifyResults("Address", "currentAddress")
                .verifyResults("State and City", "Haryana Karnal")
                .verifyResults("Subjects", "History");

    }
}

