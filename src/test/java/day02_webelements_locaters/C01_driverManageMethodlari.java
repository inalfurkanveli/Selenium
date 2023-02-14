package day02_webelements_locaters;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_driverManageMethodlari {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","drivers/selenium/chromedriver.exe");

        WebDriver driver = new ChromeDriver();



        System.out.println("ilk size :"+driver.manage().window().getSize());
        System.out.println("ilk posizyon"+driver.manage().window().getPosition());
        Thread.sleep(2000);
        // olculeri ve konumu degistirelim

        // pencerenin boyutunu ayarlar
        driver.manage().window().setSize(new Dimension(800,800));
        // pencerenin konumunu ayarlar
        driver.manage().window().setPosition(new Point(45,25));





        Thread.sleep(2000);
        driver.close();

    }
}
