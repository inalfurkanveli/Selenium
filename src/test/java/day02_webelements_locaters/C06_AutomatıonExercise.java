package day02_webelements_locaters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C06_AutomatıonExercise {
    public static void main(String[] args) {
     //   1- Bir test class’i olusturun ilgili ayarlari yapin

        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //   2-https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com");
        //3- Sayfada 147 adet link bulundugunu test edin.
        List<WebElement> linkElementleriList = driver.findElements(By.tagName("a"));
        int expectekLinkSayisi=147;
        int actualLinkSayisi= linkElementleriList.size();
        if (expectekLinkSayisi== actualLinkSayisi){
            System.out.println("Link Sayisi Testi Passed");
        }else {
            System.out.println("Link Sayisi testi Faild. \n"+
                                "Bulunan Link sayisi"+ actualLinkSayisi);
        }

        //4- Products linkine tiklayin
        driver.findElement(By.partialLinkText("Products")).click();

        //5- special offer yazisinin gorundugunu test edin
        WebElement specialOfferElementi=driver.findElement(By.id("sale_image"));
        if (specialOfferElementi.isDisplayed()){
            System.out.println("Special Offer Testi Passed");
        }else{
            System.out.println("Special Offer Testi Failed.");
        }
        //6- Sayfayi kapatin

        driver.close();
    }

}
