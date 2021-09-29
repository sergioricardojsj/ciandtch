package com.ciandt.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver;

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void scrollToElement(WebElement element) {
        int elementLocation = element.getLocation().y;

        if (elementLocation > 1000) {
            int resto = elementLocation % 1000;
            elementLocation = elementLocation - resto;
        }

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, " + elementLocation + ")");
    }

    public void moveToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void waitPageLoad() {
        new WebDriverWait(driver, 60)
                .until(webDriver -> ((JavascriptExecutor) webDriver))
                .executeScript("return document.readyState").equals("complete");
    }

    public void waitForElementToShowUp(WebElement element) {
        try {
            new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void selectElement(WebElement element, String value) {
        Select select = new Select(element);
        try { select.selectByValue(value);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

}
