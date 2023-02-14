package day02_webelements_locaters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_WebElements {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/selenium/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        driver.get("https://www.amazon.com");

        // arama kutusunu locate edip bir webelement olarak kaydedin
        // id'si twotabsearchtextbox olan webelement seklinde locate edecegiz

        /*
        Driver'a webelementi tarif etme islemine Locate,
        bu tarifi yapabilmek icin kullanabilcegim degiskenlere de LOCATER denir

        8 tane Locator vardir
        Locator'larin 6 tanesi webelement'in ozelliklerine baglidir
        - id
        - className
        - name
        - tagName
        - linkText
        - partialLinkText
        Geriye kalan 2 Locator ise her turlu webelementi locate etmek icin kullanilir.
        -xpath
        -cssSelector


         */
       WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

       // arama kutusuna 'nutella' yazip aratin

        aramaKutusu.sendKeys("nutella");
        aramaKutusu.submit();

        Thread.sleep(3000);

        driver.close();

    }
}
