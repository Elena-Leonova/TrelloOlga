package applications;

import models.WorkSpace;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WorkSpaceHelper extends HelperBase{
    public WorkSpaceHelper(WebDriver wd) {
        super(wd);
    }
    public void pressPlusButton() {
        click(By.cssSelector(".vLNnCqZ9t8iYVd"));
        pause(2000);
    }

    public void fillWorkSpaceForm(WorkSpace workSpace) {
        type(By.cssSelector(".M2RUTkUiGCr5N6"),workSpace.getName());
        click(By.cssSelector(".qvInLZWY0_P5sA"));
        pause(2000);
        click(By.xpath("//div[@data-testid='header-create-team-type-input-education']"));
        pause(4000);
        WebElement el = wd.findElement(By.cssSelector(".NP_F6C6lV9jnfd"));
        new Actions(wd).moveToElement(el).click(el).sendKeys("qa19_workspase").perform();
        pause(2000);
        click(By.cssSelector("[class^='SqloYNfCeOb7nw ']"));
        pause(2000);
        click(By.xpath("//a[@class='SmUK3GIaGHe3l5']"));
        pause(3000);
    }

    public String getTitle() {
        return wd.findElement(By.xpath("//h2[@class='SiP6d2d_8FAAkC']")).getText();
    }
}
