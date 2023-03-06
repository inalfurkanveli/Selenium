package SeleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class kiwiTest {
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
    public void kiwiTest01() throws InterruptedException {
        // https://www.kiwi.com sayfasina gidin
        driver.get("https://www.kiwi.com/en/");
        // Cookies i reddedin
        driver.findElement(By.xpath("(//div[@class='ButtonPrimitiveContent__StyledButtonPrimitiveContent-sc-1nfggrh-0 iFkUjC'])[3]")).click();
        // Sag ust kisimdan dil ve para birimi secenegini Turkiye ve TL olarak secin

        driver.findElement
                        (By.xpath("(//div[@class='ButtonPrimitiveContent__StyledButtonPrimitiveContent-sc-1nfggrh-0 jIgbVC'])[7]"))
                        .click();
        // Sectiginiz dil ve para birimini dogrulayin
        Thread.sleep(1000);
        WebElement ddm=driver.findElement(By.xpath("//select[@data-test='LanguageSelect']"));
        Select dilsecimi=new Select(ddm);
        dilsecimi.selectByVisibleText("Türkçe");
        WebElement ddm1=driver.findElement(By.xpath("//select[@data-test='CurrencySelect']"));
        Select paraSecimi=new Select(ddm1);
        paraSecimi.selectByVisibleText("Turkish lira - TRY");



        // save&continue tiklayin
        driver.findElement(By.xpath("//button[@data-test='SubmitRegionalSettingsButton']")).click();
        // Ucus secenegi olarak tek yon secelim
        driver.findElement(By.xpath("//*[text()='Gidiş Dönüş']")).click();
        driver.findElement(By.xpath("//*[text()='Tek Yön']")).click();
        // Kalkis ve varis boxlarini temizleyerek kalkis ve varis ulkesini kendimiz belirleyelim.
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//*[@preserveAspectRatio='xMidYMid meet'])[29]")).click();
        WebElement kalkis=driver.findElement(By.xpath("(//input[@data-test='SearchField-input'])[1]"));
        kalkis.sendKeys("Izmir");
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//div[@data-test='PlacePickerRow-wrapper'])[1]")).click();
        WebElement inis=driver.findElement(By.xpath("(//input[@data-test='SearchField-input'])[2]"));
        inis.sendKeys("Berlin");
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//div[@data-test='PlacePickerRow-wrapper'])[1]")).click();
        driver.findElement(By.xpath("//input[@data-test='SearchFieldDateInput']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[@data-value='2023-03-16']")).click();
        driver.findElement(By.xpath("//*[text()='Tarihleri ayarla']")).click();
        // Gidis tarihi kismina erisim saglayarak gidecegimiz gunu secelim ve booking i iptal edelim
        driver.findElement(By.xpath("//*[text()='Booking.com ile konaklama arayın']")).click();
        driver.findElement(By.xpath("//a[@data-test='LandingSearchButton']")).click();

        // Sadece aktarmasiz ucuslar olarak filtreleme yapalim ve en ucuz secenegine tiklayalim
        driver.findElement(By.xpath("(//div[@class='Radio__StyledTextContainer-sc-1e6hy4x-2 jUUsVM'])[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//div[@class='SortingPanelstyled__StyledPanelItem-sc-a0wlfp-2 fpyTjW'])[1]")).click();


        Assert.assertTrue(driver.getCurrentUrl().contains("sortBy=price"));
        // Filtreleme yaptigimiz en ucuz ucusun fiyatini getirerek 5000 tl den kucuk oldgunu dogurlayalim

        String biletUcretText=driver.findElement(By.xpath("//strong[@data-test='ResultCardPrice']")).getText();

       String biletFiyat=  biletUcretText.substring(0,5);



        double biletUcreti=Double.parseDouble(biletFiyat);

        Assert.assertTrue(biletUcreti<5000);
    }

     @After
   public void teardown(){
        driver.close();

   }
}
