package uiTests;

import baseTest.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import dto.FilterOption;
import dto.LaunchTableHeaders;
import model.User;
import step.LaunchesStep;
import step.LoginStep;
import util.ListenerRP;

@Listeners(ListenerRP.class)
public class LaunchePageTNGTest extends BaseTest {

    final User superAdmin = new User("superadmin", "erebus");

    @DataProvider(name="filterOption", parallel = true)
    public Object[][] filterOption() {
        return new Object[][] {
                {FilterOption.ALL_LAUNCHES, superAdmin},
                {FilterOption.LATEST_LAUNCHES, superAdmin}
        };
    }

    @Test(dataProvider = "filterOption", description = "User is able to see launches list sorted by most recent by default, and is able to resort them.")
    public void userIsAbleToSeeLaunchesListSortedByMostRecentByDefaultAndIsAbleToResortThem(final FilterOption option, final User user) {
        final LoginStep loginStep = new LoginStep();
        final LaunchesStep launchesStep = new LaunchesStep();
        loginStep.login(user).openLaunchesPage();
        launchesStep.selectFilter(option);
        launchesStep.compareFilterType(option.getType());
    }

    @DataProvider(name="usedCredentials")
    public Object[][] usedCredentials() {
        return new Object[][] {
                {superAdmin}
        };
    }

    @Test(dataProvider = "usedCredentials", description = "User is able to remove launch(s).")
    public void userIsAbleToRemoveLaunch(final User user) {
        final LoginStep loginStep = new LoginStep();
        final LaunchesStep launchesStep = new LaunchesStep();
        loginStep.login(user).openLaunchesPage();
        launchesStep.verifyIfAllLaunchHasDeleteOption();
    }

    @DataProvider(name="tableHeaders", parallel = true)
    public Object[][] tableHeaders() {
        return new Object[][] {
                {LaunchTableHeaders.TOTAL, superAdmin},
                {LaunchTableHeaders.PASSED, superAdmin},
                {LaunchTableHeaders.FAILED, superAdmin},
                {LaunchTableHeaders.SKIPPED, superAdmin},
                {LaunchTableHeaders.PRODUCT_BUG, superAdmin},
                {LaunchTableHeaders.AUTO_BUG, superAdmin},
                {LaunchTableHeaders.SYSTEM_ISSUE, superAdmin},
                {LaunchTableHeaders.TO_INVESTIGATE, superAdmin}
        };
    }

    @Test(dataProvider = "tableHeaders", description = "Each launch contains tests count data.")
    public void eachLaunchContainsTestsCountData(final LaunchTableHeaders header, final User user) {
        final LoginStep loginStep = new LoginStep();
        final LaunchesStep launchesStep = new LaunchesStep();
        loginStep.login(user).openLaunchesPage();
        launchesStep.verifyIfHeaderPresentOnTheTable(header);
    }
}