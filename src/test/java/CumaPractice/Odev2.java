package CumaPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev2  {
static WebDriver driver;
@BeforeClass
    public static void setup(){
    WebDriverManager.chromedriver().setup();
    driver= new ChromeDriver();




}
@AfterClass
public static void teardown(){
    driver.close();

}
@Before
public void beforeTest01(){
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
}

@Test
    public void test01(){
    //https://testpages.herokuapp.com/styled/index.html adresine gidin
    driver.get("https://testpages.herokuapp.com/styled/index.html");
    //Mikro Uygulamalar altında Hesaplayıcı'ya tıklayın
    driver.findElement(By.id("calculatetest")).click();
    //İlk girişte herhangi bir sayı yazın
    WebElement number1Box= driver.findElement(By.xpath("//input[@id='number1']"));
    number1Box.sendKeys("15");
    //İkinci girişe herhangi bir sayı yazın
    WebElement number2Box= driver.findElement(By.xpath("//input[@id='number2']"));
    number2Box.sendKeys("165");
    //Hesapla'ya tıklayın
    driver.findElement(By.id("calculate")).click();
    //sonucu al
    System.out.println(driver.findElement(By.id("answer")).getText());
    //sonucu yazdır


}
@After
    public void afterTest01(){
    System.out.println("TEST FINISH.");
}


}
