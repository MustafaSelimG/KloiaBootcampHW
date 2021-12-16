package bootcamp.pages;

import bootcamp.utils.Driver;
import bootcamp.utils.Helper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
    public Homepage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css = "[alt='United States']")
    public WebElement country;

    @FindBy(css = ".c-close-icon.c-modal-close-icon")
    public WebElement popUpCloseButton;

    @FindBy(className = "logo")
    public WebElement bestBuyLogo;

    @FindBy(id = "gh-search-input")
    public WebElement searchBar;

    @FindBy(className = "header-search-button")
    public WebElement searchButton;

    @FindBy(css = "a.btn.btn-white.btn-sm")
    public WebElement learnMoreButton;

    @FindBy(css = ".c-button.c-button-secondary.c-button-sm.sign-in-btn")
    public WebElement signInButton;

    @FindBy(css = ".plButton-label.v-ellipsis")
    public WebElement accountName;

    @FindBy(css = ".c-button-unstyled.hamburger-menu-button")
    public WebElement menuButton;

    @FindBy(xpath = "//button[@data-id=\"node-598\"]")
    public WebElement audioButton;

    @FindBy(xpath = "//button[@data-id=\"node-549\"]")
    public WebElement headphonesButton;

    @FindBy(linkText = "Wireless Headphones")
    public WebElement wirelessHeadphones;

    public void chooseUS(){
        country.click();
    }

    public void closePopUp(){
        popUpCloseButton.click();
    }

    public void verifyLogo(){
        Assert.assertTrue(bestBuyLogo.isDisplayed());
    }

    public void searchFor(String search){
        searchBar.click();
        searchBar.sendKeys(search);
        searchButton.click();
    }

    public void openDropdown(String section) {
        String locator = "//span[text()='"+section+"']";
        Driver.get().findElement(By.xpath(locator)).click();
    }

    public void openSubmenu(String submenu) {
        Helper.clickWithLinkText(submenu);
    }

    public void openMyCreditCardPage(){
        learnMoreButton.click();
    }

    public void verifyTitle() {
        String title = Driver.get().getTitle();
        Assert.assertEquals("Best Buy | Official Online Store | Shop Now & Save",title);
    }

    public void clickSignInButton(){
        signInButton.click();
    }
    public void verifyAccountName(){
        Assert.assertEquals("Hi, Example",accountName.getText());
    }

    public void clickMenu() {
        menuButton.click();
    }

    public void openWirelessHeadphones() {
        audioButton.click();
        headphonesButton.click();
        wirelessHeadphones.click();
    }
}
