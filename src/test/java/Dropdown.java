import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.util.List;

import static org.testng.Assert.*;

public class Dropdown extends BaseTest {

    @Test
    public void dropdownList(){
        //Dropdown - Взять все элементы дроп-дауна и проверить их наличие. Выбрать первый, проверить, что он выбран, выбрать второй, проверить, что он выбран
        //Локатор By.id("dropdown")
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        List<WebElement> PrintAllElements = dropdown.getOptions();
        for (int j = 0; j < PrintAllElements.size(); j++) {
            System.out.println(PrintAllElements.get(j).getText());
        }
        Select dropdown1 = new Select(driver.findElement(By.id("dropdown")));
        dropdown1.selectByIndex(1);
        String getText1 = driver.findElement(By.id("dropdown")).getAttribute("value");
        assertEquals(getText1, "1", "The first element is selected");
        Select dropdown2 = new Select(driver.findElement(By.id("dropdown")));
        dropdown2.selectByIndex(2);
        String getText2 = driver.findElement(By.id("dropdown")).getAttribute("value");
        assertEquals(getText2, "2", "The second element is selected");
    }
}
