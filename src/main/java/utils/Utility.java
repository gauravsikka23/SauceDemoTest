package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {
    public static void captureScreenshot(WebDriver driver, String name) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        File dest = new File("screenshots/" + name + "_" + timestamp + ".png");
        try {
            FileUtils.copyFile(src, dest);
            System.out.println("Screenshot saved at: " + dest.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}
