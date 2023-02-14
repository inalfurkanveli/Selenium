package day02_webelements_locaters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ImplycitlyWait {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","drivers/selenium/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));




                /*
                driver bir web uygulamasina gonderdigimizde o sayfanin acilmasin,
                orada istedigimiz islemleri yapmak icin elementleri bulmasi.. gibi islemler
                zaman gerektirebilir

                impliycitlyWait bu tur zaman isteyen islemler icin
                driver'in max ne kadar bekleyecegini belirler
                 */
    }
}
