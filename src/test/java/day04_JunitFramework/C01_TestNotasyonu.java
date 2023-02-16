package day04_JunitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TestNotasyonu {
    /*
    Framework: Ortak calisma cercevesi
                Hangi dosyalari nerede olusturacagimizi belirle ve boylece toplu calismayi kolaylastirir
                Her framework, dosya duzeni olusturmanin yaninda ,
                islerimizi kolaylastiran yeni ozellikler sunmustur.

                JUnit Framework en temel test framework'udur.
                bize kazandirdigi en onemli ozellik @Test Annotation (Notasyon)'dir.

@Test Notasyonu saysinde her bir method bagimsiz olarak calistirilabilen test methodu olur


@Test notasyonu sayesinde istersek her bir test method'unu bagimsiz calistirabildigimiz gibi
istenirse class level'dan calistirip,
tum testlerin calismasini saglayabiliriz

JUnit framwork'de test method"larinin hangi sirayla calisacagini
ONGOREMEYIZ ve KONTROL EDEMEYIZ.
     */
@Test
    public void Test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.wisequarter.com");

        driver.close();


    }
    @Test
    public void Test02(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.wisequarter.com");

        driver.close();

    }
}
