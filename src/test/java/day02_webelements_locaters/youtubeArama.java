package day02_webelements_locaters;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class youtubeArama {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/selenium/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.youtube.com");
        WebElement aramaKutusu=driver.findElement(By.name("search_query"));
        aramaKutusu.sendKeys("canfeza kadirgalar");
        aramaKutusu.submit();

       List<WebElement> arananIcerik=driver.findElements(By.linkText("Canfeza - Kadırgalar"+ Keys.ENTER));
       // arananIcerik.submit();




    }
}
