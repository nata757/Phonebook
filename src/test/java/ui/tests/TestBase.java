package ui.tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

public class TestBase {
    protected WebDriver driver;
    protected final String EMAIL = "test@gmail.com";
    protected final String PASSWORD = "test@gmail.com";
    String screenName = "screen_" + System.currentTimeMillis() + ".png";

    protected Logger logger = LoggerFactory.getLogger(TestBase.class);
    @BeforeMethod
    public void setUp(Method m) {
        logger.info("Start test");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://phonebook.telran-edu.de:8080/user/login");
        logger.info(m.getName() + " start");
    }


    @AfterMethod(alwaysRun = true)
    public void testInformation(ITestResult result, Method m) throws IOException {
        logger.info(result.getMethod().getTestClass().toString());
        if (result.isSuccess()) {
            logger.info("PASSED " + result.getMethod().getMethodName());
        } else {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("C:\\Users\\ACER\\IdeaProjects\\phonebookQA44\\src\\test\\screenshot\\" + screenName));


            logger.info("FAILED " + result.getMethod().getMethodName());
            logger.info("The screenshot is - scr\\test\\screenshot\\" + screenName);
            logger.info(result.getThrowable().toString());
        }
        logger.info("================================================");
        logger.info(m.getName() + " stop");
        logger.info("Stop test");
        driver.quit();
    }

}
