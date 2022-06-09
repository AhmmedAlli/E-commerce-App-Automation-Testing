package org.example.StepsCode;


import io.cucumber.java.en.*;
import org.example.Pages.CategoryPage;
import org.example.Pages.HomePage;
import org.example.Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class C04_SearchProduct {

    @Given("User should to be logged in successfully")
    public void login() throws InterruptedException {
        LoginPage.LoginSteps(Hooks.Email,Hooks.Password);
        HomePage.changeCurrency();
    }

    @When("^User Write the name of product an Ex:\"(.*)\"$")
    public void enterProductName(String productName)
    {
        Hooks.driver.findElement(By.id("small-searchterms")).sendKeys(productName);
    }

    @And("User clicked to enter button in keyboard")
    public void clickSearchBtn() throws InterruptedException {
        Hooks.driver.findElement(By.cssSelector("form > button[type=\"submit\"]")).click();
        Thread.sleep(1000);

        Actions action = new Actions(Hooks.driver);
        WebElement productEle = Hooks.driver.findElement(By.cssSelector("[class=\"details\"]"));
        action.moveToElement(productEle).perform();
        Thread.sleep(1000);

    }

    @Then("The website should appear the results related to the product name")
    public void showProductResult() throws InterruptedException {


        //Assert Actual Currency
        Assert.assertTrue(CategoryPage.confirmSignProducts().contains("€"),"Search");

        SoftAssert soft = new SoftAssert();
        // ASSERT NUMBER #1
        String actualResult = Hooks.driver.getCurrentUrl();
        String expectedResult = "https://demo.nopcommerce.com/search";
        soft.assertTrue(actualResult.contains(expectedResult),"First Assert");
        // ASSERT NUMBER #2
        int size = Hooks.driver.findElements(By.cssSelector("div > [class=\"item-grid\"]")).size();
        soft.assertTrue(size > 0,"Second Assert");

        // ASSERT NUMBER #3
        soft.assertTrue(Hooks.driver.findElement(By.xpath("//button[@class=\"button-2 product-box-add-to-cart-button\"]")).isDisplayed());

        // ASSERT ALL
        soft.assertAll();

    }


    @When("^User Write the step code of product an Ex:\"(.*)\"$")
    public void searchStepCode(String stepCode) throws InterruptedException {
        Hooks.driver.findElement(By.id("small-searchterms")).sendKeys(stepCode);
        Thread.sleep(1000);
    }



}
