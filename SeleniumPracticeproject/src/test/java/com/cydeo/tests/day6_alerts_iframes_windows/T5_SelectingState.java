package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_SelectingState {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        //1. Open Chrome browser

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");


    }

    @Test
    public void selectIllinois() throws InterruptedException {

        //3. Select Illinois
        //Select selectIllinois=new Select(driver.findElement(By.xpath("//select[@id='state']")));
        Select selectState = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        selectState.selectByVisibleText("Illinois");

        Thread.sleep(1000);

        //4. Select Virginia
        //Select selectVirginia=new Select(driver.findElement(By.xpath("//select[@id='state']")));
        selectState.selectByValue("VA");

        Thread.sleep(1000);

        //5. Select California
        selectState.selectByIndex(5);

        //6. Verify final selected option is California.
        WebElement lastStateSelection = selectState.getFirstSelectedOption();

        String expectedFinalSelection = "California";
        String actualFinalSelection = lastStateSelection.getText();

        // Use all Select options. (visible text, value, index)
        //Select stateDropdown=new Select(driver.findElement(By.xpath("//select[@id='state']")));
        Assert.assertEquals(actualFinalSelection, expectedFinalSelection);
        System.out.println("lastStateSelection = " + lastStateSelection.getText());


    }

}




