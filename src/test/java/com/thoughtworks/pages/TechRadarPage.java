package com.thoughtworks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TechRadarPage extends Page {

    public TechRadarPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getDownloadButtonOnNarBar() {
        return driver.findElement(By.cssSelector("#cmp-sub-navigation__list > li:nth-child(1) > a"));
    }
}
