package tests;

import applications.DataProviderUser;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(app.getUserHelper().isLogged()){
            app.getUserHelper().LogOut();
            app.getUserHelper().pause(3000);
        }
    }
    @Test(priority = 1)
    public void positiveLoginTest(){
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(new User().withEmail("or220719@gmail.com").withPassword("12345%QWqw"));
        app.getUserHelper().submitLogIn();
        app.getUserHelper().pause(10000);
        Assert.assertTrue(app.getUserHelper().isElementPresent(By.xpath("//span[@class='DweEFaF5owOe02 V_PnoJ2AynVwLp G6CmOLx93OUZez']")));
    }
    @Test (dataProvider ="UserDataProvider",dataProviderClass = DataProviderUser.class,priority = 2)
    public void positiveLoginTestDP(User user){
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(user);
        app.getUserHelper().submitLogIn();
        app.getUserHelper().pause(10000);
        //Assert.assertTrue(app.getUserHelper().isElementPresent(By.xpath("//span[@class='DweEFaF5owOe02 V_PnoJ2AynVwLp G6CmOLx93OUZez']")));
    }
    @Test(priority = 3)
    public void negativePasswordLoginTest(){
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(new User().withEmail("or220719@gmail.com").withPassword("12345%QWq"));
        app.getUserHelper().submitLogIn();
        app.getUserHelper().pause(4000);
        //Assert.assertTrue(app.getUserHelper()
               // .isElementPresent(By.xpath("//span[contains(text(),'Incorrect email address and / or password. If you ')]")));

    }
        @Test(enabled = false)
    public void logOutTest(){
        if(app.getUserHelper().isElementPresent(By.xpath("//span[@class='DweEFaF5owOe02 V_PnoJ2AynVwLp G6CmOLx93OUZez']"))) {
            app.getUserHelper().openAccountForm();
            app.getUserHelper().pause(2000);
            app.getUserHelper().submitLogOut();
            app.getUserHelper().pressOkButton();
            app.getUserHelper().pause(2000);
            Assert.assertTrue(app.getUserHelper().isElementPresent(By.xpath("//a[@class='Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr']")));
        }else{
            app.getUserHelper().openLoginForm();
            app.getUserHelper().fillLoginForm(new User().withEmail("or220719@gmail.com").withPassword("12345%QWqw"));
            app.getUserHelper().submitLogIn();
            app.getUserHelper().pause(10000);
            app.getUserHelper().openAccountForm();
            app.getUserHelper().pause(2000);
            app.getUserHelper().submitLogOut();
            app.getUserHelper().pressOkButton();
            app.getUserHelper().pause(5000);
            //Assert.assertTrue(app.getUserHelper().isElementPresent(By.xpath("//a[@class='Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr']")));
            app.getUserHelper().back();
        }
    }


}
