package base.frontend;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.awt.*;
import java.awt.event.KeyEvent;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() throws AWTException {
        Robot robot = new Robot();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        robot.keyPress(KeyEvent.VK_ESCAPE);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
