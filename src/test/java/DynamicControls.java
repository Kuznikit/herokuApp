import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class DynamicControls extends BaseTest {

    @Test
    public void contextMenu(){

        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.cssSelector("[label='blah']")).click();
        driver.findElement(By.cssSelector("[onclick='swapCheckbox()']")).click();
        WebDriverWait waitAdd = new WebDriverWait(driver, 5);
        waitAdd.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        String removeAdd = driver.findElement(By.id("message")).getText();
        assertEquals(removeAdd, "It's gone!", "button didn't work");
        boolean disableInput = driver.findElement(By.cssSelector("[type='text']")).isEnabled();
        assertFalse(disableInput, "Something wrong with Enable/disable");
        driver.findElement(By.cssSelector("[onclick='swapInput()']")).click();
        WebDriverWait waitEnable = new WebDriverWait(driver, 5);
        waitEnable.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        driver.findElement(By.cssSelector("[type='text']")).sendKeys("blabla");
        String disableInputText = driver.findElement(By.cssSelector("[type='text']")).getAttribute("value");
        assertEquals(disableInputText, "blabla", "Something wrong with Enable/disable");

    }
}


