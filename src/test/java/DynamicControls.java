import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.testng.Assert.*;

public class DynamicControls {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        //options.addArguments("headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        // driver.quit();
    }

    @Test
    public void contextMenu() throws InterruptedException {

        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.cssSelector("[label='blah']")).click();
        driver.findElement(By.cssSelector("[onclick='swapCheckbox()']")).click();
        sleep(4000);
        String removeAdd = driver.findElement(By.id("message")).getText();
        assertEquals(removeAdd, "It's gone!", "button didn't work");
        boolean disableInput = driver.findElement(By.cssSelector("[type='text']")).isEnabled();
        System.out.println(disableInput);
        assertFalse(disableInput, "Something wrong with Enable/disable");
        driver.findElement(By.cssSelector("[onclick='swapInput()']")).click();
        sleep(4000);
        driver.findElement(By.cssSelector("[type='text']")).sendKeys("blabla");
        String disableInputText = driver.findElement(By.cssSelector("[type='text']")).getAttribute("value");
        assertEquals(disableInputText, "blabla", "Something wrong with Enable/disable");

    }
}


