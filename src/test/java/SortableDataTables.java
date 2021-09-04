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

public class SortableDataTables {
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

    //* Sortable Data Tables - Проверить содержимое нескольких (3-5) ячеек таблицы.
// Использовать xpath типа //table//tr[1]//td[1] - получение первой ячейки из первого ряда первой таблицы и так далее
    @Test
    public void sortableDataTables() {
        driver.get("http://the-internet.herokuapp.com/tables");
        List<WebElement> lastName = driver.findElements(By.xpath("//table//tr/td[1]"));
        assertEquals(lastName.get(0).getText(), "Smith", "column //tr/td[1] must contain Smith");
        assertEquals(lastName.get(1).getText(), "Bach", "column //tr/td[1] must contain Bach");
        assertEquals(lastName.get(2).getText(), "Doe", "column //tr/td[1] must contain Doe");
        assertEquals(lastName.get(3).getText(), "Conway", "column //tr/td[1] must contain Conway");

        List<WebElement> firstName = driver.findElements(By.xpath("//table//tr/td[2]"));
        assertEquals(firstName.get(0).getText(), "John", "column //tr/td[2] must contain John");
        assertEquals(firstName.get(1).getText(), "Frank", "column //tr/td[2] must contain Jason");
        assertEquals(firstName.get(2).getText(), "Jason", "column //tr/td[2] must contain Tim");
        assertEquals(firstName.get(3).getText(), "Tim", "column //tr/td[2] must contain Frank");

        List<WebElement> email = driver.findElements(By.xpath("//table//tr/td[3]"));
        assertEquals(email.get(0).getText(), "jsmith@gmail.com", "column //tr/td[1] must contain jsmith@gmail.com");
        assertEquals(email.get(1).getText(), "fbach@yahoo.com", "column //tr/td[1] must contain fbach@yahoo.com");
        assertEquals(email.get(2).getText(), "jdoe@hotmail.com", "column //tr/td[1] must contain jdoe@hotmail.com");
        assertEquals(email.get(3).getText(), "tconway@earthlink.net", "column //tr/td[1] must contain tconway@earthlink.net");

        List<WebElement> due = driver.findElements(By.xpath("//table//tr/td[4]"));
        assertEquals(due.get(0).getText(), "$50.00", "column //tr/td[1] must contain $50.00");
        assertEquals(due.get(1).getText(), "$51.00", "column //tr/td[1] must contain $51.00");
        assertEquals(due.get(2).getText(), "$100.00", "column //tr/td[1] must contain $100.00");
        assertEquals(due.get(3).getText(), "$50.00", "column //tr/td[1] must contain $50.00");

        List<WebElement> webSite = driver.findElements(By.xpath("//table//tr/td[5]"));
        assertEquals(webSite.get(0).getText(), "http://www.jsmith.com", "column //tr/td[1] must contain http://www.jsmith.com");
        assertEquals(webSite.get(1).getText(), "http://www.frank.com", "column //tr/td[1] must contain http://www.frank.com");
        assertEquals(webSite.get(2).getText(), "http://www.jdoe.com", "column //tr/td[1] must contain http://www.jdoe.com");
        assertEquals(webSite.get(3).getText(), "http://www.timconway.com", "column //tr/td[1] must contain http://www.timconway.com");
    }


}
