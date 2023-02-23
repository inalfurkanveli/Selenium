package day08_excplicitlyWait_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C05_WebTables extends TestBase {
    @Test
    public void test01(){
        //1.“https://www.amazon.com” adresine gidin
        driver.get("https://www.amazon.com");
        //2.Sayfanin en altina inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        //3.Web table tum body’sini yazdirin
        WebElement tumBody= driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());
        //4.Web table’daki satir sayisinin 9 oldugunu test edin
        List<WebElement> satirlar=driver.findElements(By.xpath("//tbody/tr"));
        Assert.assertEquals(10,satirlar.size());
        //5.Tum satirlari yazdirin
        int satirNo=1;

        for (WebElement eachsatir:satirlar
             ) {
            System.out.println(satirNo+"- "+ eachsatir);
            satirNo++;
        }
        //6. Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement> ucuncuSatirDatalarList=driver.findElements(By.xpath("//tbody/tr[3]/td"));
        Assert.assertEquals(13,ucuncuSatirDatalarList.size());
        //7. 5.sutunu yazdirin
        List<WebElement> besinciSutunDatalarList=driver.findElements(By.xpath("//tbody/tr/td[5]"));
        System.out.println("====5.sutun====");
        satirNo=1;
        for (WebElement eachData:besinciSutunDatalarList
             ) {
            System.out.println(satirNo+"- "+ eachData.getText());
            satirNo++;
        }
        //8.Satir ve sutun sayisini parametre olarak alip,
        // hucredeki bilgiyi döndüren bir method olusturun

        System.out.println("istenen data : \n"+getData(+3, 5));

        bekle(3);

        //9. 7.satirin 9uncu datasinin shoes icerdigini test edelim

        String actualData=getData(7, 9);
        String expectedData="Shoes";

        Assert.assertTrue(actualData.contains(expectedData));
    }

    public  String getData(int satirNo,int sutunNo){

        //3.satir 5.ci sutundaki bilgiyi yazdirin
        // //tbody/tr[3]/td[5]

        String dataXpath="//tbody/tr["+ satirNo + "]/td[" + sutunNo +"]";
        String istenenData=driver.findElement(By.xpath(dataXpath)).getText();

        return istenenData;
    }
}
