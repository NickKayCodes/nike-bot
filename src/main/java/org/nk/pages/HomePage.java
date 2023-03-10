package org.nk.pages;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.nk.base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.Logger;

public class HomePage extends TestBase {

    @FindBy(id = "VisualSearchInput")
    WebElement searchBar;

    @FindBy(className = "pre-logo-svg")
    WebElement brandLogo;

    @FindBy(id = "hf_title_signin_membership")
    WebElement signIn;

    private static final Logger logger = LogManager.getLogger(HomePage.class);
    public HomePage(){
        logger.trace("initializing web elements");
        PageFactory.initElements(webDriver, this);
    }

    public void assertHomePageTitle(){
        logger.trace("confirming title is correct to Nike Site");
        assertEquals(webDriver.getTitle(), "Nike. Just Do It. Nike.com");
    }

    public boolean validateBrandLogo(){
        logger.trace("brand logo is displayed");
        return brandLogo.isDisplayed();
    }
    public boolean searchBarExists(){
        logger.trace("looking for search bar");
        return searchBar.isDisplayed();
    }

    public void useSearchBar(){
        logger.trace("searching for pandaDunks");
        searchBar.click();
        searchBar.sendKeys(properties.getProperty("pandaDunks"));
        searchBar.sendKeys(Keys.ENTER);
    }


}
