package org.example.Pages;

import org.example.StepsCode.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

        WebDriver driver = null ;

        // CONSTRUCTOR TO ASSIGN THE MAIN DRIVER TO THIS CLASS

        public LoginPage(WebDriver driver)
        {
                this.driver = driver;
        }

        // ACCESS EMAIL FIELD

        public static WebElement emailField()
        {
                return Hooks.driver.findElement(By.id("Email"));
        }

        // ACCESS PASSWORD FIELD

        public static WebElement passwordField ()
        {
                return Hooks.driver.findElement(By.id("Password"));
        }

        // CLICK TO LOGIN BUTTON

        public static WebElement loginBtn()
        {
                return Hooks.driver.findElement(By.cssSelector("div > button[class=\"button-1 login-button\"]"));
        }

        // NAVIGATE TO LOGIN PAGE
        public static void goToLoginPage()
        {
                Hooks.driver.navigate().to("https://demo.nopcommerce.com/login");
        }


        public static void LoginSteps(String Email , String password) throws InterruptedException {

        // GO TO LOGIN PAGE
        goToLoginPage();

        // ENTER EMAIL
        emailField().sendKeys(Email);

        // ENTER PASSWORD
        passwordField().sendKeys(password);

        // CLICK TO LOGIN BUTTON
        loginBtn().click();

        Thread.sleep(1000);

        }


}
