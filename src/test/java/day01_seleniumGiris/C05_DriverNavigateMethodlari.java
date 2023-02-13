package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_DriverNavigateMethodlari {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/selenium/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        // amazona git
        driver.get("https://www.amazon.com");
        // amazondan wisequarter'a git
        driver.get("https://www.wisequarter.com");
        // wisequarter'dan amazona git
        driver.navigate().back();
        // yeniden wisequarter'a dön
        driver.navigate().forward();

        // navigate().to(), navigate().get ile aynı işlemi yapar.
        driver.navigate().to("https://www.youtube.com");
        driver.navigate().refresh();
    }
}
