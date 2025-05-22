package stepdefinitions;

import dto.FilterOption;
import dto.LaunchTableHeaders;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import page.LaunchesPage;
import util.TestContext;

public class LauncheStepDefinition {

    private TestContext context;
    LaunchesPage launchesPage = new LaunchesPage();

    public LauncheStepDefinition() {
        this.context = new TestContext();
        this.launchesPage = new LaunchesPage();
    }

    @When("the user selects '{word}' from the Launches page filters")
    public void theUserSelectsFilterOptionFromTheLaunchesPageFilters(String filterOptionStr) {
        FilterOption filterOption = FilterOption.valueOf(filterOptionStr);
        launchesPage.clickFilterButton();
        switch (filterOption) {
            case ALL_LAUNCHES:
                launchesPage.clickAllLaunchesFilter();
                break;
            case LATEST_LAUNCHES:
                launchesPage.clickLatestLaunchesFilter();
                break;
            default:
                throw new IllegalStateException("Unexpected filter: " + filterOption);
        }
        context.set("filter", filterOption);
    }

    @Then("the launches should be sorted and show correct type")
    public void theLaunchesShouldBeSortedAndShowCorrectType() {
        FilterOption option = context.get("filter", FilterOption.class);
        Assert.assertEquals(option.getType(), launchesPage.getFilterType(), "Filter types are not equal.");
    }

    @Then("all launches should have the delete option")
    public void allLaunchesShouldHaveTheDeleteOption() {
        Assert.assertEquals(launchesPage.getLaunchHamburgerIcon().size(), launchesPage.getDeleteButton().size(), "Hamburger menu doesn't contains delete button.");
    }

    @Then("the launches table should display the correct {string}")
    public void theLaunchesTableShouldDisplayTheCorrectHeader(String expectedHeader) {
        LaunchTableHeaders header = LaunchTableHeaders.valueOf(expectedHeader);
        Assert.assertTrue(launchesPage.getTableHeaders().contains(header.getHeader()), "Table doesn't contain the header: " + header);
    }
}
