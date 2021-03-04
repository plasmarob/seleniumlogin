package me.plasmarob.seleniumlogin.pages.feederfam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    protected WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // <a class="nav-link" href="https://feederfam.com/login">Login</a>
    private By loginBy = By.linkText("Login");
    // same tag, but search by location instead of text.
    private By loginLocationBy = By.xpath("//div[@id='navbarSupportedContent']/ul[2]/li/a");
    
    /**
     * Get Login Link
     *
     * @return String URL of link at the location of the login button
     */
    public String getLoginLink() {
        return driver.findElement(loginLocationBy).getAttribute("href");
    }

    /**
     * Click login
     *
     * @return LoginPage objext representing login page
     */
    public LoginPage clickLogin() {
        driver.findElement(loginBy).click();
        return new LoginPage(driver);
    }
}
