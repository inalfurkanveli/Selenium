package OrnekCalismalar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Ornek2 extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        //2) sayfadaki iframe sayısını bulunuz.
        int iframeSize= driver.findElements(By.tagName("iframe")).size();

        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement iframeElement= driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
        driver.switchTo().frame(iframeElement);
        driver.findElement(By.xpath("//*[@id=\"movie_player\"]/div[4]/button")).click();

        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();

        //5) ikinci iframe'deki (Jmeter Made Easy) linke
        WebElement ikinciIframe= driver.findElement(By.id("a077aa5e"));
        driver.switchTo().frame(ikinciIframe);
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
        //(https://www.guru99.com/live-selenium-project.html) tıklayınız


        System.out.println("Site'deki iframe sayisi : "+ iframeSize);
    }
}
