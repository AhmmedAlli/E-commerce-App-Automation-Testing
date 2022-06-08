package org.example.Pages;

import org.example.StepsCode.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage
{
    WebDriver driver = null ;
     public HomePage(WebDriver driver)
     {
         this.driver = driver;
     }

    public static void goToHomePage()
    {

        Hooks.driver.navigate().to("https://demo.nopcommerce.com/");

    }

    public static By selectCategory1()
    {
        return By.cssSelector("a[href=\"/books\"]");
    }

    public static By selectCategory2()
    {
        return By.cssSelector("li>a[href=\"/digital-downloads\"]");
    }



    public static String actualResult()
    {
        return Hooks.driver.getCurrentUrl();

    }

    public static   String expectedResult()
    {
        return "https://demo.nopcommerce.com/";
    }

    public static WebElement logoutBtn()
    {
        return Hooks.driver.findElement(By.cssSelector("li > a[class=\"ico-logout\"]"));
    }
}
