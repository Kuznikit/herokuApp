import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.assertEquals;

public class Typos extends BaseTest {

    //Проверить соответствие параграфа орфографии
//Локатор By.tagName(“p”)
    @Test
    public void typos() {
        driver.get("http://the-internet.herokuapp.com/typos");
        String refreshMistakeFirstParagraph = driver.findElement(By.tagName("p")).getText();
        assertEquals(refreshMistakeFirstParagraph, "This example demonstrates a typo being introduced. It does it randomly on each page load.", "Mistake in the first paragraph");
        //String refreshMistakeSecondParagraph = driver.findElement(By.tagName("p[2]")).getText();
        //assertEquals(refreshMistakeSecondParagraph,"df","Mistake in the Second paragraph");
        List<WebElement> mistake = driver.findElements(By.tagName("p"));
        assertEquals(mistake.get(1).getText(), "Sometimes you'll see a typo, other times you won,t.","Mistake in the second paragraph");
    }
}
