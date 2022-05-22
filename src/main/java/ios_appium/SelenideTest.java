package ios_appium;

import static com.codeborne.selenide.Selenide.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

public class SelenideTest {
    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver");
        Configuration.browser = WebDriverRunner.CHROME;
    }

    @Test
    public void qiitaOpenTest() {
        // Qiitaを表示
        open("https://qiita.com");
        // 検索
        SelenideElement searchInput = $(".st-Header_searchInput");
        searchInput.sendKeys("Selenide");
        searchInput.pressEnter();
    }
}
