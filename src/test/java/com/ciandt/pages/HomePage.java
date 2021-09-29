package com.ciandt.pages;

import com.ciandt.configuration.TLDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(xpath = ".//a[contains(text(), 'Browse')]")
    private WebElement browseButton;

    public HomePage() {
        driver = TLDriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    public ProcurarPage acessarPaginaProcurar() {
        browseButton.click();
        return new ProcurarPage();
    }

}
