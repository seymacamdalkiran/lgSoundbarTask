package com.lgSoundbar.page;

import com.lgSoundbar.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchAmazonInput;
    @FindBy(id = "nav-search-submit-button")
    public WebElement searchButton;
    @FindBy(id = "searchDropdownBox")
    public WebElement allKategoriesDropDown;
}
