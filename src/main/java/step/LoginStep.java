package step;

import com.epam.reportportal.annotations.Step;
import model.User;
import page.LaunchesPage;
import page.LoginPage;

public class LoginStep {

    LoginPage loginPage = new LoginPage();

    @Step
    public Boolean verifyIsLoginPageLoaded() {
        return loginPage.isLoginPageLoaded() & loginPage.isTitlePresent();
    }

    @Step
    public LaunchesPage login(User user) {
        loginPage.fillNameField(user.getUsername())
                .fillPasswordField(user.getPassword())
                .clickSubmitButton();
        return new LaunchesPage();
    }

    @Step
    public Boolean verifyIsErrorMessageOnBottomPresent() {
        return loginPage.isErrorMessageOnBottomPresent();
    }
}
