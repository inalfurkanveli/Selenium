package OrnekCalismalar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Ornek1  extends TestBase {

    @Test
    public void test01(){

        //1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        //2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();
        //3. Login kutusuna “username” yazin
        WebElement loginBox= driver.findElement(By.xpath("//input[@id='user_login']"));
        loginBox.sendKeys("username");
        //4. Password kutusuna “password.” yazin
        WebElement passwordBox= driver.findElement(By.xpath("//input[@id='user_password']"));
        passwordBox.sendKeys("password");
        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        // Alert'i gec
      //  driver.switchTo().alert().accept();


        //Anasayfaya geri donun ve 'More Services' butonuna tiklayin.
        driver.navigate().back();
        driver.findElement(By.xpath("//*[text()='More Services']")).click();

        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();


        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();
        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement ddm=driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Eurozone (euro)");
        //9. “amount” kutusuna bir sayi girin
        WebElement amountBox= driver.findElement(By.xpath("//input[@id='pc_amount']"));
        amountBox.sendKeys("200");
        //10. “US Dollars” in secilmedigini test edin
        WebElement usDolarCheckBox= driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(usDolarCheckBox.isSelected());
        //11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();
        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.xpath("//input[@id='pc_calculate_costs']")).click();
        driver.findElement(By.xpath("//input[@id='purchase_cash']")).click();
        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
        WebElement alertText= driver.findElement(By.xpath("//div[@id='alert_content']"));
        Assert.assertTrue(alertText.isDisplayed());
        //kontrol edin.
    }
}
