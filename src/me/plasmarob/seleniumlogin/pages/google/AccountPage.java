package me.plasmarob.seleniumlogin.pages.google;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    protected WebDriver driver;
    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // <input type="email" class="whsOnd zHQkBf" jsname="YPqjbf"
    // autocomplete="username" spellcheck="false" tabindex="0" aria-label="Email or
    // phone" name="identifier" value="" autocapitalize="none" id="identifierId"
    // dir="ltr" data-initial-dir="ltr" data-initial-value="">
    private By emailBy = By.name("identifier");

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
     * Enter email or phone
     *
     * @param email
     * @return PassPage object representing next password entry page
     */
    public PassPage passValidEmail(String email) {
        driver.findElement(emailBy).sendKeys(email);
        driver.findElement(nextBy).click();
        return new PassPage(driver);
    }
}
