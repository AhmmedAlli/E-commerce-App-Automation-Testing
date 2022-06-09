package org.example.StepsCode;

import org.example.Pages.CategoryPage;
import org.example.Pages.HomePage;
import org.example.Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C10_AddToWishList {

    @Given("User logged in successfully")
    public void login() throws InterruptedException {
        LoginPage.LoginSteps(Hooks.Email,Hooks.Password);
        HomePage.changeCurrency();
    }

    @When("User select different products to wishlist")
    public void selectProduct() throws InterruptedException {
        Thread.sleep(1000);


        WebElement category = Hooks.driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/apparel\"]"));
        WebElement subCategory = Hooks.driver.findElement(By.cssSelector("[class=\"top-menu notmobile\"]>li> ul > li > a[href=\"/shoes\"]"));
        Actions action= new Actions(Hooks.driver);
        action.moveToElement(category).perform();
        subCategory.click();

        Thread.sleep(1000);

        Hooks.driver.findElement(By.cssSelector("[data-productid=\"25\"]> div > div > div > [class=\"button-2 product-box-add-to-cart-button\"]")).click();
        Thread.sleep(1000);
        Hooks.driver.findElement(By.cssSelector("[name=\"product_attribute_9\"] option[value=\"21\"]")).click();
        Hooks.driver.findElement(By.cssSelector("[id=\"add-to-wishlist-button-25\"]")).click();

        Thread.sleep(1000);

        HomePage.goToHomePage();

        Hooks.driver.findElement(HomePage.selectCategory1()).click();
        Thread.sleep(2000);
        Hooks.driver.findElement(By.cssSelector("button[title=\"Add to wishlist\"]")).click();
        Thread.sleep(1000);
    }


    @Then("User show green message for successful add products to wishlist")
    public void confirmMessage() throws InterruptedException
    {
        // Assert #1
        Assert.assertTrue("Wish",CategoryPage.confirmSignProducts().contains("€"));

        Thread.sleep(1000);
        // Assert #2
        String actualResult = Hooks.driver.findElement(By.cssSelector("p[class=\"content\"]")).getText();
        String expectedResult = "The product has been added to your wishlist";
        Assert.assertEquals(actualResult,expectedResult);

        // Assert #3
        String actualColor = Hooks.driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]")).getCssValue("background-color");
        String expectedColor = "rgba(75, 176, 122, 1)";
        System.out.println(actualColor);
        Assert.assertTrue(actualColor.contains(expectedColor));
        Thread.sleep(1000);
    }

    @And("User open wishlist page and find the items has been selected")
    public void checkPage() throws InterruptedException
    {
        Hooks.driver.navigate().to("https://demo.nopcommerce.com/wishlist");
        Thread.sleep(1000);
        Assert.assertTrue(Hooks.driver.findElement(By.cssSelector("th[class=\"unit-price\"]")).isDisplayed());

    }

}
