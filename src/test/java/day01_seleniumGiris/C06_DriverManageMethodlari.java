package day01_seleniumGiris;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C06_DriverManageMethodlari {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/selenium/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        System.out.println("maximize size : "+driver.manage().window().getSize());
        System.out.println("maximize pozision: "+ driver.manage().window().getPosition());
       driver.manage().window().fullscreen();
        System.out.println("fullscreen size : "+driver.manage().window().getSize());
        System.out.println("fullscreen pozision: "+ driver.manage().window().getPosition());



    }
}
