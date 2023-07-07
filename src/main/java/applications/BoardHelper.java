package applications;

import models.Board;
import models.BoardLombok;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class BoardHelper extends HelperBase{
    public BoardHelper(WebDriver wd) {
        super(wd);
    }
    public void pressCreateButton() {
        click(By.xpath("//span[text()='Create new board']"));
    }

    public void fillBoardForm(Board board) {
        type(By.xpath("//input[@data-testid='create-board-title-input']"), board.getName());
    }
    public void fillBoardForm(BoardLombok boardLombok) {
        type(By.xpath("//input[@data-testid='create-board-title-input']"), boardLombok.getName());
    }
    public void submitCreate() {
        click(By.xpath("//button[@data-testid='create-board-submit-button']"));
    }
    public void pressBoard() {
        click(By.xpath("//p[@class='nNvJhnERHVQb9o']"));
    }

    //    public int counterBoards(){
//        List<WebElement> boardList = wd.findElements(By.cssSelector(".boards-page-board-section-list-item"));
//        return boardList.size();}
    public int counterBoards(By locator) {
        List<WebElement> boardList = wd.findElements(locator);
        return boardList.size();
    }
    public String getTitle() {
        return wd.findElement(By.xpath("//h1[@class='HKTtBLwDyErB_o']")).getText();
    }
    public void createBoard() {
        click(By.xpath("//div[@class='board-tile mod-add']"));
        pause(2000);
        type(By.xpath("//input[@data-testid='create-board-title-input']"), "hhh");
        pause(2000);
        click(By.xpath("//button[@data-testid='create-board-submit-button']"));
    }
    public boolean isThereAboard() {
        return isElementPresent(By.xpath("//ul[@class='boards-page-board-section-list']//li[1]"));
    }

    public void selectFirstBoard() {
        click(By.xpath("//ul[@class='boards-page-board-section-list']//li[1]"));
    }

    public int NumberBoards() {
        return counterBoards(By.cssSelector(".boards-page-board-section-list-item"));
    }

    public int boardsNumber() {
        return counterBoards(By.cssSelector(".mlpxvZU4v4cMQN qUkRGnTnJDff85"));
    }

    public void boardDeletionPath() {
        pause(2000);
        WebElement el = wd.findElement(By.xpath("//li[@class='mlpxvZU4v4cMQN wVRQcl7CJz79Tr qUkRGnTnJDff85']//div[@role='menu']//span[@class='css-snhnyn']"));
        pause(2000);
        new Actions(wd).moveToElement(el).clickAndHold().click(el).build().perform();
        pause(2000);
        click(By.xpath("//button[@title='Close board']"));
        pause(2000);
        click(By.xpath("//button[@title='Close']"));
        pause(2000);
        click(By.cssSelector("[class^='Bp80TGmc9hQIdE ']"));
        pause(2000);
        click(By.cssSelector("[class^='a72r81xglmtLCW']"));
    }
    //public boolean waitForElementPresent(By locator, int timeOut) {return new WebDriverWait(wd, timeOut)
       //     .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator)).size()>0; }

       public void pressFirstBoardSpot() {

        click(By.xpath("//ul[@class='boards-page-board-section-list']//li[1]"));
    }

    public int getBoardsNumber() {
        return counterBoards(By.xpath("//li[@class='mlpxvZU4v4cMQN qUkRGnTnJDff85']"));
    }

    public void boardNameModification(Board board) {
        for (int i = 1; i < NumberBoards(); i++) {
            String xp = "//ul[@class='boards-page-board-section-list']//li[" + i + "]";
            click(By.xpath(xp));
           // waitForElementPresent(By.cssSelector(".hiRkezEUBG7ve6.uXhW3KBBr1jUsJ"), 10);
            WebElement el = wd.findElement(By.cssSelector(".hiRkezEUBG7ve6.uXhW3KBBr1jUsJ"));
            new Actions(wd).moveToElement(el).click(el).sendKeys(board.getName() + Keys.ENTER).perform();
            String title = wd.findElement(By.cssSelector(".hiRkezEUBG7ve6.uXhW3KBBr1jUsJ")).getText();
            Assert.assertEquals(board.getName(), title);
            click(By.cssSelector(".nNvJhnERHVQb9o"));
            pause(2000);
        }
    }

}

