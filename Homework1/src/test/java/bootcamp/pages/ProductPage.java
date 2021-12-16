package bootcamp.pages;

import bootcamp.utils.Driver;
import bootcamp.utils.Helper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    public ProductPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//button[@class=\"save-for-later-save\"]")
    public WebElement saveButton;

    @FindBy(linkText = "Go to your saved items")
    public WebElement openSavedItems;

    public void saveProduct() {
        Helper.waitFor(2);
        saveButton.click();
        saveButton.click();
    }
    public void openSavedItems() {
        Helper.waitFor(2);
        openSavedItems.click();
    }


}
