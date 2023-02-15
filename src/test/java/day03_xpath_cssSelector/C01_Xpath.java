package day03_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Xpath {
    public static void main(String[] args) {
        WebDriver driver =new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    //    1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        //     2- Add Element butonuna basin
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        //   3- Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButonElementi= driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));

        if (deleteButonElementi.isDisplayed()){
            System.out.println("delete buton testi PASSED");
        }else {
            System.out.println("delete button testi FAILED");
        }
        //   4- Delete tusuna basin
        deleteButonElementi.click();
        //    5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemoveElementi=driver.findElement(By.xpath("//h3"));
        if (addRemoveElementi.isDisplayed()){
            System.out.println("Add/Remove buton testi PASSED");
        }else {
            System.out.println("Add/Remove button testi FAILED");
        }




    }
}
