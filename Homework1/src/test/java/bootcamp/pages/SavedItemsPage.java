package bootcamp.pages;

import bootcamp.utils.Driver;
import bootcamp.utils.Helper;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SavedItemsPage {
    public SavedItemsPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(linkText = "Philips - True Wireless In-Ear Headphones T3215 with Splash Resistance - Black")
    public WebElement secondProduct;

    public void verifyItem() {
        Helper.waitFor(1);
        Assert.assertEquals("Philips - True Wireless In-Ear Headphones T3215 with Splash Resistance - Black",secondProduct.getText());
    }
}
