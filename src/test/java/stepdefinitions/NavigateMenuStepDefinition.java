package stepdefinitions;

import io.cucumber.java.en.And;
import page.LaunchesPage;

public class NavigateMenuStepDefinition {

    @And("the user navigates to the Launches page")
    public void theUserNavigatesToTheLaunchesPage() {
        final LaunchesPage launchesPage = new LaunchesPage();
        launchesPage.openLaunchesPage();
    }
}
