package day03_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CookiesGecme {
    public static void main(String[] args) {

        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.google.com");
        // cookies'i kabul ederek cookies ekranini kapatin
      //  driver.findElement(By.xpath("//div[text()='Accept all']")).click();

        // arama cubuguna java yazip aratin
        WebElement aramaCubugu =driver.findElement(By.xpath("//input[@name='q']"));
        aramaCubugu.sendKeys("Java"+ Keys.ENTER);

        // arama sonucunun 100binden fazla oldugunu test edin

        WebElement sonucSayiElementi = driver.findElement(By.xpath("//div[@id='result-stats']"));
        // System.out.println(sonucSayiElementi.getText());

        String sonucYazisi= sonucSayiElementi.getText();
        String[] sonucYaziArr=sonucYazisi.split(" ");

        String sonucSayisiStr= sonucYaziArr[1];
        sonucSayisiStr=sonucSayisiStr.replaceAll("\\D","");
        int actualSonucsayisi=Integer.parseInt(sonucSayisiStr);
        int exceptedSonucSayisi=100000;

        if (actualSonucsayisi>exceptedSonucSayisi){
            System.out.println("Arama sonuc sayisi testi PASSED");
        }else {
            System.out.println("Arama sonuc sayisi testi FAILED");
        }


    }
}
