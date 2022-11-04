package com.upgenix.pages;

import com.upgenix.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class LoginPage {
    static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "login")
    private static WebElement emailBox;

    @FindBy(id = "password")
    private static WebElement passwordBox;

    @FindBy(xpath = "//button[@type='submit']")
    private static WebElement loginBtn;

    @FindBy(xpath = "//p[@class]")
    private static WebElement wrongPassMsg;

    @FindBy(xpath = "//span[@class='oe_topbar_name']")
    private static WebElement userIDMenu;

    @FindBy(xpath = "//a[.='Log out']")
    private static WebElement logOutMenu;

    public static void isAtLoginPage() {

        String loginPageTitle = "Login | Best solution for startups";

        Assert.assertEquals(loginPageTitle, Driver.getDriver().getTitle());
        System.out.println("Login Page Verified");

        emailBox.clear();
        passwordBox.clear();
    }

    public static void ValidCredentials(String username, String password) {

        emailBox.sendKeys(username);
        passwordBox.sendKeys(password);
    }

    public static void InvalidCredentials(String username, String password) {

        emailBox.sendKeys(username);
        passwordBox.sendKeys(password);
    }

    public static void EmptyCredentials(String username, String password) {

        emailBox.sendKeys(username);
        passwordBox.sendKeys(password);
    }

    public static void clickLoginBtn() {

        loginBtn.click();
    }

    public static void isAtDashboardPage() {

        wait.until(ExpectedConditions.visibilityOf(userIDMenu));
        System.out.println("Dashboard Page Verified");
    }

    public static void wrongPassErrorMsgIsDisplayed(String message) {

        Assert.assertTrue(wrongPassMsg.isDisplayed());
        System.out.println("Alert message verified --> " + wrongPassMsg.getText());

    }

    public static void emptyFieldAlert() {
        System.out.println(emailBox.getAttribute("validationMessage") + "email");
        System.out.println(passwordBox.getAttribute("validationMessage") + "password");
    }

    public static void enterKeyVerification() {

        passwordBox.sendKeys(Keys.ENTER);
    }

    public static void LogOut() {
        userIDMenu.click();
        logOutMenu.click();
    }
}