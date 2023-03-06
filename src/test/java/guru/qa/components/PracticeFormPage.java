package guru.qa.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormPage {

    public SelenideElement firstNameInput = $("#firstName");
    public SelenideElement lastNameInput = $("#lastName");
    public SelenideElement userEmailInput = $("#userEmail");
    public SelenideElement genderRadioButton = $("#genterWrapper").$(byText("Male"));
    public SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    public SelenideElement monthSelect = $(".react-datepicker__month-select");
    public SelenideElement yearSelect = $(".react-datepicker__year-select");
    public SelenideElement dayOfMonth = $("[aria-label=\"Choose Monday, January 1st, 1990\"]");
    public SelenideElement userNumberInput = $("#userNumber");
    public SelenideElement subjectsInput = $("#subjectsInput");
    public SelenideElement hobbiesCheckbox = $("#hobbiesWrapper").$(byText("Sports"));
    public SelenideElement uploadPictureInput = $("#uploadPicture");
    public SelenideElement currentAddressInput = $("#currentAddress");
    public SelenideElement stateDropdown = $("#state");
    public SelenideElement cityDropdown = $("#city");
    public SelenideElement submitButton = $("#submit");

    public void setFirstName(String name) {
        firstNameInput.setValue(name);
    }

    public void setLastName(String lastName) {
        lastNameInput.setValue(lastName);
    }

    public void setUserEmail(String email) {
        userEmailInput.setValue(email);
    }

    public void selectGender() {
        genderRadioButton.click();
    }

    public void setDateOfBirth(String month, String year) {
        dateOfBirthInput.click();
        monthSelect.click();
        monthSelect.selectOption(month);
        yearSelect.click();
        yearSelect.selectOption(year);
        dayOfMonth.click();
    }

    public void setUserNumber(String number) {
        userNumberInput.setValue(number);
    }

    public void setSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();
    }

    public void selectHobby() {
        hobbiesCheckbox.click();
    }

    public void uploadPicture(String filePath) {
        uploadPictureInput.uploadFromClasspath(filePath);
    }

    public void setCurrentAddress(String address) {
        currentAddressInput.setValue(address);
    }

    public void selectState(String state) {
        stateDropdown.click();
        stateDropdown.$(byText(state)).click();
    }

    public void selectCity(String city) {
        cityDropdown.click();
        cityDropdown.$(byText(city)).click();
    }

    public void submitForm() {
        submitButton.click();
    }
}
