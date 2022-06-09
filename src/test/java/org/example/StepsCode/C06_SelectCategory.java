package org.example.StepsCode;

import org.example.Pages.CategoryPage;
import org.example.Pages.HomePage;
import org.example.Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C06_SelectCategory {

    String subCategoryName;

    @Given("User go to website to logged in")
    public void loginWebsite() throws InterruptedException
    {
        LoginPage.LoginSteps(Hooks.Email,Hooks.Password);
        HomePage.changeCurrency();
    }

    @When("User select any category")
        public void userSelectCategory() throws InterruptedException {

        Actions action = new Actions(Hooks.driver);
        // hover on "Computers"
        Thread.sleep(1000);
        WebElement computers = Hooks.driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/computers\"]"));
        action.moveToElement(computers).perform();
        Thread.sleep(1000);

        // getText() of subCategory before click on it

        WebElement desktops = Hooks.driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/desktops\"]"));
        subCategoryName = desktops.getText().toLowerCase().trim();		// this will change "Desktops " to "desktops"
        System.out.println(subCategoryName);

        // click on "Desktops
        Thread.sleep(1000);
        desktops.click();

    }

    @Then("The website should to appear the products that related to the category selected")
    public void confirmSelectCategory()
    {
        //Actual Sign

        Assert.assertTrue("Select Category",CategoryPage.confirmSignProducts().contains("€"));

        String actualResult = Hooks.driver.findElement(By.cssSelector("div[class=\"page-title\"]")).getText().toLowerCase();
        String expectedResult = subCategoryName;

        Assert.assertEquals(actualResult,expectedResult);

    }

}
