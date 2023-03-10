package org.nk.pages;

import org.nk.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemDescription extends TestBase {
    @FindBy()
    public ItemDescription(){
        PageFactory.initElements(webDriver, this);
    }


}
