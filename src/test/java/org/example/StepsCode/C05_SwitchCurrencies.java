package org.example.StepsCode;

import org.example.Pages.HomePage;
import org.example.Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class C05_SwitchCurrencies {

    @Given("User go to website and logged into the website")
    public void loginToWebsite() throws InterruptedException {
        LoginPage.LoginSteps(Hooks.Email,Hooks.Password);
    }


    @When("User choose \"Euro\" as a main currency from static dropdown")
    public void changeCurrencies()
    {
        Hooks.driver.findElement(By.name("customerCurrency")).sendKeys("Euro");
    }

    @Then("The currency in the website should to be changed")
    public void confirmationChange() throws InterruptedException {

        // confirm sign
        HomePage.getPriceText();
        for (int i = 1 ; i<=4 ; i++)
        {
            String number = Integer.toString(i);
            Assert.assertTrue(HomePage.accessHProduct(number).contains("€"),"Sign Confirmed");
        }
        // confirm title
        String actualResult = Hooks.driver.findElement(By.name("customerCurrency")).getText();
        String expectedResult = "Euro";
        Assert.assertTrue(actualResult.contains(expectedResult),"Confirm Title");

    }





}
