package SeleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class googleTest {
    String https="https://www.";
    WebDriver driver;
    @Before
    public  void setup(){
        // ilgili kurulumlari tamamlayalim
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void googleTest(){

        driver.get(https+"google.com");

        //  Kullanici https://www.google.com adresine gider

        //  Kullanici cookies i kabul eder
   // WebElement cookies= driver.findElement(By.xpath("//div[text()='Reject all']"));
   // cookies.click();
        // Arama Kutusuna karsilastirma yapmak istedigi para birimlerini girer
        WebElement searchBox= driver.findElement(By.xpath("//input[@class='gLFyf']"));
        searchBox.sendKeys("euro dolar"+ Keys.ENTER);
        // Para birimlerinin karsilastirmasini alir
        WebElement karsilastirilanParaBirimi= driver.findElement(By.xpath("//span[@class='DFlfde SwHCTb']"));
        System.out.println(karsilastirilanParaBirimi);
        String birimDegeri=karsilastirilanParaBirimi.getText();
        // Karsilastirilacak olan para biriminin 1.5 den kucuk oldugu test edilir
        birimDegeri.replaceAll(",",".");

        Assert.assertTrue(Double.parseDouble(birimDegeri)<1.5);

    }
    @After
    public void teardown(){
        driver.close();

    }
}
