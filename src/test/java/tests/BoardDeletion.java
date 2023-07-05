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
    public void boardDeletionTest() {
        if (app.getBoardHelper().NumberBoards() >= 2) {
            while (app.getBoardHelper().NumberBoards()>2) {
                int before = app.getBoardHelper().NumberBoards();
                app.getBoardHelper().pressFirstBoardSpot();
                app.getBoardHelper().pause(2000);
                app.getBoardHelper().boardDeletionPath();
                app.getBoardHelper().pause(2000);
                int after = app.getBoardHelper().NumberBoards();
                app.getBoardHelper().pause(5000);
                //Assert.assertEquals(before, after + 1);
            }
            System.out.println("there are not already any boards for deletion");
        }
//        app.getBoardHelper().pressFirstBoardSpot();
//        int i = app.getBoardHelper().boardsNumber();
//        for (i = 0; i < app.getBoardHelper().boardsNumber(); i++) {
//
//            int before = app.getBoardHelper().getBoardsNumber();
//            app.getBoardHelper().pause(2000);
//            //app.getBoardHelper().pressFirstBoardSpot();
//            app.getBoardHelper().boardDeletionPath();
//            app.getBoardHelper().pause(2000);
//            int after = app.getBoardHelper().NumberBoards();
//            app.getBoardHelper().pause(5000);
//            Assert.assertEquals(before, after + 1);
//            if (app.getBoardHelper().NumberBoards() == 1) {
//
//            }

//        }

//        @Test
//        public void boardDeletionTest () {
//            app.getBoardHelper().openMenu();
//            app.getUserHelper().pause(2000);
//            app.getBoardHelper().pressMore();
//            app.getUserHelper().pause(2000);
//            app.getBoardHelper().pressCloseBoard();
//            app.getUserHelper().pause(2000);
//            app.getBoardHelper().submitCloseButton();
//            app.getUserHelper().pause(2000);
//            app.getBoardHelper().pressPermanentlyDelete();
//            app.getUserHelper().pause(2000);
//            app.getBoardHelper().pressDeleteButton();

    }
}
