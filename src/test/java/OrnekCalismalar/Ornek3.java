package OrnekCalismalar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;
import utilities.TestBaseClass;

import java.util.Set;

public class Ornek3 extends TestBaseClass {
    @Test
    public void test01(){

        //● Yeni bir class olusturun: WindowHandle
        //● Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");
        //● Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonWHD= driver.getWindowHandle();
        //● Sayfa title’nin “Amazon” icerdigini test edin
        String expectedAmazonTitle="Amazon";
        String adtualAmazonTitle=driver.getTitle();

        Assert.assertTrue(adtualAmazonTitle.contains(expectedAmazonTitle));
        bekle(2);
        //● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        String wiseWHD=driver.getWindowHandle();
        driver.get("https://www.wisequarter.com");
        //● Sayfa title’nin “wisequarter” icerdigini test edin
        String expectedWiseIcerik="Wise Quarter";
        String actualWiseTitle=driver.getTitle();
        Assert.assertTrue(actualWiseTitle.contains(expectedWiseIcerik));
        bekle(2);
        //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");
        //● Sayfa title’nin “Walmart” icerdigini test edin
       String expectedWalmartIcerik="Walmart";
       String actualWalmartTitle=driver.getTitle();
       Assert.assertTrue(actualWalmartTitle.contains(expectedWalmartIcerik));
       bekle(2);
        //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonWHD);
        String expectedUrl="amazon";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));

        bekle(3);
        Set<String> tumWHD= driver.getWindowHandles();

        String WHD3="";
        for (String each:tumWHD
             ) {
            if (!(amazonWHD.equals(each)) && !(wiseWHD.equals(each))){
                WHD3=each;
            }
        }
        System.out.println(WHD3);

        driver.switchTo().window(WHD3);

    }
}
