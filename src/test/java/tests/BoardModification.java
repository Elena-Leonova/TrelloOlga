package tests;

import models.Board;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardModification extends TestBase{
    @BeforeMethod
    public void preConditions(){
        if(!app.getUserHelper().isElementPresent(By.xpath("//span[@class='DweEFaF5owOe02 V_PnoJ2AynVwLp G6CmOLx93OUZez']"))){
            app.getUserHelper().login();
        }
    }
   @Test
    public void boardNameModificationTest(){
        app.getBoardHelper().pressFirstBoardSpot();
        String name = "qa19_" + (System.currentTimeMillis()/2000)%3600;
        app.getBoardHelper().boardNameModification(new Board().withName(name));

    }
}
