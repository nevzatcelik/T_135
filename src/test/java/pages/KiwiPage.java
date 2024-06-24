package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import javax.annotation.processing.Generated;

public class KiwiPage {
    public KiwiPage(){
        PageFactory.initElements((WebDriver)Driver.getAndroidDriver(),this);
    }

    @FindBy(xpath = "//*[@text='Continue as a guest']")
    public WebElement continueAsButton;
    @FindBy(xpath = "//*[@text='Return']")
    public WebElement returnButton;
    @FindBy(xpath = "//*[@class='android.widget.EditText']")
    public WebElement kalkisEditText;
}
