import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class Checkboxes {
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
        driver.quit();
    }
    @Test
    public void CheckOnOff(){
        //driver.get("https://the-internet.herokuapp.com/checkboxes");
        //String isCheckOn = driver.findElement(By.cssSelector("[type=checkbox]")).getAttribute("checked");
        //assertEquals(isCheckOn,"", "Checkbox is Off");
        //String isCheckOff = driver.findElement(By.cssSelector("[type=checkbox]")).getAttribute("checked");;
        //assertEquals(isCheckOff,true, "Checkbox is Off");
        //driver.findElement(By.cssSelector("[type=checkbox]")).click();
        //String isCheckOn = driver.findElement(By.cssSelector("[type=checkbox]")).getAttribute("checked");
        //assertEquals(isCheckOn,"true", "Checkbox is On");

        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("[type=checkbox]"));
        assertFalse(checkBoxes.get(0).isSelected(), "CheckBox 1 is OFF");
        checkBoxes.get(0).click();
        assertTrue(checkBoxes.get(0).isSelected(), "CheckBox 1 is ON");
        assertTrue(checkBoxes.get(1).isSelected(), "CheckBox 2 is ON");
        checkBoxes.get(1).click();
        assertFalse(checkBoxes.get(1).isSelected(), "CheckBox 2 is OFF");
    }

}
