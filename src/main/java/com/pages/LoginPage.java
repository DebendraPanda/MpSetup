package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.Constants;
import com.qa.util.ElementUtil;

public class LoginPage {
    private WebDriver driver;
    private ElementUtil elementUtil;

    // Locators
    private By usernameField = By.xpath("//input [@id='cognito_custom_login_screenName']");
    private By passwordField = By.xpath("//input [@id='cognito_custom_login_password']");
    private By loginButton = By.xpath("//button[@id='cognito_custom_login_submit']");
    private By actualUserName = By.xpath("//span[text()='Sandbox Admin']");
    private By signinButton = By.xpath("(//a[@class='login-btn'])[1]");
//    private String applicationUrl = "https://staging.allianceconnect.com/web/sandbox";
    private By globeIcon=By.xpath("(//li[contains(@data-toggle,'dropdown')] )[1] ");
    private By sandboxPrivate=By.xpath("(//a[contains(@href,'/group/sandbox')] )[2]");
    private By sellnetwork=By.xpath("(//span[@class='text-truncate'])[2]");
    private By mpsetup=By.xpath("//a[text()='MyPlaceSetUp']");
    private By clearIcon=By.xpath("//span[@title='Clear']");
    private By orgName=By.xpath("//input[@id='filterOrg']");
    private By selectOrg=By.xpath("//span[@title='automationorg (0)']");
    private By copySellNetworkFrom=By.xpath("//span[text()='Copy SellNetwork from:']");
    private By selectStore=By.xpath("(//select[starts-with(@class, 'form-control')])[1]");
    private By selectLocation=By.xpath("(//select[starts-with(@class, 'form-control')])[2]");
    private By primaryDetails=By.xpath("//span[text()='Details' and @class='custom-control-label']");
    private By goButton=By.xpath("//button[text()=' Go ' and @class='btn btn-secondary aapa-dxp-button' ]");
    private By okButton=By.xpath("//span[text()='OK']");
    private By success=By.xpath("//span[text()='Success']");
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtil = new ElementUtil(driver);
    }

    
    // Actions
    public void openLoginPage() {
        elementUtil.openUrl(Constants.APPLICATION_URL);
    }
    public void clickSignin() throws InterruptedException {
        elementUtil.click(signinButton);
    }
    public void Login() throws InterruptedException {
    	elementUtil.click(usernameField);
        elementUtil.sendKeys(usernameField, Constants.USERNAME);
        elementUtil.click(passwordField);
        elementUtil.sendKeys(passwordField, Constants.PASSWORD);
//        Thread.sleep(2000);
        elementUtil.click(loginButton);
    }

    public String getExpectedUrl() {
        return Constants.APPLICATION_URL + "?p_p_id=com_liferay_login_web_portlet_LoginPortlet&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&_com_liferay_login_web_portlet_LoginPortlet_mvcRenderCommandName=%2Flogin%2Flogin&saveLastPath=false";
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String actualusername() {
        return elementUtil.getText(actualUserName);
    }
   
    public void clickGlobeIcon() {
        elementUtil.click(globeIcon);
    }
    public void clickSandboxPrivate() {
        elementUtil.click(sandboxPrivate);;
    }
    public void getMenuElement() {
        WebElement menu = elementUtil.getElement(sellnetwork);
        elementUtil.hoverOverElement(menu);
    }
    public void selectMyplacesetup() {
    	elementUtil.click(mpsetup);
    }
    public void clickClearIcon() {
    	elementUtil.click(clearIcon);
    }
    public void enterOrgName() {
        elementUtil.sendKeys(orgName, Constants.ORG_NAME);
    }
    
    public void selectOrganization() {
    	elementUtil.click(selectOrg);
    }
    public void clickCopySellNetworkFrom() {
    	elementUtil.click(copySellNetworkFrom);
    }
    public void scrollToStoreDropdown() {
        elementUtil.scrollIntoView();
    }
    public void selectStoreDropdownOption() {
        WebElement dropdown = elementUtil.getElement(selectStore);
        elementUtil.dropDownElement(dropdown, Constants.STORE_NAME);
    }
    public void selectLocationDropdownOption() {
    	WebElement dropdown=elementUtil.getElement(selectLocation);
    	elementUtil.dropDownElement(dropdown,Constants.LOCATION_NAME);
    }
    public void clickPrimaryDetails() {
        elementUtil.click(primaryDetails);
    }
    public void clickGo() {
        elementUtil.click(goButton);
    }
    public void clickOK() throws InterruptedException {
        elementUtil.click(okButton);
        Thread.sleep(2000);
    }
    public String titleSuccess() {
    	return elementUtil.getText(success);
    }
}