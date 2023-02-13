package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_DriverMethodları {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/selenium/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

    // amazon ana sayfaya gidin

        driver.get("https://www.amazon.com");
        // gittiginiz sayfadaki title ve url yazdırın
        System.out.println("URL : "+driver.getCurrentUrl());
        System.out.println("TITLE: "+driver.getTitle());
        // amazon anasayfaya gittiginizi test edin.

        // Test expected result ile actual result'in karsilastirilmasi
        String expectedIcerik = "amazon";
        String actualUrl=driver.getCurrentUrl();

        if (actualUrl.contains(expectedIcerik)){
            System.out.println("TEST PASSED");
        }
        else {
            System.out.println("TEST FAILED");
        }


    }
}
