package bootcamp.pages;

import bootcamp.utils.Driver;
import bootcamp.utils.Helper;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
    public SearchResultPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(className = "search-title")
    public WebElement verifySearch;

    @FindBy(xpath = "//*[@id=\"main-filters\"]/div[3]/div[2]/section[1]/fieldset/ul/li[9]/button")
    public WebElement showMoreButton;

    @FindBy(id = "brand_facet-Philips-modal-0")
    public WebElement philipsFilter;

    @FindBy(xpath = "//button[@class=\"c-button c-button-secondary c-button-md large-facet-group-show-results\"]")
    public WebElement showResultsButton;

    @FindBy(linkText = "Philips - True Wireless In-Ear Headphones T3215 with Splash Resistance - Black")
    public WebElement secondProduct;

    String filterContainer = "//*[@id=\"shop-product-list-41897010\"]/div/div/div/div[2]/div[1]/div[1]/div[2]";

    public void verifySearchFor(String search){
        String text = verifySearch.getText().replace("\"","");
        Assert.assertEquals(search,text);
    }

    public void filterPhilips() {
        Driver.moveByOffset(350,250);
        Helper.waitFor(2);
        showMoreButton.click();
        philipsFilter.click();
        Helper.waitFor(2);
        showResultsButton.click();
    }

    public void clickSecondProduct() {
        secondProduct.click();
    }


}
