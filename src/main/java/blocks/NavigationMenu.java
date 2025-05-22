package blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uielement.BaseUiComponent;

public abstract class NavigationMenu<T extends NavigationMenu> extends BaseUiComponent {
    @FindBy(xpath = "//span[text()='Dashboards']//ancestor::span/i")
    WebElement dashboardsSideBarIcon;

    @FindBy(xpath = "//span[text()='Launches']//ancestor::span/i")
    WebElement launchesSideBarIcon;

    @FindBy(xpath = "//span[text()='Filters']//ancestor::span/i")
    WebElement filtersSideBarIcon;

    public T openDashboardPage() {
        dashboardsSideBarIcon.click();
        return (T)this;
    }

    public T openLaunchesPage() {
        launchesSideBarIcon.click();
        return (T)this;
    }

    public T openFiltersPage() {
        filtersSideBarIcon.click();
        return (T)this;
    }
}
