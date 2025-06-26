package page;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LaunchesPage extends BasePage{

    private final SelenideElement filterButton = $(By.cssSelector("[class*=allLatestDropdown__arrow]"));
    private final SelenideElement allLaunchesFilter = $(By.xpath("//div[contains(@class,'allLatestDropdown__option')]/div[text()='All launches']"));
    private final SelenideElement latestLaunchesFilter = $(By.xpath("//div[contains(@class,'allLatestDropdown__option')]/div[text()='Latest launches']"));
    private final SelenideElement filterType = $(By.xpath("//span[contains(@class,'breadcrumb__link-item')]/span"));
    private final ElementsCollection launchHamburgerIcons = $$(By.cssSelector("[class*=hamburger__hamburger-icon--]"));
    private final ElementsCollection deleteButton = $$(By.xpath("//div[contains(@class, 'hamburger__hamburger-menu-actions')]/div[text()='Delete']"));
    private final ElementsCollection tableHeaders = $$(By.xpath("//span[contains(@class, 'headerCell__title-full')]"));

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

    public ElementsCollection getLaunchHamburgerIcon() {
        return launchHamburgerIcons;
    }

    public ElementsCollection getDeleteButton() {
        return deleteButton;
    }

    public List<String> getTableHeaders() {
        return tableHeaders.stream().map(element -> element.getAttribute("textContent")).collect(Collectors.toList());
    }
}
