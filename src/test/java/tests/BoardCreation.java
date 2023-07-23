package tests;

import applications.MyDataProvider;
import models.Board;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreation extends TestBase {
    @BeforeMethod
    public void preConditions() {
        if (!app.getUserHelper().isElementPresent(By.xpath("//span[@class='DweEFaF5owOe02 V_PnoJ2AynVwLp G6CmOLx93OUZez']"))) {
            app.getUserHelper().login();
        }
    }

    @Test
    public void boardCreationTest() {
        while (app.getBoardHelper().NumberBoards() < 3) {
            String boardName = "qa19_" + (System.currentTimeMillis() / 1700) % 3600;
            app.getUserHelper().pause(1000);
            //  int before = app.getBoardHelper().NumberBoards();
            app.getBoardHelper().pressCreateButton();
            app.getUserHelper().pause(3000);
            app.getBoardHelper().fillBoardForm(new Board().withName(boardName));
            app.getBoardHelper().submitCreate();
            app.getUserHelper().pause(3000);
            app.getBoardHelper().pressBoard();
            app.getUserHelper().pause(2000);
            int after = app.getBoardHelper().NumberBoards();
            app.getUserHelper().pause(3000);
            Assert.assertTrue(app.getUserHelper().isLogged());
            app.getUserHelper().pause(3000);
        }
    }

    @Test(dataProvider = "boardMoodelClassicData", dataProviderClass = MyDataProvider.class)
    public void boardCreationTest1(Board board) {
        app.getBoardHelper().pressCreateButton();
        app.getUserHelper().pause(3000);
        app.getBoardHelper().fillBoardForm(board);
        app.getBoardHelper().submitCreate();
        app.getUserHelper().pause(3000);
        app.getBoardHelper().pressBoard();
        app.getUserHelper().pause(2000);
        int after = app.getBoardHelper().NumberBoards();
        app.getUserHelper().pause(3000);
        Assert.assertTrue(app.getUserHelper().isLogged());
        app.getUserHelper().pause(3000);

    }

    }





