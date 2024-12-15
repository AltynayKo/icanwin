package com.elearn.ta.models;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

abstract class BasePage {
    protected WebDriver driver;
    protected final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(10);

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    abstract BasePage openPage();

}
