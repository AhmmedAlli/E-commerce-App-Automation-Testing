package org.example.Pages;
import org.example.StepsCode.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


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

    // actual results
    public static String actualResult()
    {
        return Hooks.driver.getCurrentUrl();

    }

    public static String expectedResult()
    {
        return "https://demo.nopcommerce.com/";
    }

    // accessing log out button
    public static WebElement logoutBtn()
    {
        return Hooks.driver.findElement(By.cssSelector("li > a[class=\"ico-logout\"]"));
    }

    // changing currency
    public static void changeCurrency()
    {
        Hooks.driver.findElement(By.name("customerCurrency")).sendKeys("Euro");
    }

    public static WebElement sliders(String num)
    {
        return Hooks.driver.findElement(By.xpath("(//a[@href=\"http://demo.nopcommerce.com/\"])["+num+"]"));
    }

    //get product price text
    public static void getPriceText() throws InterruptedException
    {
        Actions action = new Actions(Hooks.driver);
        WebElement products = Hooks.driver.findElement(By.cssSelector("[class=\"product-grid home-page-product-grid\"]"));
        action.moveToElement(products).perform();
        Thread.sleep(1000);
    }

    // access product price sign
    public static String accessHProduct(String num)
    {
        return Hooks.driver.findElement(By.xpath("(//span[@class=\"price actual-price\"])["+num+"]")).getText();
    }


}
