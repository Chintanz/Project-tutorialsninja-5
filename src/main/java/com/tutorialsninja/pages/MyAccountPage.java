package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends Utility {
    @CacheLookup
            @FindBy(xpath = ("//h1[contains(text(),'Account Logout')]"))
    WebElement accountLogoutText;
    @CacheLookup
            @FindBy(xpath = ("//h1[contains(text(),'Your Account Has Been Created!')]"))
            WebElement accountCreatedText;
    @CacheLookup
            @FindBy(xpath = ("//a[contains(text(),'Continue')]"))
    WebElement continueBtn;

    public String getAccountLogoutText() {
        return getTextFromElement(accountLogoutText);
    }

    public String getYourAccountHasBeenCreatedText() {
        return getTextFromElement(accountCreatedText);
    }
    public void clickOnContinueButton() {
        clickOnElement(continueBtn);
    }
}
