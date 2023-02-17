package CumaPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class exercise2 {

     //1 - Driver olusturalim
     public static void main(String[] args) {
         System.setProperty("webdriver.chromedriver.driver","drivers/selenium/chromedriver.exe");
         WebDriver driver = new ChromeDriver();
         // 3 - Driver'in tum ekrani kaplamasini saglayalim
         driver.manage().window().maximize();
         // 4 - Driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini
         //     söyleyelim.
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         //     Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.
         // 5 - "https://www.otto.de" adresine gidelim
         driver.get("https://www.otto.de");
         // 6 - Bu web adresinin sayfa basligini (title) ve adres (url)ini alalim
         String actualTitle = driver.getTitle();
         String actualUrl= driver.getCurrentUrl();
         // 7 - Title ve url'nin "OTTO" kelimesinin icerip icermedigini kontrol edelim
         String expectedTitleIcerik = "OTTO";
         String expectedUrlIcerik = "OTTO";

         if (actualUrl.contains(expectedUrlIcerik) && actualTitle.contains(expectedTitleIcerik)){
             System.out.println("Title ve url Test Passed");
         }else {
             System.out.println("Title ve Url test Failed\n"+
                     "Actual Url : \n"+actualTitle +
                     "Actual Title : "+ actualTitle);
         }

         // 8 - Ardindan "https://wisequarter.com/" adresine gidelim
         driver.navigate().to("https://www.wisequarter.com");
         // 9 - Bu adresin basligini alalim ve "Quarter" kelimesini icerip icermedigini
         //     kontrol edelim
         String wiseExpectedIcerik = "Quarter";
         String wiseActualTitle=  driver.getTitle();
         if (wiseActualTitle.contains(wiseExpectedIcerik)){
             System.out.println("Wisequarter Title Test Passed");
         }else {
             System.out.println("Wisequarter Title Test Failed \n"+
                     "Actual Title :"+ wiseActualTitle);
         }

         // 10- Bir onceki web sayfamiza geri donelim
         driver.navigate().back();
         // 11- Sayfayi yenileyelim
         driver.navigate().refresh();
         // 12- Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
         driver.navigate().forward();
         driver.close();
         // 13- En son adim olarak butun sayfalarimizi kapatmis olalim
        driver.quit();



     }
    //

}
