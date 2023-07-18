package applications;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    WebDriver wd;
    UserHelper userHelper;
    BoardHelper boardHelper;
    WorkSpaceHelper workSpaceHelper;
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equals(Browser.CHROME.browserName())) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            wd = new ChromeDriver(options);
            logger.info("Test run in Chrome browser");
        } else if (browser.equals(Browser.EDGE.browserName())) {
            wd=new EdgeDriver();
            logger.info("Test run in Edge browser");
        }

        WebDriverListener listener = new MyListener();
        wd = new EventFiringDecorator<>(listener).decorate(wd);

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

    public void stop() {
        wd.quit();
    }
}

