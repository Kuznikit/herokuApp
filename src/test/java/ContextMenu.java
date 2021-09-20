import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ContextMenu extends BaseTest {

    @Test
    public void contextMenu() {

        driver.get("http://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);
        actions
                .contextClick(driver.findElement(By.id("hot-spot")))
                .build()
                .perform();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String textOnPage = driver.findElement(By.cssSelector("h3")).getText();
        assertEquals(textOnPage, "Context Menu", "Context Menu is not closed");
    }
}
