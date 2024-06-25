package tests.day4;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllCurrencyConventerPage;
import utils.Driver;
import utils.ReusableMethods;

import java.io.File;
import java.io.IOException;

public class AllCurrencyConventer {
    AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();
    AllCurrencyConventerPage page=new AllCurrencyConventerPage();

    @Test
    public void allCurrencyTest() throws InterruptedException, IOException {
        // all currency uygulamasinin yuklendigi dogulanir
        Assert.assertTrue(driver.isAppInstalled("com.smartwho.SmartAllCurrencyConverter"));
        // uygulamanin acildigi dogrulanir
        Assert.assertTrue(driver.findElementByXPath("//*[@text='CURRENCY CONVERTER']").isDisplayed());
        // cevirmek istedigimiz para birimi zloty olarak secilir
        ReusableMethods.tiklamaMethodu(438,340,500);
        ReusableMethods.scrollWithUiScrollableAndClick("PLN");
       // cevirelecek olan para birimi Tl olarak secilir
        ReusableMethods.tiklamaMethodu(431,482,500);
        ReusableMethods.scrollWithUiScrollableAndClick("Turkish Lira");
        page.dort.click();
        page.iki.click();
        for (int i = 0; i < 2; i++) {
            page.sifir.click();
        }
      // cevrilen tutar screenShot olarak kaydedilir
          /*
         File screenshot=driver.getScreenshotAs(OutputType.FILE);
         FileUtils.copyFile(screenshot,new File("screenshot.jpg"));

         Bu locate alma yontemi en basit olan ve dinamik olamayan yontemdir.
         ekran goruntusunu alarak oldugu gibi projenin icerisine ekler
         */
        ReusableMethods.getScreenshot("sonucShot");
      // Ardindan zloty nin tl karsiligi olan tl degeri kaydedilir
        String sonuc=page.sonucText.getText();
       // kullaniciya sms olarak bildirilir
        driver.sendSMS("444444444444","cevirmek istediginiz tutar = " + sonuc);
    }
}
