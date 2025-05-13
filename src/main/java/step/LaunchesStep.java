package step;

import com.epam.reportportal.annotations.Step;
import dto.LaunchTableHeaders;
import org.junit.jupiter.api.Assertions;
import dto.FilterOption;
import page.LaunchesPage;

public class LaunchesStep {
    LaunchesPage launchesPage = new LaunchesPage();

    @Step
    public void selectFilter(final FilterOption option) {
        launchesPage.clickFilterButton();
        switch (option) {
            case ALL_LAUNCHES:
                launchesPage.clickAllLaunchesFilter();
                break;
            case LATEST_LAUNCHES:
                launchesPage.clickLatestLaunchesFilter();
                break;
        }
    }

    @Step
    public void compareFilterType(final String type) {
        Assertions.assertEquals(type, launchesPage.getFilterType(), "Filter types are not equal.");
    }

    @Step
    public void verifyIfAllLaunchHasDeleteOption() {
        Assertions.assertEquals(launchesPage.getLaunchHamburgerIcon().size(), launchesPage.getDeleteButton().size(), "Hamburger menu doesn't contains delete button.");
    }

    @Step
    public void verifyIfHeaderPresentOnTheTable(final LaunchTableHeaders header) {
        Assertions.assertTrue(launchesPage.getTableHeaders().contains(header.getHeader()), "Table doesn't contain the header: " + header);
    }
}
