package bootcamp.step_def;

import bootcamp.pages.*;
import bootcamp.utils.Helper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
    Homepage homepage = new Homepage();
    SearchResultPage searchResultPage = new SearchResultPage();
    Signinpage signinpage = new Signinpage();
    CreditCardPage creditCardPage = new CreditCardPage();
    CardApplicationPage cardApplicationPage = new CardApplicationPage();
    ProductPage productPage = new ProductPage();
    SavedItemsPage savedItemsPage = new SavedItemsPage();

    @Given("homepage is open")
    public void homepageIsOpen() {
        homepage.chooseUS();
    }

    @When("I close the pop up")
    public void ıCloseThePopUp() {
        homepage.closePopUp();
    }

    @Then("logo should be displayed")
    public void logoShouldBeDisplayed() {
        homepage.verifyLogo();
    }

    @When("I search for {string}")
    public void ıSearchFor(String search) {
        homepage.searchFor(search);
    }

    @Then("search result {string} should be seen")
    public void searchResultShouldBeSeen(String search) {
        searchResultPage.verifySearchFor(search);
    }

    @And("I open the {string} dropdown menu")
    public void ıOpenTheDropdownMenu(String section) {
        homepage.openDropdown(section);
    }

    @When("I choose {string} submenu")
    public void ıChooseSubmenu(String submenu) {
        homepage.openSubmenu(submenu);
    }

    @Then("sign in page should open")
    public void signInPageShouldOpen() {
        signinpage.verifyHeader();
    }

    @When("I open my best buy credit card page")
    public void ıOpenMyBestBuyCreditCardPage() {
        homepage.openMyCreditCardPage();
    }

    @And("I open application page")
    public void ıOpenApplicationPage() {
        creditCardPage.openApplyPage();
    }

    @Then("application page should be open")
    public void applicationPageShouldBeOpen() {
        cardApplicationPage.verifyTitle();
    }

    @And("I verify the page title")
    public void ıVerifyThePageTitle() {
        homepage.verifyTitle();
    }

    @And("I fill the login page")
    public void ıFillTheLoginPage() {
        signinpage.signIn();
    }

    @Then("should be logged in")
    public void shouldBeLoggedIn() {
        homepage.verifyAccountName();
    }

    @And("I choose Sign In")
    public void ıChooseSignIn() {
        homepage.clickSignInButton();
    }

    @When("I open {string} in new tab")
    public void ıOpenInNewTab(String url) {
        Helper.openNewTab(url);
        Helper.switchToNewWindow();
    }

    @And("I choose menu")
    public void ıChooseMenu() {
        homepage.clickMenu();
    }

    @And("I open wireless headphones")
    public void ıOpenWirelessHeadphones() {
        homepage.openWirelessHeadphones();
    }

    @And("I filter philips brand")
    public void ıFilterPhilipsBrand() {
        searchResultPage.filterPhilips();
    }

    @And("I open second product")
    public void ıOpenSecondProduct() {
        searchResultPage.clickSecondProduct();
    }

    @And("I save the product")
    public void ıSaveTheProduct() {
        productPage.saveProduct();
    }

    @And("I open saved items")
    public void ıOpenSavedItems() {
        productPage.openSavedItems();
    }

    @Then("title of the saved product should be on the list")
    public void titleOfTheSavedProductShouldBeOnTheList() {
        savedItemsPage.verifyItem();
    }


}
