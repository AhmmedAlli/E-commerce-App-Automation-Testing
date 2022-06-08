package org.example.StepsCode;
import org.example.Pages.HomePage;
import org.example.Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;


public class C02_Login {



    @Given("User navigate to login page")
    public void goToLoginPage()
    {
        LoginPage.goToLoginPage();
    }

    @When("^User enter valid email")
    public void emailField()
    {
         LoginPage.emailField().sendKeys(Hooks.Email);
    }

    @And("User enter valid password")
    public void passwordField ()
    {
         LoginPage.passwordField().sendKeys(Hooks.Password);
    }

    @And("User Click to login button")
    public void loginBtn() throws InterruptedException {
        LoginPage.loginBtn().click();
    }

    @Then("User could be logged in successfully")
    public void login_Successfully() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(HomePage.actualResult(),HomePage.expectedResult());
        Thread.sleep(1000);
        soft.assertTrue(Hooks.driver.findElement(By.cssSelector("div[class=\"footer-block my-account\"]>div[class=\"title\"]")).isDisplayed());

        soft.assertAll();
    }


}
