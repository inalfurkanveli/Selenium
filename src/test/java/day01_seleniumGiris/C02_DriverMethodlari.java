package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethodlari {

    public static void main(String[] args) throws InterruptedException {

        /*
        jar dosyalarini yükleyerek seleniumu kullanilir hale getirdik
        ancak her bir class'in hangi browser ile calismasını istiyorsak
        o browser ile ilgili driver'i class'ta tanımlamamız lazım.

         browser ile ilgili tercihimiz dogrultusunda
         ilgili ayarlari yapmak icin Java'daki system class'indan
         setProperty() kullanılır

         method'a 2 parametre ekleyecegiz
         1.parametre herkes icin aynı : webdirver.chrome.driver
         2.parametre bu driver'in dosya yolu
         herkesin bilgisarayainda farklı olabilir
         windows'ta sonuna .exe yazilmalidir
         mac'te .exe gerekmez


         */

        System.setProperty("webdirver.chrome.driver","drivers/selenium/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // istenen sayfaya gitmek icin
        driver.get("https://wisequarter.com");

        Thread.sleep(3000);

        // driver.close(); methodu gidilen sayfayı kapatır.
        driver.close();


    }
}
