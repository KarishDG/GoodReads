package com.selenium.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoodreadsMyBookPage {
    WebDriver driver;

    @FindBy(xpath = "//div[@class='userShelf']//*[contains(text(),'Want to Read')]")
    public WebElement wantToReadList;

    @FindBy(xpath = "//a[@class='selectedShelf']")
    public WebElement allList;

    @FindBy(xpath = "//div[@id='paginatedShelfList']//div[1]")
    public WebElement readList;

    @FindBy(xpath = "//div[@class='userShelf']//*[contains(text(),'Currently Reading')]")
    public WebElement currentlyReadingList;

    @FindBy(xpath = "//td[@class='field title']//div[@class='value']")
    public WebElement titleField;

    @FindBy(xpath = "//a[@class='shelfChooserLink smallText']")
    public WebElement editShelves;

    @FindBy(xpath = "//li[@id='shelfChooser0shelf_read']//span[contains(text(),'read')]")
    public WebElement readShelves;

    @FindBy(xpath = "//a[@class='shelfLink']")
    public WebElement shelvesStatus;

    public GoodreadsMyBookPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
