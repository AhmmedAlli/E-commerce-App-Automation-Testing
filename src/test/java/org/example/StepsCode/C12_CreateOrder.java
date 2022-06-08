package org.example.StepsCode;

import org.example.Pages.HomePage;
import org.example.Pages.ShoppingCheckoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

public class C12_CreateOrder {


    @And("User fill her data for make the order")
    public void fillData() throws InterruptedException
    {
        HomePage.changeCurrency();
        Thread.sleep(2000);
        // make an order
        Hooks.driver.navigate().to("https://demo.nopcommerce.com/cart");
        Thread.sleep(2000);
        Hooks.driver.findElement(By.id("termsofservice")).click();
        Hooks.driver.findElement(By.id("checkout")).click();

        Thread.sleep(2000);

        ShoppingCheckoutPage.addressCountryId().click();
        ShoppingCheckoutPage.addressCountryId().sendKeys("Egypt");
        ShoppingCheckoutPage.addressCountryId().click();

        Hooks.driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Beni-Suef");
        Hooks.driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("Salah Salem Street");
        Hooks.driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("62511");
        Hooks.driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("01023430105");
        Hooks.driver.findElement(By.id("BillingNewAddress_FaxNumber")).sendKeys("51246");

        Thread.sleep(2000);
        Hooks.driver.findElement(By.name("save")).click();
        Thread.sleep(2000);

        Hooks.driver.findElement(By.cssSelector("div>button[class=\"button-1 shipping-method-next-step-button\"]")).click();
        Thread.sleep(2000);

        Hooks.driver.findElement(By.cssSelector("div>button[class=\"button-1 payment-method-next-step-button\"]")).click();
        Thread.sleep(3000);

        Hooks.driver.findElement(By.cssSelector("div>button[class=\"button-1 payment-info-next-step-button\"]")).click();
        Thread.sleep(2000);

        Hooks.driver.findElement(By.cssSelector("div>button[class=\"button-1 confirm-order-next-step-button\"]")).click();
        Thread.sleep(1000);

    }

    @Then("Order should created successfully")
    public void confirmOrder()
    {

        String actualResult = Hooks.driver.findElement(By.cssSelector("[class=\"section order-completed\"] div[class=\"title\"]")).getText();
        Assert.assertEquals(actualResult,"Your order has been successfully processed!");

    }


}
