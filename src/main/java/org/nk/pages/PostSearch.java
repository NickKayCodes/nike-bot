package org.nk.pages;

import org.nk.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PostSearch extends TestBase{
    @FindBy(id = "Nike Dunk High Retro")
    WebElement dunks;

    public PostSearch(){
        PageFactory.initElements(webDriver, this);
    }
    public void findDunks(){
        dunks.click(); //should take you to item description page where you can pick shoe sizes etc
    }
}
