package OrnekCalismalar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseClass;

import java.util.List;

public class Ornek4 extends TestBaseClass {
    @Test
    public void test01(){
        //Test01 :
        //1- amazon gidin
        driver.get("https://www.amazon.com");
        //2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
      //  WebElement dropDownMenu= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        WebElement ddm=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(ddm);
        String ddmList=ddm.getText();

        System.out.println(ddmList);
        //3- dropdown menude 40 eleman olmadigini doğrulayın
        int expectedOptions=40;
        int actualOptions=select.getOptions().size();
        Assert.assertNotEquals(expectedOptions,actualOptions);


        //Test02
        //1- dropdown menuden elektronik bölümü seçin
        select.selectByVisibleText("Electronics");
        //2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone"+ Keys.ENTER);
        WebElement totalSearch=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String totalSearhText=totalSearch.getText();


        //3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String expectedIcerik="iphone";
        String actualSearchText=totalSearch.getText();
        Assert.assertTrue(actualSearchText.contains(expectedIcerik));
        //4- ikinci ürünu locate ederek tıklayin
        WebElement ilkUrunText=driver.findElement(
                By.xpath("(//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4'])[1]"));
        ilkUrunText.click();



        //5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim

        String urunTitle=driver.getTitle();
        String urunFiyat=driver.findElement(By.xpath("(//span[text()='$6.99'])[1]")).getText();

       WebElement addCard= driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]"));
       addCard.click();


        //Test03
        //1- yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");

        //2-dropdown’dan bebek bölümüne secin
        select.selectByVisibleText("Baby");

        //3-baby stroller aratıp bulundan sonuç sayısını yazdırın
        searchBox.sendKeys("baby stroller");
        totalSearch=driver.findElement(By.xpath("//*[text()='1-16 of over 3,000 results for']"));
        //4-sonuç yazsının baby içerdiğini test edin
        expectedIcerik="baby";
        actualSearchText=totalSearch.getText();
        Assert.assertTrue(actualSearchText.contains(expectedIcerik));

        //5-ikinci ürünu lacate ederek  tıklayin
        driver.findElement
                (By.xpath("(//*[text()='Kolcraft Cloud Plus Lightweight Easy Fold Compact Travel Toddler Stroller and Baby Stroller, Large Storage Basket, Multi-Position Recline, Convenient One-Hand Fold, 13lbs - Slate Grey'])[1]")).click();
        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin


    }
    @Test
    public void test04(){
        //Test 4
        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
    }

}
