package org.example.StepsCode;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    // DRIVER
    public static WebDriver driver = null ;

    // DATA USED
    static String Email ;
    static String Password = "Password10@" ;


    @Before
    public void openBrowser()  {
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(path);
        System.setProperty("webdriver.chrome.driver",path);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }



    @After

    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }



}
