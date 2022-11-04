package com.upgenix.pages;

import com.upgenix.utilities.ConfigurationReader;
import com.upgenix.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[contains(@href,'login')]")
    public static WebElement loginMenu;

    public static void goTo() {
        Driver.getDriver().get(ConfigurationReader.getProperty("homepageurl"));
    }

    public static void isAtHomePage() {

        String homePageTitle = "UPGENIX - ERP for startups";

        Assert.assertEquals(homePageTitle, Driver.getDriver().getTitle());
        System.out.println("Home Page Verified");
    }

    public static void goToLoginPage() {
        loginMenu.click();
    }
}