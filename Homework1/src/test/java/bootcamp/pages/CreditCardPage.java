package bootcamp.pages;

import bootcamp.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditCardPage {
    public CreditCardPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css = "a.btn.btn-secondary.btn-lg")
    public WebElement applyButton;

    public void openApplyPage() {
        applyButton.click();
    }


}
