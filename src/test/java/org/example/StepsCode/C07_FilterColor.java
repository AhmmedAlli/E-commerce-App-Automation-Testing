package org.example.StepsCode;

import org.example.Pages.HomePage;
import org.example.Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class C07_FilterColor {

    @Given("User logged in into website")
    public void login() throws InterruptedException {
        LoginPage.LoginSteps(Hooks.Email,Hooks.Password);
        HomePage.changeCurrency();
    }

    @And("User should to select an item to filter")
    public void selectProduct() throws InterruptedException {
        Thread.sleep(1000);
        Actions action = new Actions(Hooks.driver);
        WebElement apparel = Hooks.driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/apparel\"]"));
        action.moveToElement(apparel).perform();
        WebElement shoes = Hooks.driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/shoes\"]"));
        shoes.click();
    }


    @When("User filter items by color option")
    public void chooseColor() throws InterruptedException {
        Thread.sleep(2000);
        Hooks.driver.findElement(By.id("attribute-option-15")).click();
    }

    @Then("User appear for him the filter items with color he choosed")
    public void confirmFilter()
    {
        boolean enableBtn = Hooks.driver.findElement(By.id("attribute-option-15")).isEnabled();
        Assert.assertTrue(enableBtn,"Assert Button");
    }


}
