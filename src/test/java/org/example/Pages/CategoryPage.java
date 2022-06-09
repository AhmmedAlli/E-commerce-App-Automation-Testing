package org.example.Pages;

import org.example.StepsCode.Hooks;
import org.openqa.selenium.By;

public class CategoryPage {



    public static By categoryBtn1()
    {
        return  By.cssSelector("div>button[class=\"button-2 product-box-add-to-cart-button\"]");
    }


    public static By categoryBtn2()
    {
        return  By.xpath("(//button[@class=\"button-2 product-box-add-to-cart-button\"])[2]");
    }

    public static String confirmSignProducts()
    {
        return Hooks.driver.findElement(By.xpath("(//span[@class=\"price actual-price\"])[1]")).getText();
    }


}
