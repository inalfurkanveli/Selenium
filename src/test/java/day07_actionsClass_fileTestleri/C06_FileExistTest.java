package day07_actionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_FileExistTest extends TestBase {
    @Test
    public void test01(){
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //3. logo.png dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='logo.png']")).click();
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        bekle(5);
        String dinamikDosyaYolu= System.getProperty("user.home")+ "\\Downloads\\logo.png";

        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
    }
}
