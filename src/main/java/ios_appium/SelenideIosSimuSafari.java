package ios_appium;

import static com.codeborne.selenide.Selenide.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverProvider;

import io.appium.java_client.ios.IOSDriver;

public class SelenideIosSimuSafari {
	@BeforeClass
    public static void beforeClass() {
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 3000;
        Configuration.browser = SimulatorSafariDriverProvider.class.getName();
    }

    @Test
    public void qiitaOpenTest() {
        // Qiitaを表示
        open("https://qiita.com");
        // Selenideで検索
        SelenideElement searchButton = $(".st-NewHeader_searchButton");
        SelenideElement searchInput = $(".st-NewHeader_searchModalInput");
        searchButton.click();
        searchInput.sendKeys("Selenide");
        searchInput.pressEnter();
        sleep(3000);
    }
}

class SimulatorSafariDriverProvider implements WebDriverProvider {
    @SuppressWarnings("rawtypes")
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("deviceName", "iPhone 13");
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "15.2");
        capabilities.setCapability("browserName", "Safari");
        try {
            return new IOSDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}