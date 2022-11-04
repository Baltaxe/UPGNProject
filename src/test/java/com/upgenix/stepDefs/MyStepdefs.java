package com.upgenix.stepDefs;

import com.upgenix.pages.HomePage;
import com.upgenix.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {
        HomePage.goTo();
        HomePage.isAtHomePage();
        HomePage.goToLoginPage();
    }

    @When("user enter valid {string} and {string}")
    public void userEnterValidAnd(String username, String password) {
        LoginPage.isAtLoginPage();
        LoginPage.ValidCredentials(username, password);
    }

    @And("user click login button")
    public void userClickLoginButton() {
        LoginPage.clickLoginBtn();
    }

    @Then("Verify user launched to the dashboard")
    public void verifyUserLaunchedToTheDashboard() {
        LoginPage.isAtDashboardPage();
    }

    @When("user enter invalid {string} and {string}")
    public void userEnterInvalidAnd(String username, String password) {
        LoginPage.InvalidCredentials(username, password);
    }

    @Then("{string} warning message should be displayed")
    public void warningMessageShouldBeDisplayed(String message) {
        LoginPage.wrongPassErrorMsgIsDisplayed(message);
    }

    @When("user enter empty {string} or {string}")
    public void userEnterEmptyAnd(String username, String password) {
        LoginPage.EmptyCredentials(username, password);
    }

    @Then("user see warning message")
    public void userSeeWarningMessage() {
        LoginPage.emptyFieldAlert();
    }

    @And("user push enter key on keyboard")
    public void userPushKeyOnKeyboard() {
        LoginPage.enterKeyVerification();
    }

    @Then("user logs out")
    public void UserLogsOut() {
        LoginPage.LogOut();
    }
}






