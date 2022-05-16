package com.thoughtworks;

import com.thoughtworks.pages.HomePage;
import com.thoughtworks.pages.TechRadarPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class POMTest {
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
        HomePage homePage = new HomePage(driver);
        homePage = homePage.open();
        homePage = homePage.clickButtonOnNavBar("Insights");
        TechRadarPage techRadarPage = homePage.clickButtonOnSecondaryNavOptions("Technology Radar").toTechRadarPage();
        WebElement downloadButton = techRadarPage.getDownloadButtonOnNarBar();
        assertThat(downloadButton.getText(), is("Download"));
    }
}
