package org.SG.SeleniumViaJenkins;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium01 {
    @Test
    @Description("Xpath")
    public void testVWOLogin1() throws InterruptedException {

        WebDriver driver = new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com");

        // <a id="btn-make-appointment"
        // href="./profile.php#login"
        // class="btn btn-dark btn-lg">Make Appointment</a>
//
        WebElement btnElement_Id = driver.findElement(By.id("btn-make-appointment"));
//        WebElement btnElement_CN = driver.findElement(By.className("btn btn-dark btn-lg"));
//        WebElement btnElement_PT= driver.findElement(By.partialLinkText("Make"));
//        WebElement btnElement_LT= driver.findElement(By.linkText("Make Appointment"));
//        WebElement btnElement_AT = driver.findElement(By.xpath("a[@href='./profile.php#login']"));
        btnElement_Id.click();
        Thread.sleep(3000);

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/profile.php#login");

        List<WebElement> username_element = driver.findElements(By.xpath("//input[(@placeholder='Username')]"));
        username_element.get(1).sendKeys("John Doe");

        WebElement password_element = driver.findElement(By.xpath("//input[contains(@id,'txt-pass')]"));
        password_element.sendKeys("ThisIsNotAPassword");

        driver.findElement(By.id("btn-login")).click();

        driver.quit();

    }

}
