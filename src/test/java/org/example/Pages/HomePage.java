package org.example.Pages;

import org.example.StepsCode.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

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

    public static String expectedResult()
    {
        return "https://demo.nopcommerce.com/";
    }

    public static WebElement logoutBtn()
    {
        return Hooks.driver.findElement(By.cssSelector("li > a[class=\"ico-logout\"]"));
    }

    public static void changeCurrency()
    {
        Hooks.driver.findElement(By.name("customerCurrency")).sendKeys("Euro");
    }

    public static WebElement sliders(String num)
    {
        return Hooks.driver.findElement(By.xpath("(//a[@href=\"http://demo.nopcommerce.com/\"])["+num+"]"));
    }

    public static void confirmPhCurrency()
    {
        String confirmSignP1 = accessHProduct("1");
        Assert.assertTrue(confirmSignP1.contains("€"),"Confirm Sign");

        String confirmSignP2 = accessHProduct("2");
        Assert.assertTrue(confirmSignP2.contains("€"),"Confirm Sign");

        String confirmSignP3 = accessHProduct("3");
        Assert.assertTrue(confirmSignP3.contains("€"),"Confirm Sign");

        String confirmSignP4 = accessHProduct("4");
        Assert.assertTrue(confirmSignP4.contains("€"),"Confirm Sign");
    }

    public static void getPriceText() throws InterruptedException
    {
        Actions action = new Actions(Hooks.driver);
        WebElement products = Hooks.driver.findElement(By.cssSelector("[class=\"product-grid home-page-product-grid\"]"));
        action.moveToElement(products).perform();
        Thread.sleep(1000);

    }


    public static String accessHProduct(String num)
    {
        return Hooks.driver.findElement(By.xpath("(//span[@class=\"price actual-price\"])["+num+"]")).getText();
    }


}
