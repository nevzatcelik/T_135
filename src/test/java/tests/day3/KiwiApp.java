package tests.day3;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KiwiPage;
import utils.ConfigReader;
import utils.Driver;
import utils.ReusableMethods;

public class KiwiApp {
         AndroidDriver<AndroidElement> driver=Driver.getAndroidDriver();
         KiwiPage page=new KiwiPage();

    @Test
    public void kiwiTest() throws InterruptedException {
        // uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled(ConfigReader.getProperty("kiwiAppPackage")));
// uygulamanin basariyla acildigi dogrulanir
        Assert.assertTrue(driver.findElementByXPath("//*[@text='Continue as a guest']").isDisplayed());
// misafir olarak devam et e tiklanir
        page.continueAsButton.click();
        Thread.sleep(1500);
// ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
     // 555 2048
        TouchAction action=new TouchAction<>(Driver.getAndroidDriver());
        for (int i = 0; i<3 ; i++) {
            ReusableMethods.tiklamaMethodu(537,1695,1000);
            // 980,252
        }
        Thread.sleep(3000);

// Trip type,one way olarak secilir
       // page.returnButton.click();
        ReusableMethods.tiklamaMethodu(296,621,500);
        ReusableMethods.tiklamaMethodu(519,1461,500);
// kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        ReusableMethods.tiklamaMethodu(464,774,500);
        ReusableMethods.tiklamaMethodu(1019,139,500);
// kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        if (driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("istanbul");
        }
        else {
            page.kalkisEditText.sendKeys("Samsun");
        }
        Thread.sleep(1000);
        page.kalkisVarisSehriButton.click();
        page.chooseButton.click();

// varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        ReusableMethods.tiklamaMethodu(376,921,500);
        driver.getKeyboard().pressKey("London");
        page.kalkisVarisSehriButton.click();
        page.chooseButton.click();
// gidis tarihi haziran ayinin 21 i olarak secilir ve set date e tiklanir
        ReusableMethods.tiklamaMethodu(482,1052,1000);
        ReusableMethods.tiklamaMethodu(541,1337,1000);
        page.setDateButton.click();
// search butonuna tiklanir
        page.searchButton.click();
// en  ucuz ve aktarmasiz filtrelemeleri yapilir
        page.bestButton.click();
        page.cheapestButton.click();
        page.stopsButton.click();
        page.nonStopsButton.click();
// gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir
        Thread.sleep(3000);
        String biletFiyati=page.enUcuzBiletFiyati.getText();
        driver.sendSMS("555555555555","Kiwi uygulamasindan gelen en ucuz bilet fiyati = "+biletFiyati);


    }
}
