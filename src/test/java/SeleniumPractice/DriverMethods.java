package SeleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverMethods {
    WebDriver driver;
    String https="https://www.";

  @Before
  public void setup(){
      WebDriverManager.chromedriver().setup();
      driver=new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

  }
  @After
  public void teardown(){

      driver.close();
    //  driver.quit();

  }

    @Test
    public void test01() throws InterruptedException {
    driver.get(https+"amazon.com");
    //driver.findElement(By.xpath(""));
        //driver.get("");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.navigate().to(https+"amazon.com");
        driver.navigate().back();
        driver.navigate().forward();
        Thread.sleep(2000);
        String amazonHandle= driver.getWindowHandle();
        System.out.println(driver.getWindowHandle());
        driver.navigate().refresh();
        System.out.println(driver.getWindowHandle());

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(https+"facebook.com");
        System.out.println(driver.getWindowHandles());

        driver.switchTo().window(amazonHandle);

        driver.switchTo().newWindow(WindowType.WINDOW);





    }
}
