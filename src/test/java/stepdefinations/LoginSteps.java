package stepdefinations;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.Constants;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    @SuppressWarnings("deprecation")
	public LoginSteps() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

//Background  
    
    @Given("I am on Alliance Home Page")
    public void i_am_on_alliance_home_page() {
    	loginPage.openLoginPage();
    }
    @When("I click on Sign In button")
    public void i_click_on_sign_in_button() throws InterruptedException {
    	loginPage.clickSignin();
    }
    @And("User is in the sign in page")
    public void user_is_in_the_sign_in_page() throws InterruptedException {
    	String expUrl = loginPage.getExpectedUrl();
        String actUrl = loginPage.getCurrentUrl();
        System.out.println("Actual Url is: " + actUrl);
        if (!expUrl.equals(actUrl)) {
            fail("Page did not navigate to sign-in page");
        }
        Thread.sleep(2000);
    }
    @And("user is in login page enter the correct username and correct password")
    public void user_is_in_login_page_enter_the_correct_username_and_correct_password() throws InterruptedException {
    	loginPage.Login();
    }
    @Then("Home is displayed with expectedUserName")
    public void Home_is_displayed_with_expectedUserName() {
    	String ActualUserName=loginPage.actualusername();
    	String expectedUserName=Constants.EXPECTED_USER_NAME;
    	System.out.println("Actual UserName is: " + ActualUserName);
        assertEquals(ActualUserName, expectedUserName);
    }
  
 //Scenario-1
    
    @Given("user is in homepage")
    public void user_is_in_homepage() {   
    }
    @When("click on the globe icon")
    public void click_on_the_globe_icon() {
        loginPage.clickGlobeIcon();
    }
    @And("click on Sandbox Private")
    public void click_on_sandbox_private() {
    	loginPage.clickSandboxPrivate();
    }
    @And("mousehover to SellNetwork")
    public void mousehover_to_sell_network() {
    	loginPage.getMenuElement();
    }
    @And("Click on MyPlaceSetup")
    public void Click_on_MyPlaceSetup() {
    	loginPage.selectMyplacesetup();
    }
    @Then("MyPlaceSetUp page should display")
    public void MyPlaceSetUp_page_should_display() {	
    }
    
    
//Scenario-2   
    
    @Given("user is in MyplaceSetup module")
    public void user_is_in_MyplaceSetup_module() {
    	loginPage.clickGlobeIcon();
    	loginPage.clickSandboxPrivate();
    	loginPage.getMenuElement();
    	loginPage.selectMyplacesetup();
    }
    @When("click on the organization close icon")
    public void click_on_the_organization_close_icon() {
       loginPage.clickClearIcon();
    }
    @And("enter the orgname and select the org")
    public void enter_the_orgname_and_select_the_org () {
    	loginPage.enterOrgName();
    	loginPage.selectOrganization();
    }
    @Then("MyPlaceforpats page should display as blank")
    public void my_placeforpats_page_should_display_as_blank() { 
    }
    
//Scenario-3   
    
    @Given("user is in MyplaceSetup module to add sellnetwork")
    public void user_is_in_MyplaceSetup_module_to_add_sellnetwork() {
    	loginPage.clickGlobeIcon();
    	loginPage.clickSandboxPrivate();
    	loginPage.getMenuElement();
    	loginPage.selectMyplacesetup();
    	loginPage.clickClearIcon();
    	loginPage.enterOrgName();
    	loginPage.selectOrganization();
    }
    @When("user select Copy Sellnetwork From checkbox")
    public void user_select_copy_sellnetwork_from_checkbox() {
     loginPage.clickCopySellNetworkFrom();
    }
    @And("Select store from dropdown")
    public void select_store_from_dropdown() {
    	loginPage.scrollToStoreDropdown();
    	loginPage.selectStoreDropdownOption();
    }
    @And("Select location from dropdown")
    public void select_location_from_dropdown() {
       loginPage.selectLocationDropdownOption();
    }
    @And("select Primary Details checkbox")
    public void select_primary_details_checkbox() {
    	loginPage.clickPrimaryDetails();
    }
    @And("Click on Go button")
    public void click_on_go_button() {
    	loginPage.clickGo();
    }
    @And("Click on OK button for confirm message") 
    public void click_on_OK_button_for_confirm_message() throws InterruptedException{
    	loginPage.clickOK();
    }
    @Then("It should display the sellnetwork which are available in the selected location")
    public void it_should_display_the_sellnetwork_which_are_available_in_the_selected_location() {
        String expectedTitle="Success";
    	String actualTitle=loginPage.titleSuccess();
        System.out.println(actualTitle);
        assertEquals(actualTitle, expectedTitle);
    }
}
