package org.example.StepsCode;

import org.example.Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class C03_Reset_Password {


    @Given("User navigate to login page directly")
    public void goToLoginPage()
    {
        LoginPage.goToLoginPage();
    }


    @When("User enter the reset password button")
      public void clickForgetBtn(){
        Hooks.driver.findElement(By.cssSelector("span > a[href=\"/passwordrecovery\"]")).click();
    }

    @And("User enter his email to send the key to reset the password")
    public void enterEmailOfUser()
    {
            LoginPage.emailField().sendKeys(Hooks.Email);

    }

    @And("User clicked to reset button")
    public void clickRestBtn() throws InterruptedException {
        Hooks.driver.findElement(By.name("send-email")).click();
        Thread.sleep(500);
    }

    @Then("The website send to email hsa been register")
    public void restPasswordSuccessfully()
    {
        SoftAssert soft = new SoftAssert();
        // confirm the valid scenario of reset password
        String actualMsg = Hooks.driver.findElement(By.cssSelector("div > p[class=\"content\"]")).getText();
        String expectedMsg = "Email with instructions has been sent to you.";
        soft.assertTrue(actualMsg.contains(expectedMsg),"rest assert");

    }







}
