package day06_window_iframe_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_SwitchWindows extends TestBase {
    @Test
    public void test01(){
        // amazon anasayfaya gidip, arama kutusunun erisilebilir oldugunu test edin
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(aramaKutusu.isEnabled());
        String amazonWindowHandle= driver.getWindowHandle();
        bekle(2);
// yeni bir tab olarak wisequarter.com'a gidin
// url'in wisequarter icerdigini test edin
        /*
        once yeni bir tab olusturup driver'i o sayfaya gecirmeliyiz
         */
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");
        String expectedIcerik="wisequarter";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        String wiseWindowHandle= driver.getWindowHandle();
        bekle(2);
// amazon'un acik oldugu tab'a geri donup
        /*
        Daha once acilmis olan bir window'a gecis yapmak icin
        o sayfanin window handle degerine ihtiyacimiz var
        Testimiz boyle bir gorevi iceriyorsa o sayfada iken WindowHandle
        degerini alip kayit yapmaliyiz
         */
        driver.switchTo().window(amazonWindowHandle);

// Nutella icin arama yapin
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
// Sonuclarin Nutella icerdigini test edin
     String actualSonucYazisi=
             driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")).
             getText();
     String expectedicerik="Nutella";
     Assert.assertTrue(actualSonucYazisi.contains(expectedicerik));

bekle(2);
// yeni bir window olarak youtube.com'a gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");
// Url'in youtube icerdigini test edin
        String expectedUrlIcerik ="youtube";
        String actualurl=driver.getCurrentUrl();
        Assert.assertTrue(actualurl.contains(expectedUrlIcerik));
bekle(2);
// wisequarter'in acik oldugu sayfaya donun
        driver.switchTo().window(wiseWindowHandle);
// Title'in WiseQuarter icerdigini test edin
        expectedIcerik="Wise Quarter";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedIcerik));
        bekle(3);
    }
}
