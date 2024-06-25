package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class apkYukleme {
    AndroidDriver<AndroidElement> androidDriver; // Bu driver android cihazlardaki testler gerceklestirmek icin kullanilan driverdir
    //   IOSDriver<IOSElement> iosDriver; // ios platformlar uzerinde gerceklestirmek icin kullanilan driverdir.
    //   AppiumDriver<IOSElement> appiumIOSdriver; // her iki platformda kullanilir (ios,android) ayirici noktasi belirtilen element degeri
    //   AppiumDriver<AndroidElement> appiumAndroiddriver;//her iki platformda kullanilir (ios,android) ayirici noktasi belirtilen element degeri

    @Test
    public void deneme1() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\ahmet\\IdeaProjects\\T_135_Appium\\Apps\\Apk Bilgisi_2.3.4_apkcombo.com.apk");
        // Eger bir uygulama ilk defa yukleniyor ise bu capability kullanilir ve uygulama yuklenir.
        // Uygulama yuklu ise bunun yuklu olup olmadigini kontrol eder yukluyse uygulamayi acar degilse uygulamayi yukler ve acar
        /* Eger andorid bir cihaz da test yapacaksak bununla alakali bir automationName belirlememiz gerekiyor
         Belirledimiz automationName eger ki sectigimiz platformVersion 6.0 dan buyukse UiAutomator2
         Belirledimiz automationName eger ki sectigimiz platformVersion 6.0 dan kucukse UiAutomator

         */
        androidDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        androidDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
}
