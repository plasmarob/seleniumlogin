package me.plasmarob.seleniumlogin.pages.feederfam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeLoggedInPage {
    protected WebDriver driver;

    public HomeLoggedInPage(WebDriver driver) {
        this.driver = driver;
    }

    // <a class="nav-link" data-toggle="tooltip" data-placement="bottom" title=""
    // href="https://feederfam.com?action=logout"
    // data-original-title="Logout">Test</a>
    private By logoutBy = By.xpath("//a[@data-original-title='Logout']");

    /**
     * Get Display name
     *
     * @return String of first name of user displayed on logout button
     */
    public String getUserDisplayName() {
        return driver.findElement(logoutBy).getText();
    }

    /**
     * Click logout
     *
     * @return HomePage objext representing main page
     */
    public HomePage signOut() {
        driver.findElement(logoutBy).click();
        return new HomePage(driver);
    }
}
