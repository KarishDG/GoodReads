package com.selenium.test.test;

import com.selenium.test.pages.*;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.selenium.test.webtestsbase.Browser.CHROME;
import static junit.runner.BaseTestRunner.setPreference;
import static org.junit.Assert.assertEquals;

public class MyBooksPageTest {

    WebDriver driver;
    GoodreadsPage goodreadsPage;
    GoodreadsSearchResultsPage goodreadsSearchResultsPage;
    GoodreadsUserAccountMainPage goodreadsUserAccountMainPage;
    GoodreadsMyBookPage goodreadsMyBookPage;

    @BeforeMethod
    void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", GoodreadsConstants.chromeDriverPath);
        System.setProperty("webdriver.gecko.driver", GoodreadsConstants.firefoxDriverPath);
        setPreference("capability.policy.default.Window.frameElement.get","allAccess");

        WebDriverFactory.startBrowser(true, CHROME);
        driver = WebDriverFactory.getDriver();

        goodreadsPage = new GoodreadsPage(driver);
        goodreadsSearchResultsPage = new GoodreadsSearchResultsPage(driver);
        goodreadsUserAccountMainPage = new GoodreadsUserAccountMainPage(driver);
        goodreadsMyBookPage = new GoodreadsMyBookPage(driver);

        driver.get(GoodreadsConstants.baseURL);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        goodreadsPage.loginToAccount(GoodreadsConstants.demoUser, GoodreadsConstants.demoUserPassword);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    //Test Case 001: Verify, that book was added to User account Bookshelves: Want To Read

    @Test
    public void userAccountBookshelvesWantToRead(){
        goodreadsUserAccountMainPage.selectTitleFromDropdown(GoodreadsConstants.bookTitle);
        goodreadsSearchResultsPage.wantToReadButton.click();
        goodreadsUserAccountMainPage.myBooks.click();
        goodreadsMyBookPage.wantToReadList.click();
        assertEquals(GoodreadsConstants.bookTitle, goodreadsMyBookPage.titleField.getText());
    }


    @AfterMethod
    void tearDown() throws Exception {

        WebDriverFactory.finishBrowser();


    }

}