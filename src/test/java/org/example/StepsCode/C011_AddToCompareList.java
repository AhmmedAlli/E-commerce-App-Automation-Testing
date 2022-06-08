package org.example.StepsCode;

import org.example.Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class C011_AddToCompareList {


    @When("User try to compare multiple products")
    public void compareProducts() throws InterruptedException
    {
        Hooks.driver.findElement(HomePage.selectCategory2()).click();
        Thread.sleep(1000);

        Hooks.driver.findElement(By.cssSelector("button[title=\"Add to compare list\"]")).click();
        Thread.sleep(2000);

        HomePage.goToHomePage();

        Hooks.driver.findElement(By.cssSelector("a[href=\"/electronics\"]")).click();
        Hooks.driver.findElement(By.cssSelector("img[alt=\"Picture for category Cell phones\"]")).click();
        Thread.sleep(2000);

        Hooks.driver.findElement(By.cssSelector("button[title=\"Add to compare list\"]")).click();
        Thread.sleep(2000);

    }

    SoftAssert soft = new SoftAssert();

    @Then("Successful message for add products to compare list")
    public void confirmComparison() throws InterruptedException
    {
        Thread.sleep(1000);
        String actualResult = Hooks.driver.findElement(By.cssSelector("[class=\"content\"]")).getText();
        String expectedResult = "The product has been added to your product comparison";

        // ASSERT NUMBER #1
        soft.assertTrue(actualResult.contains(expectedResult),"FIRST ASSERT");
        // ASSERT ALL
        soft.assertAll();
    }


    @And("Products should to be find into compare list page")
    public void confirmPage() throws InterruptedException
    {
        Hooks.driver.navigate().to("https://demo.nopcommerce.com/compareproducts");
        Thread.sleep(1000);
        soft.assertTrue(Hooks.driver.findElement(By.cssSelector("tr[class=\"product-name\"]")).isDisplayed(),"Third ASSERT");
        soft.assertAll();
    }

}
