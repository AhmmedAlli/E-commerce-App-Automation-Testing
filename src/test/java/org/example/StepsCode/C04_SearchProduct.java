package org.example.StepsCode;


import org.example.Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class C04_SearchProduct {

    @Given("User should to be logged in successfully")
    public void login() throws InterruptedException {
        LoginPage.LoginSteps(Hooks.Email,Hooks.Password);
    }

    @When("^User Write the name of product an Ex:\"(.*)\"$")
    public void enterProductName(String productName)
    {
        Hooks.driver.findElement(By.id("small-searchterms")).sendKeys(productName);
    }

    @And("User clicked to enter button in keyboard")
    public void clickSearchBtn()
    {
        Hooks.driver.findElement(By.cssSelector("form > button[type=\"submit\"]")).click();
    }

    @Then("The wabsite should appear the results related to the product name")
    public void showProductResult()
    {
        SoftAssert soft = new SoftAssert();
        // ASSERT NUMBER #1
        String actualResult = Hooks.driver.getCurrentUrl();
        String expectedResult = "https://demo.nopcommerce.com/search";
        soft.assertTrue(actualResult.contains(expectedResult),"First Assert");
        // ASSERT NUMBER #2
        int size = Hooks.driver.findElements(By.cssSelector("div > [class=\"item-grid\"]")).size();
        soft.assertTrue(size > 0,"Second Assert");

        // ASSERT ALL
        soft.assertAll();

    }




}
