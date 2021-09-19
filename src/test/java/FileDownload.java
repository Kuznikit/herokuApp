import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.io.File;
import static org.testng.Assert.assertTrue;
public class FileDownload extends BaseTest {

    @Test
    public void fileDownload() {
        driver.get("http://the-internet.herokuapp.com/download");
        driver.findElement(By.linkText("ex03.png")).click();
        File folder = new File(System.getProperty("webdriver.chrome.whitelistedIps", "C:/Users/Mikita/Downloads"));
        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File f = null;
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                if (fileName.matches("ex03.png")) {
                    f = new File(fileName);
                    found = true;
                }
            }
        }
        assertTrue(found, "Downloaded document is not found");
        f.deleteOnExit();
    }
}
