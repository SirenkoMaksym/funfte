/*
 * created by $
 */


package de.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static de.search.utils.EmailUtils.sendEmail;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "site-search-query")
    WebElement inputName;
    @FindBy(xpath = "//*[@id='browsebox-searchform']//li[5]")
    WebElement inputMark;
    @FindBy(id = "gdpr-banner-accept")
    WebElement cookie;

    public HomePage ebayNameEnter(String autoName) {
        click(cookie);
        type(inputName, autoName);
        return this;
    }

    @FindBy(id = "autos.power_i-submit")
    WebElement confirmPrice;
    @FindBy(id = "srchrslt-brwse-price-max")
    WebElement inputMaxPrice;

    public HomePage ebayMaxPriceEnter(String maxPrice) {
        pause(1000);
        type(inputMaxPrice, maxPrice);
        click(confirmPrice);
        return this;
    }

    @FindBy(id = "autos.ez_i-submit")
    WebElement confirmYear;
    @FindBy(id = "brwse-attr-autos.ez_i-min")
    WebElement inputMinYear;

    public HomePage enterYear(String minYear) {
        type(inputMinYear, minYear);
        click(confirmYear);
        return this;
    }

    @FindBy(id = "autos.km_i-submit")
    WebElement confirmKm;

    @FindBy(id = "site-search-area")
    WebElement locationInput;
    @FindBy(xpath = "//*[@id='site-search-distance-inpt']//li[4]")
    WebElement inputRadius;
    @FindBy(id = "site-search-distance-inpt")
    WebElement inputRadius1;

    public void enterLocation(String location) {
        type(locationInput, location);
        click(inputRadius1);
        click(inputRadius);

    }

    @FindBy(id = "site-search-submit")
    WebElement submitButton;

    public HomePage enterFind() {
        click(submitButton);
        return this;
    }

    @FindBy(xpath = "//ul[@id='srchrslt-adtable']/li[1]/article/div[2]/div[1]/div[2]")
    WebElement dayWerbung;

    @FindBy(xpath = "//ul[@id='srchrslt-adtable']/li[1]/article[1]/div[2]/div[2]/h2[1]/a[1]")
    WebElement nameFindenAuto;

    public void kontrolPrice() {
        pause(1000);
        if (dayWerbung.getText().contains("Heute")) {
            sendEmail(nameFindenAuto.getText());
        }
    }

    @FindBy(xpath = "//*[@id='browsebox-searchform']//*[.='Diesel']")
    WebElement diesel;

    public HomePage enterDiesel() {
        click(diesel);
        return this;
    }

    @FindBy(xpath = "//*[@id='browsebox-searchform']//*[.='Manuell']")
    WebElement hande;

    public HomePage enterHande() {
        click(hande);
        return this;
    }
}
