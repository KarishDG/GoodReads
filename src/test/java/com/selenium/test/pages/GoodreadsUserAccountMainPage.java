package com.selenium.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoodreadsUserAccountMainPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@class='searchBox__input searchBox__input--navbar']")
    public WebElement searchForm;

    @FindBy(xpath = "//div[@class='searchBox searchBox--navbar']//button[@type='submit']")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@class='gr-bookSearchResults__item'][1]")
    public WebElement titleResult;

    @FindBy(xpath = "//nav[@class='siteHeader__primaryNavInline']//a[@class='siteHeader__topLevelLink'][contains(text(),'My Books')]")
    public WebElement myBooks;

    public void insertSearchTitle(String title) {
        searchForm.sendKeys(title);
    }

    public void selectTitleFromDropdown (String title) {
        searchForm.sendKeys(title);
        titleResult.click();
    }

    public void searchBookTitle(String title) {
        searchForm.sendKeys(title);
        searchButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"1_book_877789\"]/div[1]/form/button/span[1]")));
    }

    public GoodreadsUserAccountMainPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
