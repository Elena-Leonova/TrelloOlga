package applications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class AtlassianHelper extends HelperBase {

    public AtlassianHelper(WebDriver wd) {
        super(wd);
    }

    public void initChangePhoto() {
        Actions actions = new Actions(wd);
        actions.moveToElement(wd.findElement(By.cssSelector(".css-piztqx.e10a6gbx1"))).click().perform();
        pause(1000);//[data-test-selector*='profile-hover-info']
        click(By.xpath("//*[text()='Add profile photo']"));

    }

    public void uploadPhoto(String path) {
        wd.findElement(By.xpath(" //*[text()='Upload a photo']")).sendKeys(path);
        pause(2000);
        click(By.xpath("//*[text()='Upload']"));
        pause(2000);
    }

    public void returnToTheTrello() {
        List<String> tabs = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window(tabs.get(0));
    }
}
