import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class AddRemoveElements extends BaseTest {

    @Test
    public void addRemoveElementsTest() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.className("added-manually")).click();
        int del = driver.findElements(By.cssSelector("[class='added-manually']")).size();
        assertEquals(del, 1, "Button was deleted");
    }
}
