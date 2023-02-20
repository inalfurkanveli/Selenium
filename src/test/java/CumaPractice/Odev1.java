package CumaPractice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Odev1  extends TestBase {
    @Test
    public void test01(){
        //url'ye gidin: https://www.techlistic.com/p/selenium-practice-form.html
driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        //ilk adı doldurun
        WebElement isim = driver.findElement(By.xpath("//input[@name='firstname']"));
        isim.sendKeys("Furkan Veli");
        //soyadını doldur
        WebElement soyIsim= driver.findElement(By.xpath("//input[@name='lastname']"));
        soyIsim.sendKeys("INAL");
        //cinsiyeti kontrol et
        driver.findElement(By.xpath("//input[@id='sex-0']")).click();


        //deneyimi kontrol et
        driver.findElement(By.xpath("//input[@type='radio'][3]")).click();
        //tarihi doldur
        WebElement dateBox= driver.findElement(By.xpath("//input[@id='datepicker']"));
        //mesleğinizi seçin -> Otomasyon Test Cihazı
        driver.findElement(By.xpath("//input[@type='checkbox'][2]")).click();
        //aracınızı seçin -> Selenium Webdriver

        driver.findElement(By.xpath("//input[@id='tool-2']")).click();
        //kıtanızı seçin -> Antarktika
        WebElement ddm= driver.findElement(By.xpath("//select[@name='continents']"));
        Select select= new Select(ddm);
        select.selectByVisibleText("Antartika");

        //komutunuzu seçin -> Tarayıcı Komutları
        WebElement ddm1= driver.findElement(By.xpath("//select[@id='selenium_commands']"));
        Select select1=new Select(ddm1);
        select1.selectByIndex(0);
        System.out.println(select1.getOptions());

        //gönder düğmesine tıklayın
        driver.findElement(By.xpath("//button[text()='Button']")).click();

    }



}
