package org.example.StepsCode;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;


import java.util.ArrayList;

public class C13_FollowUs {



    // Scenario #1 User opens FACEBOOK link
    @Given("User go to home page")
    public void goToHomePage()
    {
        HomePage.goToHomePage();
    }

    ArrayList<String> Tabs ;
    @When("User opens facebook link")
    public void userOpensFacebook() throws InterruptedException {

        Thread.sleep(2000);
        Hooks.driver.findElement(By.cssSelector("li[class=\"facebook\"]")).click();
        Tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(Tabs.get(1));

    }

    @Then("^\"(.*)\" facebook page is opened$")
    public void confirmOpenFacebook(String expectedResult) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),expectedResult);

        Thread.sleep(1000);

        Hooks.driver.close();
        Hooks.driver.switchTo().window(Tabs.get(0));
    }




    // Scenario #2 User opens TWITTER link
    @When("User opens twitter link")
    public void openTwitter() throws InterruptedException {

        Thread.sleep(2000);
        Hooks.driver.findElement(By.cssSelector("li[class=\"twitter\"]")).click();
        Tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(Tabs.get(1));
    }



    @Then("^\"(.*)\" twitter page is opened$")
    public void confimOpenTwitter(String expectedResult ) throws InterruptedException {

        Thread.sleep(1000);
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),expectedResult);

        Thread.sleep(1000);

        Hooks.driver.close();
        Hooks.driver.switchTo().window(Tabs.get(0));
    }


    // Scenario #3 User opens RSS link
    @When("User opens rss link")
    public void openRss() throws InterruptedException {
        Thread.sleep(2000);
        Hooks.driver.findElement(By.cssSelector("li[class=\"rss\"]")).click();
        Tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(Tabs.get(1));
    }

    @Then("^\"(.*)\" rss page is opened$")
    public void confirmOpenRss(String expectedResult) throws InterruptedException {

        Thread.sleep(1000);
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),expectedResult);

        Thread.sleep(1000);

        Hooks.driver.close();
        Hooks.driver.switchTo().window(Tabs.get(0));
    }

    // Scenario #4 User opens Youtube link
    @When("User opens youtube link")
    public void openYoutube() throws InterruptedException {
        Thread.sleep(2000);
        Hooks.driver.findElement(By.cssSelector("li[class=\"youtube\"]")).click();
        Tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(Tabs.get(1));
    }

    @Then("^\"(.*)\" youtube page is opend$")
    public void confirmOpenYoutube(String expectedResult) throws InterruptedException {

        Thread.sleep(1000);
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),expectedResult);

        Thread.sleep(1000);

        Hooks.driver.close();
        Hooks.driver.switchTo().window(Tabs.get(0));
    }

}
