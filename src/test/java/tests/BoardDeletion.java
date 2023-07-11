package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletion extends TestBase{
    @BeforeMethod
    public void preConditions() {
        if (!app.getUserHelper().isElementPresent(By.xpath("//span[@class='DweEFaF5owOe02 V_PnoJ2AynVwLp G6CmOLx93OUZez']"))) {
            app.getUserHelper().login();
        }
    }
    @Test
    public void deletionBoardTest(){
        while (app.getBoardHelper().boardCounter() > 1) {
            app.getBoardHelper().selectFirstBoard();
            app.getBoardHelper().pause(3000);
            app.getBoardHelper().openMenu1();
            app.getBoardHelper().pause(3000);
            app.getBoardHelper().openMenuMore();
            app.getBoardHelper().pause(3000);
            app.getBoardHelper().closeBoard();
            app.getBoardHelper().pause(2000);

        }
    }




    }

