package tests;

import applications.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestBase {
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    protected static ApplicationManager app = new ApplicationManager();

    @BeforeMethod(alwaysRun = true)
    public void startLoger(Method method) {
        logger.info("Test start ---" + method.getName());
    }

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        app.init();
    }

    //@AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }

    @AfterMethod(alwaysRun = true)
    public void finishLogger() {
        logger.info("*********************************************************");

    }

}
