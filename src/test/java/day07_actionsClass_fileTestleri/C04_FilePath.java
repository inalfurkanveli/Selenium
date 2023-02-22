package day07_actionsClass_fileTestleri;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FilePath {

    @Test
    public void test01(){
        // "C:\Users\FURKAN\Desktop\TheDelta.docx"

        String dosyaYolu= "C:\\Users\\FURKAN\\Desktop\\TheDelta.docx";

        boolean sonuc = Files.exists(Paths.get(dosyaYolu));

        System.out.println(sonuc);

        /*
        Bilgisarayimizda bir dosyanin var oldugunu test etmek icin dosya
        yoluna ihtiyacimiz var

        Ancak herkesin bilgisarayindaki dosya yollari farkliliklar gosterir

        herkesin bilgisarayina gore farklilik olan kismi
        java'dan bir komut ile elde edebilriz
         */

        System.out.println(System.getProperty("user.home"));

        dosyaYolu=System.getProperty("user.home") + "\\Desktop\\TheDelta.docx";

        System.out.println(System.getProperty("user.dir"));
    }
}
