package com.qa.util;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElementUtil {

    private WebDriver driver;

    public ElementUtil(WebDriver driver) {
        this.driver = driver;
    }

    public void sendKeys(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }

    public void click(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public String getText(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public void openUrl(String url) {
        driver.get(url);
    }
    public void hoverOverElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
    public void dropDownElement(WebElement element, String value) {
        try {
            Select select = new Select(element);
            select.selectByValue(value);
        } catch (NoSuchElementException e) {
            System.err.println("No option with value: " + value);
        } catch (WebDriverException e) {
            System.err.println("Error interacting with the dropdown element: " + e.getMessage());
        }
    }
    public void scrollIntoView() {
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	 js.executeScript("window.scrollBy(0,1000)");
    }

}