package day09_excel_screenshot_jsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C05_WebElementScreenshot extends TestBase {

    @Test
    public void test01() throws IOException {

        // amazon ana sayfaya gidin
        driver.get("https://www.amazon.com");

        // nutella icin arama yapin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        // sonuclarin Nutella icerdigini test edin

        WebElement sonucYaziElementi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));

        String actualSearchResult=sonucYaziElementi.getText();
        String expectedIcerik="Nutella";

        Assert.assertTrue(actualSearchResult.contains(expectedIcerik));



        // ve rapora eklenme icin sonuc yazisinin fotosunu cekin

        // fotograf cekilecek elementi locate edin
        //2- dosyayi kaydetmek icin bir file olusturun

        File elementScreenshoot=new File("target/elementScreenshot.png");

        //3- webelement ile screenshot cekip gecici dosyaya kaydedin

        File geciciDosya=sonucYaziElementi.getScreenshotAs(OutputType.FILE);

        // 4- gecici dosyayi elementSS'e kaydedelim

        FileUtils.copyFile(geciciDosya,elementScreenshoot);
    }
}
