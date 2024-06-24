package utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class ReusableMethods {

    public static void tiklamaMethodu(int xKoordinati,int yKoordinati,int beklemeSuresi ) throws InterruptedException {
        TouchAction action=new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(xKoordinati,yKoordinati))
                .release()
                .perform();
                 Thread.sleep(beklemeSuresi);
    }
}
