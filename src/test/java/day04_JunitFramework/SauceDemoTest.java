package day04_JunitFramework;

import org.asynchttpclient.util.Assertions;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SauceDemoTest {
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
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
        //1. “https://www.saucedemo.com” Adresine gidin
        //2. Username kutusuna “standard_user” yazdirin
        //3. Password kutusuna “secret_sauce” yazdirin
        driver.get("https://www.saucedemo.com");
        WebElement usernameBox= driver.findElement(By.id("user-name"));
        usernameBox.sendKeys("problem_user"+ Keys.TAB);
        WebElement passwordBox= driver.findElement(By.id("password"));
        passwordBox.sendKeys("secret_sauce");

    }

    @Test
    public void test02(){
        //4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
       WebElement ilkUrunISmi= driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        String urunIsmi=ilkUrunISmi.getText();
        ilkUrunISmi.click();
        WebElement urunIsmiSayfa= driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']"));
        urunIsmiSayfa.click();

    }
@Test
    public void  test03(){
    //6. Add to Cart butonuna basin
    driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
    //7. Alisveris sepetine tiklayin
   WebElement alisverisSepeti= driver.findElement(By.id("shopping_cart_container"));
   alisverisSepeti.click();

    //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin

    Assert.assertTrue(alisverisSepeti.isDisplayed());




}








}
