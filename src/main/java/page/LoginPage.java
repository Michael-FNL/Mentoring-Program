package page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import util.Config;
import util.DriverCreator;

import static com.codeborne.selenide.Selenide.$;


public class LoginPage extends BasePage {

    private final SelenideElement nameField = $(By.xpath("//*[@placeholder='Login']"));

    private final SelenideElement passwordField = $(By.xpath("//*[@placeholder='Password']"));

    private final SelenideElement title = $(By.xpath("//*[contains(@class,'loginPage__logo')]"));

    private final SelenideElement submitButton = $(By.xpath("//*[@type='submit']"));

    private final SelenideElement errorMessage = $(By.xpath("//*[contains(@class,'notificationItem__error')]"));

    public LoginPage() {
        super();
    }

    public Boolean isLoginPageLoaded() {
        return DriverCreator.getDriver().getCurrentUrl().equals(Config.getProperties("host"));
    }

    public LoginPage fillNameField(final String name) {
        if (name != null) {
            waitForElementToAppear(nameField);
            nameField.sendKeys(name);
        }
        return this;
    }

    public LoginPage fillPasswordField(final String password) {
        if (password != null) {
            waitForElementToAppear(passwordField);
            passwordField.sendKeys(password);
        }
        return this;
    }

    public void clickSubmitButton() {
        waitForElementToAppear(submitButton);
        submitButton.click();
    }

    public Boolean isTitlePresent() {
        waitForElementToAppear(title);
        return title.isDisplayed();
    }

    public Boolean isErrorMessageOnBottomPresent() {
        waitForElementToAppear(errorMessage);
        return errorMessage.isDisplayed();
    }
}
