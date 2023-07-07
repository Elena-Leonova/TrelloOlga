package applications;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;

public class MyListener implements WebDriverListener {
    Logger logger= LoggerFactory.getLogger(MyListener.class);


    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        WebDriverListener.super.onError(target, method, args, e);
        logger.info("Have a problem");
        logger.info("The name of error --->"+method.getName());
        logger.info("Describe the error--"+e.getCause());
        logger.info(target.toString());

        Random random = new Random();
        int i = random.nextInt(1000)+1000;
        String link = "src/test/resources/screens/screen"+i+".png";
        logger.info("Screen with error ----> "+link);
        WebDriver webDriver = (ChromeDriver)target;
        File tmp = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(tmp,new File(link));
        }catch (IOException exc){
            throw  new RuntimeException(exc);
        }
    }

      @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElement(driver, locator);
        logger.info("Befor find element by --->"+locator);
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        WebDriverListener.super.afterFindElement(driver, locator, result);
        logger.info("After find element by --->"+locator);
    }

    @Override
    public void beforeFindElements(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElements(driver, locator);
        logger.info(" Befor find elements by -->"+locator);
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        WebDriverListener.super.afterFindElements(driver, locator, result);
        logger.info("After find elements by --->"+locator);
         logger.info("List size is ---> "+result.size());
    }
}
