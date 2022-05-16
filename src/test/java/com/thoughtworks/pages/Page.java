package com.thoughtworks.pages;

import org.openqa.selenium.WebDriver;

public class Page extends AbstractPage {
    public Page(WebDriver driver) {
        super(driver);
    }

    public TechRadarPage toTechRadarPage() {
        return new TechRadarPage(driver);
    }
}
