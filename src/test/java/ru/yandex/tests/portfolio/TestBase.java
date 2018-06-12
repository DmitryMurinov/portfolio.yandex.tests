package ru.yandex.tests.portfolio;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.yandex.tests.portfolio.utils.FileUtils;
import ru.yandex.tests.portfolio.utils.Helpers;

import java.net.MalformedURLException;

public class TestBase {

    Helpers helpers = new Helpers();

    @BeforeSuite
    public void suiteInit(){
        //Если бы в helpers что-нибудь было, здесь или в BeforeMethod можно было бы подключить к БД или сделать
        //ещё что-нибудь полезное
        //Задаём конфигурацию для Selenide
        Configuration.timeout = 60 * 1000;
        Configuration.collectionsTimeout = 90 * 1000;
    }

    @BeforeMethod
    public void methodInit() throws MalformedURLException {
        //Задаём конфигурацию для Selenium, создаём WebDriver и скармливаем его Selenide
        String browser = "chrome";
        if(System.getProperties().getProperty("browser") != null) browser = System.getProperties().getProperty("browser");
        if(browser.equals("chrome")) {
            Configuration.browser = browser;
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(browser);
            System.out.println(FileUtils.getProjectPath());
            System.setProperty("webdriver.chrome.driver", FileUtils.getProjectPath() + "/src/main/resources/drivers/chromedriver.exe");
            WebDriver wd = new ChromeDriver(capabilities);
            wd.manage().window().maximize();
            WebDriverRunner.setWebDriver(wd);
        } else {
            throw new IllegalStateException("Для данного браузера нужно прописать инициализацию драйвера: " + browser);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void methodClean() {
        //Закрывает окно браузера. Теоретически достаточно убить процесс, но по факту тогда окно может остаться висеть
        WebDriverRunner.getWebDriver().close();
        //Убивает процесс, если не сделать, будет висеть в системе
        WebDriverRunner.getWebDriver().quit();
    }

}
