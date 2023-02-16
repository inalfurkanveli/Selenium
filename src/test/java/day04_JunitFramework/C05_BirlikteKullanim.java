package day04_JunitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C05_BirlikteKullanim {

    static WebDriver driver;
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before class calisti \n============");

    }
    @AfterClass
    public static void afterClass(){
        System.out.println("==========\n After Class calisti");
    }
    @Before
    public void before(){
        System.out.println("\n Before calisti");
    }
    @After
    public void after(){
        System.out.println("\n After Calisti");
    }

    @Test
    public void test01(){
        System.out.println("test1 calisti");
    }

    @Test
    public void test02(){
        System.out.println("test2 calisti");
    }

    @Test
    public void test03(){
        System.out.println("test3 calisti");
    }
}
