package ios_appium;

import static com.codeborne.selenide.Selenide.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

public class SelenideTest {
	 /**
     * テストの前に1度だけ実施
     */
    @BeforeClass
    public static void beforeClass() {
        // Chrome Driverのパスを指定
        System.setProperty("webdriver.chrome.driver", "./chromedriver");
        // Chromeを指定
        Configuration.browser = WebDriverRunner.CHROME;
    }

    @Test
    public void qiitaOpenTest() {
        // Qiitaを表示
        open("https://qiita.com");

        // Selenideで検索
        SelenideElement searchInput = $(".st-Header_searchInput");
        searchInput.sendKeys("Selenide");
        searchInput.pressEnter();
    }
}
