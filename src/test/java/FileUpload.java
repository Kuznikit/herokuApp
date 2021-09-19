import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.io.File;
import static org.testng.Assert.assertEquals;

public class FileUpload extends BaseTest{

    @Test
    public void fileUpload(){

        driver.get("http://the-internet.herokuapp.com/upload");
        File file = new File("src/test/resources/Upload.txt");
        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();
        String fileUpload = driver.findElement(By.id("uploaded-files")).getText();
        assertEquals(fileUpload, "Upload.txt", "File is not uploaded");
    }
}
