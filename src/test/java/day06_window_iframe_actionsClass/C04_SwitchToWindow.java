package day06_window_iframe_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C04_SwitchToWindow extends TestBase {
    @Test
    public void test01(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement ilkSayfaYaziElementi= driver.findElement(By.tagName("h3"));
        String expectedYazi="Opening a new window";
        String actualYazi=ilkSayfaYaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle="The Internet";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        String ilkSayfaWindowHandle=driver.getWindowHandle();

        //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.


        /*
        Eger switchToNewWindow() method'u kullanilirsa
        driver yeni acilan sayfaya gecis yapar

        Ancak bu method kullanilmadan bir link tiklandiginda yeni bir sayfa
        aciliyorsa driver yeni ssayfaya gecis yapmaz

        Bizim yeni acilan sayfanin
        windowHandle degerini bulup driver'i o sayfaya gecirmemiz GEREKLIDIR

        Link'e click yaptigimizda acik iki sayfamiz oluyor
        bunlardan bir tanesi window handle degerini kaydettigimiz
        ILK SAYFA digeri ise window handle degerini bilmedigimiz IKINCI SAYFA

        biz getWindowHandles()methodu ile
        bir SET olarak iki sayfanin windowHandle degerlerini alabiliyoruz

        O set icerisinde ilkSayfaWHD'ine esit olmayan String'i
        ikinciSayfaWHD olarak atayabiliriz
         */

        Set<String> tumSayfalarWHDSeti= driver.getWindowHandles();

        String ikinciSayfaWHD="";

        for (String each:tumSayfalarWHDSeti
             ) {
            if (!each.equals(ilkSayfaWindowHandle)){
                ikinciSayfaWHD=each;
            }
        }

driver.switchTo().window(ikinciSayfaWHD);
        expectedTitle="New Window";
        actualTitle=driver.getTitle();
        bekle(2);
        Assert.assertEquals(expectedTitle,actualTitle);
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String ikinciSayfaYazi=driver.findElement(By.tagName("h3")).getText();
        expectedYazi="New Window";

        Assert.assertEquals(expectedYazi,ikinciSayfaYazi);


        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının
        // “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaWindowHandle);
        expectedTitle="The Internet";
        actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }
}
