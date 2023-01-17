import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.StudentPage;

public class TestBase {
    StudentPage studentPage = new StudentPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }
}