package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class LaunchesPage extends BasePage{

    @FindBy(css = "[class*=allLatestDropdown__arrow]")
    private WebElement filterButton;

    @FindBy(xpath = "//div[contains(@class,'allLatestDropdown__option')]/div[text()='All launches']")
    private WebElement allLaunchesFilter;

    @FindBy(xpath = "//div[contains(@class,'allLatestDropdown__option')]/div[text()='Latest launches']")
    private WebElement latestLaunchesFilter;

    @FindBy(xpath = "//span[contains(@class,'breadcrumb__link-item')]/span")
    private WebElement filterType;

    @FindBy(css = "[class*=hamburger__hamburger-icon--]")
    private List<WebElement> launchHamburgerIcons;

    @FindBy(xpath = "//div[contains(@class, 'hamburger__hamburger-menu-actions')]/div[text()='Delete']")
    private List<WebElement> deleteButton;

    @FindBy(xpath = "//span[contains(@class, 'headerCell__title-full')]")
    private List<WebElement> tableHeaders;

    public LaunchesPage() {
        super();
    }

    public void clickFilterButton() {
        filterButton.click();
    }

    public void clickAllLaunchesFilter() {
        allLaunchesFilter.click();
    }

    public void clickLatestLaunchesFilter() {
        latestLaunchesFilter.click();
    }

    public String getFilterType() {
        return filterType.getText();
    }

    public List<WebElement> getLaunchHamburgerIcon() {
        return launchHamburgerIcons;
    }

    public List<WebElement> getDeleteButton() {
        return deleteButton;
    }

    public List<String> getTableHeaders() {
        return tableHeaders.stream().map(element -> element.getAttribute("textContent")).collect(Collectors.toList());
    }
}
