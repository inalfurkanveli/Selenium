package day04_JunitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class C03_BeforeAfter {
    WebDriver driver;
    @Before
public void setup(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.out.println("setup calisti");
    }
    @After
    public void teardown(){
        driver.close();
        System.out.println("teardown calisti");
    }

    @Test
    public void Test01(){


        driver.get("https://www.wisequarter.com");
        System.out.println("test01 calisti");
    }
    @Test
    public void Test02(){

        driver.get("https://www.wisequarter.com");

        System.out.println("test02 calisti");
    }

}
