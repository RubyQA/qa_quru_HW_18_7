package guru.qa;

import com.codeborne.selenide.Configuration;
import guru.qa.components.PracticeFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.executeJavaScript;
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
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        form.setFirstName("Test");
        form.setLastName("TestLastName");
        form.setUserEmail("test@test.com");
        form.selectGender("Male");
        form.setDateOfBirth("01","January", "1990");
        form.setUserNumber("1111111111");
        form.setSubject("Maths");
        form.selectHobby("Sports");
        form.uploadPicture("Screenshot_1.png");
        form.setCurrentAddress("Test");
        form.selectState("NCR");
        form.selectCity("Delhi");
        form.submitForm();

        form.checkTable("Test TestLastName");
        form.checkTable("test@test.com");
        form.checkTable("Male");
        form.checkTable("1111111111");
        form.checkTable("01 January,1990");
        form.checkTable("Maths");
        form.checkTable("Sports");
        form.checkTable("Screenshot_1.png");
        form.checkTable("Test");
        form.checkTable("NCR Delhi");
    }

}