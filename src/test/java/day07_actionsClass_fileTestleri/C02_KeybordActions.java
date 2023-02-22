package day07_actionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_KeybordActions extends TestBase {

        @Test
        public void test01(){

            //2- https://www.amazon.com sayfasina gidelim
            driver.get("https://www.amazpn.com");
            //3- Arama kutusuna actions method’larine kullanarak Samsung A7


            //1 yazdirin ve Enter’a basarak arama yaptirin
            WebElement aramaKutus=driver.findElement(By.id("twotabsearchtextbox"));
            //4- aramanin gerceklestigini test edin
            Actions actions= new Actions(driver);

            actions.click(aramaKutus)
                    .keyDown(Keys.SHIFT)
                    .sendKeys("s")
                    .keyUp(Keys.SHIFT)
                    .sendKeys("amsung ")
                    .keyDown(Keys.SHIFT)
                    .sendKeys("a")
                    .keyUp(Keys.SHIFT)
                    .sendKeys("71")
                    .sendKeys(Keys.ENTER)
                    .perform();

            //4- aramanin gerceklestigini dogrulayin
            String actualSonucYazisi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")).getText();
            String expectedIcerik = "Samsung A71";

            Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

        }


    }

