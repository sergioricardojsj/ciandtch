package com.ciandt.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TLDriverFactory {

    private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    private static final OptionsManager optionsManager = OptionsManager.getInstance();

    public static synchronized void setDriver() {
        tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
    }

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }

    public static synchronized void endDriver() {
        tlDriver.get().quit();
        tlDriver.remove();
    }

}
