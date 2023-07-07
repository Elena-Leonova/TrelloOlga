package tests;

import models.User;
import models.UserLombok;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginLombok extends TestBase {
    @Test
    public void positiveLoginTest() {
        UserLombok userLombok = UserLombok.builder().email("or220719@gmail.com").password("12345%QWqw").build();
        logger.info("Test login posit1----" + userLombok.getEmail() + "" + userLombok.getPassword());
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(userLombok);
        app.getUserHelper().submitLogIn();
        app.getUserHelper().pause(10000);
        //Assert.assertTrue(app.getUserHelper().isElementPresent(By.xpath("//span[@class='DweEFaF5owOe02 V_PnoJ2AynVwLp G6CmOLx93OUZez']")));
        logger.info("Logged---");
    }

    @Test
    public void negativeEmailLoginTest() {
        UserLombok userLombok = UserLombok.builder().email("or220719gmail.com").password("12345%QWqw").build();
        logger.info("Test negative --->with wrong Email -> "+userLombok.getEmail()+ " with Password ->"+ userLombok.getPassword());
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(userLombok);
        app.getUserHelper().click(By.id("login"));
        logger.info("Test failed--");

        //Assert.assertTrue(app.getSessionHelper().isElementPresent(By.xpath("//div[@id='error']//p[@class='error-message']")));
    }
}


