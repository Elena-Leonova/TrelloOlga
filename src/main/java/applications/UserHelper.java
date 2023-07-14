package applications;

import models.User;
import models.UserLombok;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UserHelper extends HelperBase{
    public UserHelper(WebDriver wd) {
        super(wd);
    }
    public void openLoginForm() {
        click(By.xpath("//a[@class='Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr']"));
    }

    public void fillLoginForm(User user) {
        type(By.xpath("//input[@id='user']"), user.getEmail());
        click(By.xpath("//input[@id='login']"));
        pause(3000);
        type(By.xpath("//input[@id='password']"), user.getPassword());
    }
    public void fillLoginForm(UserLombok userLombok) {
        type(By.xpath("//input[@id='user']"), userLombok.getEmail());
        click(By.xpath("//input[@id='login']"));
        pause(3000);
        type(By.xpath("//input[@id='password']"), userLombok.getPassword());
    }

    public void submitLogIn() {
        click(By.xpath("//span[text()='Log in']"));
    }

    public void fillEmailFied(User user) {
        type(By.xpath("//input[@id='user']"), user.getEmail());
        click(By.xpath("//input[@id='login']"));

    }

    public void openAccountForm() {
        click(By.xpath("//span[@class='DweEFaF5owOe02 V_PnoJ2AynVwLp G6CmOLx93OUZez']"));
    }

    public void submitLogOut() {
        click(By.xpath("//button[.='Log out']"));
    }

    public void pressOkButton() {
        click(By.xpath("//span[@class='css-178ag6o']"));
    }


    public void boardNameModif() {
        //type(By.xpath("//h1[@data-testid='board-name-display']"),"qa19");
        WebElement el = wd.findElement(By.cssSelector(".hiRkezEUBG7ve6 uXhW3KBBr1jUsJ"));
        pause(3000);
        click(By.cssSelector(".hiRkezEUBG7ve6 uXhW3KBBr1jUsJ"));
        new Actions(wd).moveToElement(el).click(el).sendKeys("name" + Keys.ENTER).build().perform();
    }
    public void login(){
        openLoginForm();
        fillLoginForm(new User().withEmail("or220719@gmail.com").withPassword("12345%QWqw"));
        submitLogIn();
        pause(3000);
    }
    public void back() {
        wd.navigate().back();
    }

    public boolean isLogged() {
        return wd.findElements(By.cssSelector("span[title='Olga (olga48105521)']")).size()>0;
    }

    public void LogOut() {
        click(By.xpath("//span[@class='DweEFaF5owOe02 V_PnoJ2AynVwLp G6CmOLx93OUZez']"));
        pause(2000);
        click(By.xpath("//*[text()='Log out']"));
        click(By.xpath("//*[text()='Log out']"));


    }
}
