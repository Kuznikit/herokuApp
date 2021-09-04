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

import static org.testng.Assert.assertEquals;

public class Typos {
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
//Проверить соответствие параграфа орфографии
//Локатор By.tagName(“p”)

    @Test
    public void typos () {
        driver.get("http://the-internet.herokuapp.com/typos");
        String refreshMistakeFirstParagraph = driver.findElement(By.tagName("p")).getText();
        assertEquals(refreshMistakeFirstParagraph,"This example demonstrates a typo being introduced. It does it randomly on each page load.","Mistake in the first paragraph");
        //String refreshMistakeSecondParagraph = driver.findElement(By.tagName("p[2]")).getText();
        //assertEquals(refreshMistakeSecondParagraph,"df","Mistake in the Second paragraph");
        List<WebElement> mistake = driver.findElements(By.tagName("p"));
        assertEquals(mistake.get(1).getText(), "Sometimes you'll see a typo, other times you won,t.","Mistake in the second paragraph");
    }
}
