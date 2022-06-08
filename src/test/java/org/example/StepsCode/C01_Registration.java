package org.example.StepsCode;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class C01_Registration {



        @Given("User should have an email to register")
        public void createEmail() throws InterruptedException {
                Hooks.driver.navigate().to("https://tempmail.dev/ar");
                Thread.sleep(2000);
                Hooks.Email = Hooks.driver.findElement(By.id("current-mail")).getText();
                Thread.sleep(1000);
        }

        @And("User navigate to register page")

        public void navigateToRegisterPage() {
          Hooks.driver.navigate().to("https://demo.nopcommerce.com/register?returnUrl=%2F");
        }


        @When("User enter valid data")
        public void enterValidData() throws InterruptedException{
                Hooks.driver.findElement(By.cssSelector("span > input[type=\"radio\"]")).click();
                Hooks.driver.findElement(By.id("FirstName")).sendKeys("Ahmed");
                Hooks.driver.findElement(By.id("LastName")).sendKeys("Ali");
                // choose day
                Hooks.driver.findElement(By.cssSelector("select[name=\"DateOfBirthDay\"]>option[value=\"3\"]")).click();
                // choose month
                Hooks.driver.findElement(By.cssSelector("select[name=\"DateOfBirthMonth\"]>option[value=\"2\"]")).click();
                // choose year
                Hooks.driver.findElement(By.cssSelector("select[name=\"DateOfBirthYear\"]>option[value=\"2003\"]")).click();
                // set email
                Hooks.driver.findElement(By.id("Email")).sendKeys(Hooks.Email);
                Hooks.driver.findElement(By.id("Company")).sendKeys("Apple");

                // set password
                Hooks.driver.findElement(By.id("Password")).sendKeys(Hooks.Password);
                Hooks.driver.findElement(By.id("ConfirmPassword")).sendKeys(Hooks.Password);

                Hooks.driver.findElement(By.name("register-button")).click();
                Thread.sleep(500);
        }


        @Then("User could be register successfully")
        public void User_register_Successfully()
        {

                // #1 ACTUAL AND EXPECTED RESULT OF FIRST SOT ASSERT
                String actualResult = Hooks.driver.findElement(By.cssSelector("div[class=\"result\"]")).getText();
                String expectedResult = "Your registration completed";

                // CREATE NEW OBJECT OF SOFT ASSERT TO USE
                SoftAssert soft = new SoftAssert();

                // FIRST SOFT ASSERT TO CONFIRM THE SUCCESSFUL MESSAGE
                soft.assertTrue(actualResult.contains(expectedResult),"confirm the write message");

                // #2 ACTUAL AND EXPECTED RESULT OF FIRST SOT ASSERT
                String actualColor = Hooks.driver.findElement(By.cssSelector("div[class=\"result\"]")).getCssValue("color");
                String expectedColor = "rgba(76, 177, 124, 1)";

                // SECOND SOFT ASSERT TO CONFIRM THE COLOR OF MESSAGE
                soft.assertTrue(actualColor.contains(expectedColor));
                // ASSERT ALL
                soft.assertAll();
                // CLICK TO CONTINUE BUTTON TO HOMEPAGE
                Hooks.driver.findElement(By.cssSelector("div > a[class=\"button-1 register-continue-button\"]")).click();

        }







}
