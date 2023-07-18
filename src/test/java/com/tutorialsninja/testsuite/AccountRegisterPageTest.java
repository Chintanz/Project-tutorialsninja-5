package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.AccountRegisterPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.MyAccountPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountRegisterPageTest extends BaseTest {
    HomePage homePage = new HomePage();
    AccountRegisterPage accountRegisterPage = new AccountRegisterPage();
    MyAccountPage accountPage = new MyAccountPage();
    @Test(groups = {"sanity", "smoke"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        homePage.clickOnMyAccountTab();
        homePage.selectMyAccountOptions("Register");
        Assert.assertEquals(accountRegisterPage.getRegisterAccountText(),
                "Register Account", "Register page not displayed");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        homePage.clickOnMyAccountTab();
        homePage.selectMyAccountOptions("Register");
        accountRegisterPage.enterFirstName("prime" + getAlphaNumericString(4));
        accountRegisterPage.enterLastName("test" + getAlphaNumericString(4));
        accountRegisterPage.enterEmail("prime" + getAlphaNumericString(4) + "@gmail.com");
        accountRegisterPage.enterTelephone("07988112233");
        accountRegisterPage.enterPassword("test123");
        accountRegisterPage.enterConfirmPassword("test123");
        accountRegisterPage.selectSubscription("Yes");
        accountRegisterPage.clickOnPrivacyPolicyCheckBox();
        accountRegisterPage.clickOnContinueButton();
        Assert.assertEquals(accountPage.getYourAccountHasBeenCreatedText(), "Your Account Has Been Created!",
                "Account not created");
        accountPage.clickOnContinueButton();
        homePage.clickOnMyAccountTab();
        homePage.selectMyAccountOptions("Logout");
        Assert.assertEquals(accountPage.getAccountLogoutText(), "Account Logout", "Not logged out");
        accountPage.clickOnContinueButton();
    }
}
