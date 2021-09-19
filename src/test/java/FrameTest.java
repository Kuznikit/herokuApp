import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class FrameTest extends BaseTest{

    @Test
    public void frames(){

        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame(0);
        String textInFrame = driver.findElement(By.cssSelector("p")).getText();
        assertEquals(textInFrame, "Your content goes here.", "Wrong text");
    }
}
