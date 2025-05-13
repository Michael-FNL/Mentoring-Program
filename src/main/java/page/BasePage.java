package page;

import blocks.NavigationMenu;

public class BasePage extends NavigationMenu<BasePage> {

    public BasePage() {
        waitForPageLoad();
        initElements();
    }
}