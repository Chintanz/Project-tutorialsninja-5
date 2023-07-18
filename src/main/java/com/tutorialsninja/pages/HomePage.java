package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends Utility {
    @CacheLookup
            @FindBy(xpath = ("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"))
            WebElement topMenu;
    @CacheLookup
            @FindBy(linkText = ("Desktops"))
            WebElement desktopLink;
    @CacheLookup
            @FindBy(linkText = ("Laptops & Notebooks"))
            WebElement laptopsAndNotebooksLink;
    @CacheLookup
            @FindBy(linkText = ("Components"))
            WebElement componentsLinks;
    @CacheLookup
            @FindBy(xpath = ("//span[contains(text(),'Currency')]"))
            WebElement currencyTab;
    @CacheLookup
            @FindBy(xpath = ("//ul[@class = 'dropdown-menu']/li"))
            WebElement currencyList;

    @CacheLookup
            @FindBy(xpath = ("//span[contains(text(),'My Account')]"))
            WebElement myAccountTab;

    @CacheLookup
            @FindBy(xpath = ("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"))
    WebElement myAccountOptions;


    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements((By) topMenu);
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements((By) topMenu);
        }
    }

    public void mouseHoverOnDesktopsLinkAndClick() {
        mouseHoverToElementAndClick(desktopLink);
    }

    public void mouseHoverOnLaptopsAndNotebooksLinkAndClick() {
        mouseHoverToElementAndClick(laptopsAndNotebooksLink);
    }

    public void mouseHoverOnComponentLinkAndClick() {
        mouseHoverToElementAndClick(componentsLinks);
    }

    public void selectCurrency(String currency) {
        clickOnElement(currencyTab);
        List<WebElement> listOfElements = getListOfElements((By) currencyList);
        for (WebElement e : listOfElements) {
            if (e.getText().equalsIgnoreCase(currency)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnMyAccountTab() {
        clickOnElement(myAccountTab);
    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = getListOfElements((By) myAccountOptions);
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = getListOfElements((By) myAccountOptions);
        }
    }
}
