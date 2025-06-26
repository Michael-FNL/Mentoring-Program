package blocks;

import org.openqa.selenium.By;
import uielement.BaseUiComponent;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public abstract class NavigationMenu<T extends NavigationMenu> extends BaseUiComponent {
    private final SelenideElement dashboardsSideBarIcon = $(By.xpath("//span[text()='Dashboards']//ancestor::span/i"));
    private final SelenideElement launchesSideBarIcon = $(By.xpath("//span[text()='Launches']//ancestor::span/i"));
    private final SelenideElement filtersSideBarIcon = $(By.xpath("//span[text()='Filters']//ancestor::span/i"));

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
