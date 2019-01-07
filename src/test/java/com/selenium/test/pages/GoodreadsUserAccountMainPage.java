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

    @FindBy(xpath = "/html/body/div[3]/div/header/div[1]/div/div[2]/form/input")
    WebElement searchForm;

    @FindBy(xpath = "/html/body/div[3]/div/header/div[1]/div/div[2]/form/button")
    WebElement searchButton;

    @FindBy(xpath = "//div[@id='bookSearchResultsThe Art of Software Testing5']/div[1]/div[1]")
    WebElement titleResult;

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
