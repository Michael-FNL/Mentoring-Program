package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import model.User;
import step.LoginStep;

import java.util.Map;

public class LoginStepDefinition {

    private User user;

    @Given("the username is logged into the portal:")
    public void theUsernameIsLoggedIntoThePortal(DataTable dataTable) {
        final LoginStep loginStep = new LoginStep();
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        user = new User(data.get("username"), data.get("password"));
        loginStep.login(user);
    }
}
