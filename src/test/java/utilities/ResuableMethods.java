package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ResuableMethods {
    public  static void tumSayfaScreenshot(WebDriver driver) throws IOException {
        TakesScreenshot ts= (TakesScreenshot) driver;

        LocalDateTime ldt= LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyyMMddhhmmss");
        String dinamikDosyaYolu="target/tumSayfaSs"+ ldt.format(dtf);
        // dosya yolu "target/tumSayfaSs20230227114813
        File tumSayfaSS= new File(dinamikDosyaYolu);

        File geciciDosya=ts.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciDosya,tumSayfaSS);


    }
}
