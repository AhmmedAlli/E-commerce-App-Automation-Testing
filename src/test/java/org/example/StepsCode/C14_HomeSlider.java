package org.example.StepsCode;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.HomePage;
import org.junit.Assert;

public class C14_HomeSlider {

    // First Scenario
    @When("User click to first slider")
    public void clickToFHomeSlider() throws InterruptedException {
        Thread.sleep(1000);
        HomePage.sliders("1").click();
    }

    @Then("Relative product for first slider is displayed")
    public void confirmShowOne() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals("https://demo.nopcommerce.com/nokia-lumia-1020",Hooks.driver.getCurrentUrl());
    }


    // Second Scenario
    @When("User click to second slider")
    public void clickToSHomeSlider() throws InterruptedException {
        Thread.sleep(1000);
        HomePage.sliders("2").click();
    }

    @Then("Relative product for second slider is displayed")
    public void confirmShowTwo() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals("https://demo.nopcommerce.com/iphone-6",Hooks.driver.getCurrentUrl());
    }

}
