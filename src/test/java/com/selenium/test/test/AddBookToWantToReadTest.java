package com.selenium.test.test;

import com.selenium.test.pages.GoodreadsConstants;
import com.selenium.test.pages.GoodreadsPage;
import com.selenium.test.pages.GoodreadsSearchResultsPage;
import com.selenium.test.pages.GoodreadsUserAccountMainPage;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.selenium.test.webtestsbase.Browser.CHROME;
import static com.selenium.test.webtestsbase.Browser.FIREFOX;
import static com.selenium.test.webtestsbase.Browser.SAFARI;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddBookToWantToReadTest {

    WebDriver driver;
    GoodreadsPage goodreadsPage;
    GoodreadsSearchResultsPage goodreadsSearchResultsPage;
    GoodreadsUserAccountMainPage goodreadsUserAccountMainPage;

    @BeforeMethod
    void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", GoodreadsConstants.chromeDriverPath);

        WebDriverFactory.startBrowser(true, CHROME);
        driver = WebDriverFactory.getDriver();

        goodreadsPage = new GoodreadsPage(driver);
        goodreadsSearchResultsPage = new GoodreadsSearchResultsPage(driver);
        goodreadsUserAccountMainPage = new GoodreadsUserAccountMainPage(driver);

        driver.get(GoodreadsConstants.baseURL);
        //driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        goodreadsPage.loginToAccount(GoodreadsConstants.demoUser, GoodreadsConstants.demoUserPassword);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    //Test Case 001: Verify, that user is able to add book from search results page to "Want To Read"

   @Test
    public void wantToReadTitleFromSearchResultsPage() {

        goodreadsUserAccountMainPage.searchBookTitle(GoodreadsConstants.searchTitle);
        goodreadsSearchResultsPage.wantToReadButton.click();
        assertTrue(goodreadsSearchResultsPage.statusToRead.isDisplayed());
    }

    //Test Case 002: Verify, that user is able to add book to "Want To Read" using dropdown list from search results page

    @Test
    public void wantToReadTitleFromDropdownListFromSearchResultsPage(){
        goodreadsUserAccountMainPage.searchBookTitle(GoodreadsConstants.searchTitle);
        goodreadsSearchResultsPage.dropdownBookList.click();
        goodreadsSearchResultsPage.wantToReadList.click();
        assertTrue(goodreadsSearchResultsPage.statusToRead.isDisplayed());
    }



    //Test Case 003: Verify, that user is able to add book from book page to "Want To Read"

    @Test
    public void wantToReadBookPage(){
        goodreadsUserAccountMainPage.selectTitleFromDropdown(GoodreadsConstants.searchTitle);
        goodreadsSearchResultsPage.wantToReadButton.click();
        assertTrue(goodreadsSearchResultsPage.statusToRead.isDisplayed());

    }

    //Test Case 004: Verify, that user is able to add book to "Want To Read" using dropdown list from book page

   @Test
    public void wantToReadBookPageFromDropdown(){
        goodreadsUserAccountMainPage.selectTitleFromDropdown(GoodreadsConstants.searchTitle);
        goodreadsSearchResultsPage.dropdownBookList.click();
        goodreadsSearchResultsPage.wantToReadList.click();
        assertTrue(goodreadsSearchResultsPage.statusToRead.isDisplayed());

    }



    @AfterMethod
    void tearDown() throws Exception {

        Actions moveMouse = new Actions(driver);
        moveMouse.moveToElement(goodreadsSearchResultsPage.statusToRead);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        moveMouse.moveToElement(goodreadsSearchResultsPage.removeBook).click().build().perform();
        Alert removeBookAlert = driver.switchTo().alert();
        removeBookAlert.accept();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@title='Remove this book from your shelves']")));

        WebDriverFactory.finishBrowser();

    }





}
