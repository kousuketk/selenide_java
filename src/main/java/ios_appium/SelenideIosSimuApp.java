package ios_appium;

import static com.codeborne.selenide.Selenide.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverProvider;

import io.appium.java_client.ios.IOSDriver;

public class SelenideIosSimuApp {
	@BeforeClass
    public static void beforeClass() {
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 3000;
        Configuration.browser = SimulatorAppDriverProvider.class.getName();
    }

    @Test
    public void inputTest() {
        // アプリを起動
        open();
        // textFieldに入力
        SelenideElement userNameInput = $(By.className("XCUIElementTypeTextField"));
        userNameInput.click();
        userNameInput.sendKeys("sample input by selenide");
        sleep(3000);
    }
}

class SimulatorAppDriverProvider implements WebDriverProvider {
    @SuppressWarnings("rawtypes")
    public WebDriver createDriver(DesiredCapabilities capabilities) {
    	capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("deviceName", "iPhone 13");
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "15.2");
        capabilities.setCapability("bundleId", "jp.classswift.sampleSwift");
        try {
            return new IOSDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}