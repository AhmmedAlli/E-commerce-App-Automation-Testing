package org.example.StepsCode;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class C15_ProductHomePage {


    @When("User scroll down into home page")
    public void scrollDown() throws InterruptedException {
        Actions action = new Actions(Hooks.driver);
        WebElement products = Hooks.driver.findElement(By.cssSelector("[class=\"product-grid home-page-product-grid\"]"));
        action.moveToElement(products).perform();
        Thread.sleep(1000);
    }

    @Then("User find the products in home page")
    public void confirmProducts()
    {
        Assert.assertTrue(Hooks.driver.findElement(By.cssSelector("div[data-productid=\"1\"]")).isDisplayed());
        Assert.assertTrue(Hooks.driver.findElement(By.cssSelector("div[data-productid=\"4\"]")).isDisplayed());
        Assert.assertTrue(Hooks.driver.findElement(By.cssSelector("div[data-productid=\"18\"]")).isDisplayed());
        Assert.assertTrue(Hooks.driver.findElement(By.cssSelector("div[data-productid=\"43\"]")).isDisplayed());
    }

}
