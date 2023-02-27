package day09_excel_screenshot_jsExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C08_JavaScriptExecuterClick extends TestBase {
    @Test
    public void test01(){

        // wisequarter anasayfaya gidelim
        driver.get("https://www.wisequarter.com");
        // refresh diyerek reklami gecin
        // Java Test Otomation'a kadar insin
        driver.navigate().refresh();
        WebElement otomationElement= driver.findElement(By.xpath("(//img[@alt='Automation Engineer'])[1]"));

        bekle(2);
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();",otomationElement);
        bekle(2);
        // ve fotografa tiklasin
        jse.executeScript("arguments[0].click()",otomationElement);
        bekle(2);
        // ekrana "JUnit bitti yazdirin
        jse.executeScript("alert('JUnit Bitti')");
        bekle(2);
    }
}
