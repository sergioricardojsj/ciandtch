package com.ciandt.configuration;

import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OptionsManager {

    private static OptionsManager optionsManager;

    private OptionsManager() {}

    public static synchronized OptionsManager getInstance() {
        if (optionsManager == null) {
            synchronized (OptionsManager.class) {
                if (optionsManager == null) {
                    optionsManager = new OptionsManager();
                }
            }
        }

        return optionsManager;
    }

    public ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        this.setProperties();

        chromeOptions.addArguments(this.getChromeArguments())
                .setExperimentalOption("prefs", this.getChromePrefs());

        return chromeOptions;
    }

    private Map<String, Object> getChromePrefs() {
        return Map.of(
                "profile.default_content_settings.popups", 0,
                "download.default_directory", System.getProperty("user.home") + "/Downloads"
        );
    }

    private List<String> getChromeArguments() {
        return Arrays.asList(
                "--headless",
                "--no-sandbox",
                "--disable-dev-shm-usage",
                "--disable-infobars",
                "--disable-extensions",
                "--window-size=1920,1080"
        );
    }

    private void setProperties() {
        System.setProperty("webdriver.chrome.args", "--disable-logging");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        System.setProperty(
                "webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/test/resources/chromedriver"
        );
    }

}
