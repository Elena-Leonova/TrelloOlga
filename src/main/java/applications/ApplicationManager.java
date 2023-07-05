package applications;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
        WebDriver wd;
        UserHelper userHelper;
        BoardHelper boardHelper;
        WorkSpaceHelper workSpaceHelper;
        public void init(){
            wd = new ChromeDriver();
            wd.manage().window().maximize();
            wd.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            wd.navigate().to("https://trello.com/home");
            userHelper = new UserHelper(wd);
            boardHelper = new BoardHelper(wd);
            workSpaceHelper = new WorkSpaceHelper(wd);
        }
        public UserHelper getUserHelper() {
            return userHelper;
        }
        public BoardHelper getBoardHelper() {
            return boardHelper;
        }
        public WorkSpaceHelper getWorkSpaceHelper() {
            return workSpaceHelper;
        }

        public void stop(){
        wd.quit();
    }
    }

