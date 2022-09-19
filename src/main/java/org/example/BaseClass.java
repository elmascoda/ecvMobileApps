package org.example;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseClass extends ExtentReportsDemo {
    static AndroidDriver<MobileElement> androidDriver;
    static String REPORT_PATH;

    public BaseClass() {
    }

    public static AndroidDriver<MobileElement> desiredCaps() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("VERSION", "12");
        capabilities.setCapability("deviceName", "SM - A525F");
        capabilities.setCapability("udid", "R68T303G0MM");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.allandroidprojects.getirsample");
        capabilities.setCapability("appActivity", "com.allandroidprojects.getirsample.startup.SplashActivity");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("automationName", "UiAutomator2");
        AndroidDriver<MobileElement> androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        androidDriver.manage().timeouts().implicitlyWait(10000L, TimeUnit.MILLISECONDS);
        return androidDriver;
    }

    public static void loadReportPATH() throws Exception {
        String fileName = "src/test/resources/app.properties";
        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream(fileName));
            REPORT_PATH = prop.getProperty("REPORT_PATH");
        } catch (IOException var3) {
            System.exit(1);
        }

    }

    public static String capture(WebDriver driver) throws IOException {
        File scrFile = (File)((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File Dest = new File("/ErrImages/" + System.currentTimeMillis() + ".png");
        String errflpath = Dest.getAbsolutePath().replace("/C:", "C:/");
        FileUtils.copyFile(scrFile, Dest);
        return errflpath;
    }
}
