package ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.time.Duration;

public class TestBase {
    protected WebDriver driver;
    protected final String EMAIL = "test@gmail.com";
    protected final String PASSWORD = "test@gmail.com";

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
    @AfterMethod
    public void tearDown(Method m){
        logger.info(m.getName() + " stop");
        driver.quit();
        logger.info("Stop test");
    }

    @AfterMethod(alwaysRun = true)
    public void testInformation(ITestResult result) {
        logger.info(result.getMethod().getTestClass().toString());
        if (result.isSuccess()) {
            logger.info("PASSED " + result.getMethod().getMethodName());
        } else {
            logger.info("FAILED " + result.getMethod().getMethodName());
            logger.info(result.getThrowable().toString());
        }
        logger.info("================================================");
    }

}
