package me.plasmarob.seleniumlogin.pages.google;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleMainPage {
    protected WebDriver driver;
    public GoogleMainPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://www.google.com/");
    }

    private By signInBy = By.xpath("//a[normalize-space()=\"Sign in\"]");

    public AccountPage signIn() {
        driver.findElement(signInBy).click();
        return new AccountPage(driver);
    }
}
