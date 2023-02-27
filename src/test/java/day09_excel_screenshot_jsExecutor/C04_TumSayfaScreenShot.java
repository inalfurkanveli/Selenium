package day09_excel_screenshot_jsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class C04_TumSayfaScreenShot extends TestBase {
    @Test

    public void test01() throws IOException {

        // amazon ana sayfaya gidin
        driver.get("https://www.amazon.com");

        // nutella icin arama yapin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        // sonuclarin Nutella icerdigini test edin
        String actualSearchResult=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")).getText();
        String expectedIcerik="Nutella";

        Assert.assertTrue(actualSearchResult.contains(expectedIcerik));

        // ve rapora eklenme icin tum sayfanin fotosunu cekin

        // Tum sayfa screenshot icin
        // 1- TakeScreenShot objesi olustur

        TakesScreenshot ts= (TakesScreenshot) driver;

        // 2-screenshot'u kaydedecegimiz bir dosya olusturalim
        File tumSayfaSS=new File("target/screenshot.png");

        // 3- gecici bir dosya olusturup ts objesi ile cekilen fotografi dosyaya
        // kaydediyoruz

        File geciciResim=ts.getScreenshotAs(OutputType.FILE);

        //4- gecici dosyayi, tumSayfaSS dosyasina kopyalalim

        FileUtils.copyFile(geciciResim,tumSayfaSS);

        bekle(3);




    }
}
