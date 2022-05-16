package com.thoughtworks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage open() {
        driver.get("https://www.thoughtworks.com");
        return this;
    }

    public HomePage clickButtonOnNavBar(String buttonText) {
        String cssSelector = "header > div.cmp-header__navigation-section > nav > div > div > ul > li > a[aria-label='%s']";
        cssSelector = String.format(cssSelector, buttonText);
        WebElement buttonToClick = driver.findElement(By.cssSelector(cssSelector));
        buttonToClick.click();
        return this;
    }

    public Page clickButtonOnSecondaryNavOptions(String buttonText) {
        String cssSelector = "header > div.cmp-header__navigation-section > nav > div > div > ul > li.cmp-navigation__item.cmp-navigation__item--level-0.cmp-navigation__item--active > div > div > ul > div > li > ul > li > a[aria-label='%s']";
        cssSelector = String.format(cssSelector, buttonText);
        WebElement buttonToClick = driver.findElement(By.cssSelector(cssSelector));
        buttonToClick.click();
        return new Page(driver);
    }
}
