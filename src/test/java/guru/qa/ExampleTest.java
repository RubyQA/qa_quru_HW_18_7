package guru.qa;

import com.codeborne.selenide.Configuration;
import guru.qa.components.PracticeFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ExampleTest {
    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1700x1200";
    }
    @Test
    void fillFormTest(){
        open("/automation-practice-form");

        PracticeFormPage form = new PracticeFormPage();

        form.setFirstName("Test");
        form.setLastName("TestLastName");
        form.setUserEmail("test@test.com");
        form.selectGender();
        form.setDateOfBirth("January", "1990");
        form.setUserNumber("1111111111");
        form.setSubject("Maths");
        form.selectHobby();
        form.uploadPicture("Screenshot_1.png");
        form.setCurrentAddress("Test");
        form.selectState("NCR");
        form.selectCity("Delhi");
        form.submitForm();

        $(".table-responsive").shouldHave(text("Test TestLastName"));
        $(".table-responsive").shouldHave(text("test@test.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("1111111111"));
        $(".table-responsive").shouldHave(text("01 January,1990"));
        $(".table-responsive").shouldHave(text("Maths"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("Screenshot_1.png"));
        $(".table-responsive").shouldHave(text("Test"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));
    }

}