
package org.example.StepsCode;

import org.example.Pages.CategoryPage;
import org.example.Pages.HomePage;
import org.example.Pages.ShoppingCheckoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class C09_AddToShoppingCart {

    @And("User go to home page to shop any product")
    public void goToHomePage()
    {
        HomePage.goToHomePage();
        HomePage.changeCurrency();
    }

    @When("User add products to cart")
    public void addToCart() throws InterruptedException {
        Hooks.driver.findElement(HomePage.selectCategory1()).click();
        Hooks.driver.findElement(CategoryPage.categoryBtn1()).click();
        Thread.sleep(1000);

        HomePage.goToHomePage();

        Hooks.driver.findElement(HomePage.selectCategory2()).click();
        Hooks.driver.findElement(CategoryPage.categoryBtn2()).click();

        Thread.sleep(3000);

        Hooks.driver.findElement(By.id("add-to-cart-button-35")).click();

        Thread.sleep(3000);
    }

    @Then("User should to find the products in shopping cart")
    public void checkAddProducts()
    {
        ShoppingCheckoutPage.goToCartPage();
        Assert.assertTrue(Hooks.driver.findElement(By.cssSelector("th[class=\"unit-price\"]")).isDisplayed());
    }


}
