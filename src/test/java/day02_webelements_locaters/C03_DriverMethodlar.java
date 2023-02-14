package day02_webelements_locaters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_DriverMethodlar {
    public static void main(String[] args) {

        //1.Yeni bir class olusturalim (Homework)
        //2.ChromeDriver kullanarak, facebook sayfasina gidin
        System.setProperty("webdriver.chrome.driver","drivers/selenium/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.facebook.com");
       // ve sayfa basliginin (title) “facebook” oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        String exceptedTitle = "facebook";
        String actualTitle = driver.getTitle();
        if (exceptedTitle.equals(actualTitle)){
            System.out.println("facebook title test PASSED");
        }else {
            System.out.println("facebook title test FAILED");
            System.out.println("facebook title "+actualTitle);
        }
        //3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
        String exceptedIcerik = "facebook";
        String actualUrl= driver.getCurrentUrl();
        if (actualUrl.contains(exceptedIcerik)){
            System.out.println("URL TEST PASSED");
        }else {
            System.out.println("URL TEST FAILED!");
            System.out.println("Gerceklesen url : "+actualUrl);
        }
        //4.https://www.walmart.com/ sayfasina gidin.
        driver.get("https://www.walmart.com");
        //5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String exceptedIcerikWalmart="Walmart.com";
        String actualTitleWalmart=driver.getTitle();
        if (actualTitleWalmart.contains(exceptedIcerikWalmart)){
            System.out.println("Walmart Title Test Passed");
        }else {
            System.out.println("Walmart Title Test Failed");
        }

        //6. Tekrar “facebook” sayfasina donun
        driver.navigate().back();
        //7. Sayfayi yenileyin
        driver.navigate().refresh();
        //8. Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();
        //9.Browser’i kapatin
        driver.close();



    }
}
