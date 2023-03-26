package org.example.Pages;

import org.example.StepsCode.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShoppingCheckoutPage {

    // navigate to cart page
    public static void goToCartPage()
    {
         Hooks.driver.navigate().to("https://demo.nopcommerce.com/cart");
    }

    // accessing address country textbox
    public static WebElement addressCountryId()
    {
        return Hooks.driver.findElement(By.name("BillingNewAddress.CountryId"));
        
    }
    
    
    
    
}
