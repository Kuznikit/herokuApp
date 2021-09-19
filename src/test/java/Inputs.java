import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class Inputs extends BaseTest {

    //Inputs - Проверить на возможность ввести различные цифровые и нецифровые значения, используя Keys.ARROW_UP  И Keys.ARROW_DOWN
//Локатор By.tagName(“input”)
    @Test
    public void inputTest() {
        driver.get("http://the-internet.herokuapp.com/inputs");
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_UP, Keys.ARROW_UP, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN);
        String keyArrowUpDown = driver.findElement(By.tagName("input")).getAttribute("value");
        assertEquals(keyArrowUpDown, "-1", "Keys.ARROW_UP 2 times, Keys.ARROW_DOWN 3 times");
        driver.findElement(By.tagName("input")).clear();
        driver.findElement(By.tagName("input")).sendKeys("e");
        String getSymbols1 = driver.findElement(By.tagName("input")).getAttribute("value");
        assertEquals(getSymbols1, "", "e is degree");
        driver.findElement(By.tagName("input")).clear();
        driver.findElement(By.tagName("input")).sendKeys("666");
        String getSymbols2 = driver.findElement(By.tagName("input")).getAttribute("value");
        assertEquals(getSymbols2, "666", "input number");
    }
}
