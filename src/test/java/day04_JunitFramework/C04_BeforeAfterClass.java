package day04_JunitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.time.Duration;

public class C04_BeforeAfterClass {
    // 3 test method'u olusturun
    //1.de amazon sayfasina gidip, gittiginizi test edin
    //2.de Nutella aratip arama sonuclarinin nutella icerdigini test edin
    //3.de test ilk urune tiklayip, urun isminde nutella gectigini test edin

    // Eger her bir test method'u icin driver olusturup sonunda kapatmamiz gerekmiyorsa
    // classin basinda bir kez driver olusturup class"in sonunda driver'i kapatabiliriz.

    // @BeforeClass ve @AfterClass notasyonu kullanan methodlar static olmalidir

static  WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        String exceptedUrlIcerik = "amazon";
        String actualUrl=driver.getCurrentUrl();

        if (actualUrl.contains(exceptedUrlIcerik)){
            System.out.println("Amazon Test Passed");
        }else {
            System.out.println("Url amazon icermiyor Test Fail");
        }


    }
    @Test
    public void test02(){
        //2.de Nutella aratip arama sonuclarinin nutella icerdigini test edin
      WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
      aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

      WebElement aramaSonucElementi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));

      String expectedIcerik="Nutella";
      String actualSonucYazisi=aramaSonucElementi.getText();

      if (actualSonucYazisi.contains(expectedIcerik)){
          System.out.println("Nutella Testi Passed");
      }else {
          System.out.println("Nutella Testi Fail");
      }
    }
    @Test @Ignore
    public void test03(){
        //3.de test ilk urune tiklayip, urun isminde nutella gectigini test edin
        WebElement ilkUrun = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        ilkUrun.click();

        WebElement urunIsimElementi= driver.findElement(By.xpath("//span[@id='productTitle']"));

        String expectedIcerik="Nutella";
        String actualUrunIsmi=urunIsimElementi.getText();

        if (actualUrunIsmi.contains(expectedIcerik)){
            System.out.println("Urun ismi test passed");
        }else {
            System.out.println("Urun ismi tesi failed");
        }

    }
}
