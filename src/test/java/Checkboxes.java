import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.*;

public class Checkboxes extends BaseTest {

    @Test
    public void CheckOnOff() {
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
