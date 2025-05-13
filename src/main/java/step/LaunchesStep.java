package step;

import com.epam.reportportal.annotations.Step;
import dto.FilterOption;
import page.LaunchesPage;

import java.util.List;

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
    public String getAdjustedFilterType() {
        return launchesPage.getFilterType();
    }

    @Step
    public boolean verifyIfAllLaunchHasDeleteOption() {
        return launchesPage.getLaunchHamburgerIcon().size() == launchesPage.getDeleteButton().size();
    }

    @Step
    public List<String> getHeaderPresentOnTheTable() {
       return launchesPage.getTableHeaders();
    }
}
