package me.plasmarob.seleniumlogin.pages.google;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//We can't get here! Google blocks automation now.
public class PassPage {
    protected WebDriver driver;
    public PassPage(WebDriver driver) {
        this.driver = driver;
    }

    // <input type="password" class="whsOnd zHQkBf" jsname="YPqjbf"
    // autocomplete="current-password" spellcheck="false" tabindex="0"
    // aria-label="Enter your password" name="password" autocapitalize="none"
    // dir="ltr" data-initial-dir="ltr" data-initial-value="">
    private By passBy = By.name("password");

    // <button class="VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ
    // VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc lw1w4b"
    // jscontroller="soHxf" jsaction="click:cOuCgd; mousedown:UX7yZ; mouseup:lbsD7e;
    // mouseenter:tfO1Yc; mouseleave:JywGue; touchstart:p6p2H; touchmove:FwuNnf;
    // touchend:yfqBxc; touchcancel:JMtRjd; focus:AHmuwe; blur:O22p3e;
    // contextmenu:mg9Pef;" jsname="LgbsSe" type="button"><div
    // class="VfPpkd-Jh9lGc"></div><span jsname="V67aGc"
    // class="VfPpkd-vQzf8d">Next</span><div class="VfPpkd-RLmnJb"></div></button>
    private By nextBy = By.xpath("//button[normalize-space()=\"Next\"]");

    /**
     * Get Text Label
     *
     * @return String representing text box label
     */
    public String getTextLabel() {
        return driver.findElement(passBy).getAttribute("aria-label");
    }

    /**
     * Enter password
     *
     * @param pass
     * @return GoogleMainPage object representing logged in homepage
     */
    public GoogleMainPage passValidEmail(String pass) {
        driver.findElement(passBy).sendKeys(pass);
        driver.findElement(nextBy).click();
        return new GoogleMainPage(driver);
    }
}
