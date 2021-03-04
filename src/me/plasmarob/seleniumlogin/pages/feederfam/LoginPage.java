package me.plasmarob.seleniumlogin.pages.feederfam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    protected WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // <input type="text" class="form-control" name="username" id="username"
    // placeholder="Username">
    private By userBy = By.name("username");
    // <input type="password" class="form-control" name="password" id="password"
    // placeholder="Password">
    private By passBy = By.name("password");
    // <button type="submit" class="btn btn-primary">Submit</button>
    private By submitBy = By.xpath("//button[normalize-space()=\"Submit\"]");

    /**
     * Login as valid user
     *
     * @param username
     * @return HomePage object representing next password entry page
     * @throws InterruptedException
     */
    public HomeLoggedInPage passValidUser(String user, String pass) throws InterruptedException {
        driver.findElement(userBy).sendKeys(user);
        driver.findElement(passBy).sendKeys(pass);
        Thread.sleep(500); // just so input is visible
        driver.findElement(submitBy).click();
        return new HomeLoggedInPage(driver);
    }
}
