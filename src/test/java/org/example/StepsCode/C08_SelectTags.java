package org.example.StepsCode;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.CategoryPage;
import org.example.Pages.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class C08_SelectTags {


    @When("User select different tags")
    public void selectTag() throws InterruptedException {
        HomePage.changeCurrency();
        Thread.sleep(1000);
        Hooks.driver.findElement(By.cssSelector("li>a[href=\"/awesome\"]")).click();


    }

    @Then("User appear for him results of related items for this tag")
    public void confirmTag()
    {
        Assert.assertTrue(CategoryPage.confirmSignProducts().contains("€"),"Select Tags");
        SoftAssert soft = new SoftAssert();
        String actualResult = Hooks.driver.getCurrentUrl();
        String expectedResult = "https://demo.nopcommerce.com/awesome";

        soft.assertEquals(actualResult,expectedResult);

        soft.assertAll();

    }



}
