package day01_seleniumGiris;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverMethodlari {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/selenium/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.wisequarter.com");

        System.out.println(driver.getWindowHandle());
        // CDwindow-C0F676A143D5279BFE817F58392C0C8A
      //  CDwindow-9AADB37748A081C1437C8B1B30BB70B1

        // getWindowHandle selenium tarafindan her driver sayfası icin
        // üretilen uniqe handle degerini getirir.
        // getWindowHandles ise test sırasında birden fazla sayfa acilmissa
        // bir set olarak tüm sayfaların window handle degerlerini bize döndürür.

        System.out.println(driver.getPageSource());
        // gittigimiz sayfanın kodlarını bize döndürür.

        // sayfa kodları"2 hours weekly meeting with the team" iceriyor mu test edin

        String expectedIcerik="2 hours weekly meeting with the team";
        String actualSayfaKodlari= driver.getPageSource();

        if (actualSayfaKodlari.contains(expectedIcerik)){
            System.out.println("TEST PASSED");
        }
        else {
            System.out.println("TEST FAILED");
        }

        driver.quit();
        // close ve quit ikiside sayfa kapatmak icin kullanılır
        // close sadece 1 sayafayı kapatırken
        // quit test sırasında acılan tüm sayfaları kapatır.
    }
}
