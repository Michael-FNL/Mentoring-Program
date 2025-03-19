package uiTests;

import baseTest.BaseTest;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import step.LoginStep;
import util.ListenerRP;
import util.RandomData;

@Listeners(ListenerRP.class)
public class LoginPageTest extends BaseTest {

    @Test
    public void verifyIsAppLoaded() {
        Assert.assertTrue(new LoginStep().verifyIsLoginPageLoaded(), "Login page wasn't open");
    }

    @Test
    public void verifyIsUserCannotLoginWithWrongCredentials() {
        final RandomData randomData = new RandomData();
        final LoginStep loginStep = new LoginStep();
        final User user = User.builder()
                .username(randomData.getRandomString())
                .password(randomData.getRandomAlphaNumeric())
                .build();

        loginStep.login(user);
        Assert.assertTrue(loginStep.verifyIsErrorMessageOnBottomPresent(), "Error message isn't appear");
    }
}
