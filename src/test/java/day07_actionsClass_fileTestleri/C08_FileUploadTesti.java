package day07_actionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C08_FileUploadTesti extends TestBase {
    @Test
    public void test01(){
        //1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //2.chooseFile butonuna basalim

        //3.Yuklemek istediginiz dosyayi secelim.
        // Downloads'a indirdigimiz logo.png dosyasini yukleyelim


        /*
        choose file butonuna basarsak bilgisarayimizdan bir
        dpsya secme islemi yapmamiz gerekir.
        ancak selenium veya java bilgisarayimizdan dosya secme
        islemi yapamaz

        Bunun yerine selenium bize bir yontem gelistirmistir
        chooseFile ile secmemiz gereken dosyanin dosya yolunu olusturup

        olusturulan dosya yolunu sendKeys ile chooseFile butonuna
        gondermemiz yeterli olur
         */
        bekle(3);
        String dinamikDosyaYolu= System.getProperty("user.home")+"\\Downloads\\logo.png";
        WebElement chooseFile= driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys(dinamikDosyaYolu);
        bekle(3);


        //4.Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        //5.“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUploadYaziElementi= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadYaziElementi.isDisplayed());


        bekle(5);
    }
}
