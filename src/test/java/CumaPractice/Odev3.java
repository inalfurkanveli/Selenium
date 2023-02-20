package CumaPractice;

import day02_webelements_locaters.C04_WebElements;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Odev3 {
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test01(){
        //https://testpages.herokuapp.com/styled/index.html web sitesine gidin

        driver.get("https://testpages.herokuapp.com/styled/index.html ");


        //ORİJİNAL İÇERİKLER altında
        //uyarılara tıklayın
        driver.findElement(By.xpath("//a[@id='alerts']")).click();
        //URL'yi yazdır
        System.out.println(driver.getCurrentUrl());
        //geri git
        driver.navigate().back();
        //URL'yi yazdır
        System.out.println(driver.getCurrentUrl());
        //Temel Ajax'a tıklayın
        driver.findElement(By.xpath("//a[@id='basicajax']")).click();
        //URL'yi yazdır
        System.out.println(driver.getCurrentUrl());
        //20 değerini girin ve ENTER
        WebElement valueTextBox= driver.findElement(By.xpath("//input[@id='lteq30']"));
        valueTextBox.sendKeys("20"+Keys.ENTER);
        //ve ardından Gönderilen Değerlerin açık sayfada görüntülendiğini doğrulayın
        List<WebElement> donenDegerler= driver.findElements(By.tagName("p"));
        donenDegerler.isEmpty();
        for (WebElement eachElement:donenDegerler
             ) {
            System.out.println(eachElement);
        }



        //sürücüyü kapat



    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }


}
