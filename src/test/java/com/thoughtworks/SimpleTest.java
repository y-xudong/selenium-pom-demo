package com.thoughtworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleTest {

    private static WebDriver driver;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterAll
    static void afterAll() {
        driver.close();
    }

    @Test
    void should_have_download_button_when_open_tech_radar_page() {
        driver.get("https://www.thoughtworks.com");
        WebElement insightsButton = driver.findElement(By.cssSelector("header > div.cmp-header__navigation-section > nav > div > div > ul > li:nth-child(3)"));
        insightsButton.click();
        WebElement techRadarButton = driver.findElement(By.cssSelector("header > div.cmp-header__navigation-section > nav > div > div > ul > li.cmp-navigation__item.cmp-navigation__item--level-0.cmp-navigation__item--active > div > div > ul > div > li:nth-child(2) > ul > li:nth-child(1) > a"));
        techRadarButton.click();
        WebElement downloadButton = driver.findElement(By.cssSelector("#cmp-sub-navigation__list > li:nth-child(1) > a"));
        assertThat(downloadButton.getText(), is("Download"));
    }
}
