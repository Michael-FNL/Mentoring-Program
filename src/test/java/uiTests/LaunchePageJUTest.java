package uiTests;

import baseTest.BaseTest;
import baseTest.UserParameterResolver;
import dto.FilterOption;
import dto.LaunchTableHeaders;
import model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import step.LaunchesStep;
import step.LoginStep;

@ExtendWith(UserParameterResolver.class)
public class LaunchePageJUTest extends BaseTest {

    @ParameterizedTest
    @EnumSource(value = FilterOption.class, names = {"ALL_LAUNCHES", "LATEST_LAUNCHES"})
    @DisplayName("User is able to see launches list sorted by most recent by default, and is able to resort them.")
    public void userIsAbleToSeeLaunchesListSortedByMostRecentByDefaultAndIsAbleToResortThem(final FilterOption option, final User user) {
        final LoginStep loginStep = new LoginStep();
        final LaunchesStep launchesStep = new LaunchesStep();
        loginStep.login(user).openLaunchesPage();
        launchesStep.selectFilter(option);
        Assertions.assertEquals(option.getType(), launchesStep.getAdjustedFilterType(), "Filter types are not equal.");
    }


    @Test
    @DisplayName("User is able to remove launch(s).")
    public void userIsAbleToRemoveLaunch(final User user) {
        final LoginStep loginStep = new LoginStep();
        final LaunchesStep launchesStep = new LaunchesStep();
        loginStep.login(user).openLaunchesPage();
        Assertions.assertTrue(launchesStep.verifyIfAllLaunchHasDeleteOption(), "Hamburger menu doesn't contains delete button.");
    }

    @ParameterizedTest
    @EnumSource(value = LaunchTableHeaders.class, names = {"TOTAL", "PASSED", "FAILED", "SKIPPED", "PRODUCT_BUG", "AUTO_BUG", "SYSTEM_ISSUE", "TO_INVESTIGATE"})
    @DisplayName("Each launch contains tests count data.")
    public void eachLaunchContainsTestsCountData(final LaunchTableHeaders header, final User user) {
        final LoginStep loginStep = new LoginStep();
        final LaunchesStep launchesStep = new LaunchesStep();
        loginStep.login(user).openLaunchesPage();
        Assertions.assertTrue(launchesStep.getHeaderPresentOnTheTable().contains(header.getHeader()), "Table doesn't contain the header: " + header);
    }
}