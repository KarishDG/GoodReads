package com.selenium.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoodreadsSearchResultsPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"1_book_877789\"]/div[1]/form/button/span[1]")
    public WebElement wantToReadButton;

    @FindBy(xpath = "//button[@class='wtrStatusToRead wtrUnshelve']")
    public WebElement statusToRead;

    @FindBy(xpath = "//button[@title='Remove this book from your shelves']")
    public WebElement removeBook;

    @FindBy(xpath = "//div[@id='1_book_877789']//button[@class='wtrShelfButton']")
    public WebElement dropdownBookList;

    @FindBy(xpath = "//button[@value='to-read']//span[@class='progressTrigger'][contains(text(),'Want to Read')]")
    public WebElement wantToReadList;



    public GoodreadsSearchResultsPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
