package bootcamp.pages;

import bootcamp.utils.Driver;
import bootcamp.utils.Helper;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signinpage {
    public Signinpage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(tagName = "h1")
    public WebElement header;

    @FindBy(id = "fld-e")
    public WebElement emailBar;

    @FindBy(id = "fld-p1")
    public WebElement passwordBar;

    public void verifyHeader(){
        Assert.assertEquals("Sign In to Best Buy",header.getText());
    }

    public void signIn(){
        emailBar.sendKeys("newaccounttest@gmail.com");
        passwordBar.sendKeys("examplelogin"+ Keys.ENTER);
    }


}
