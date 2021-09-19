import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Hovers extends BaseTest {

//* Hovers - Сделать цепочку из действий: наведение на профиль, проверка имени, клик по ссылке, проверка что нет 404 ошибки.
// Повторить для каждого из профилей. Использовать класс Actions и
// https://stackoverflow.com/questions/17293914/how-to-perform-mouseover-function-in-selenium-webdriver-using-java

    @Test
    public void typos() {
        driver.get("http://the-internet.herokuapp.com/hovers");
        WebElement user1 = driver.findElement(By.xpath("//div[@id='content']//div[@class='figure'][1]"));
        Actions mouseAction = new Actions(driver);
        mouseAction.moveToElement(user1).build().perform();
        String getTextUser1 = driver.findElement(By.xpath("//div[@class='figure']//h5['name: user1']")).getText();//<h5>name: user1</h5>
        assertEquals(getTextUser1, "name: user1","Name user3 is not correct");
        driver.findElement(By.xpath("//a[@href='/users/1'][text()='View profile']")).click();//<a href="/users/1">View profile</a>
        boolean errorPage = driver.findElement(By.xpath("//h1['Not Found']")).isDisplayed(); //<h1>Not Found</h1>
        assertTrue(errorPage, "page with error 404");
        driver.navigate().back();
        WebElement user2 = driver.findElement(By.xpath("//div[@id='content']//div[@class='figure'][2]"));
        mouseAction.moveToElement(user2).build().perform();
        String getTextUser2 = driver.findElement(By.xpath("//h5[text()='name: user2']")).getText();
        assertEquals(getTextUser2, "name: user2","Name user3 is not correct");
        driver.findElement(By.xpath("//a[@href='/users/2'][text()='View profile']")).click();
        errorPage = driver.findElement(By.xpath("//h1['Not Found']")).isDisplayed();
        assertTrue(errorPage, "page with error 404");
        driver.navigate().back();
        WebElement user3 = driver.findElement(By.xpath("//div[@id='content']//div[@class='figure'][3]"));
        mouseAction.moveToElement(user3).build().perform();
        String getTextUser3 = driver.findElement(By.xpath("//h5[text()='name: user3']")).getText();
        assertEquals(getTextUser3, "name: user3","Name user3 is not correct");
        driver.findElement(By.xpath("//a[@href='/users/3'][text()='View profile']")).click();
        errorPage = driver.findElement(By.xpath("//h1['Not Found']")).isDisplayed();
        assertTrue(errorPage, "page with error 404");
        driver.navigate().back();
    }
}
