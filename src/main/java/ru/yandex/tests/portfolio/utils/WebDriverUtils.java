package ru.yandex.tests.portfolio.utils;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {

    public static void waitUntilVisibleByXpath(String xpath){
        waitUntilVisibleByXpath(xpath, 60);
    }

    public static void waitUntilVisibleByXpath(String xpath, int timeoutSec){
        WebDriver wd = WebDriverRunner.getWebDriver();
        WebDriverWait wait = new WebDriverWait(wd, timeoutSec);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public static void waitUntilClickableByXpath(String xpath){
        waitUntilVisibleByXpath(xpath, 60);
    }

    public static void waitUntilClickableByXpath(String xpath, int timeoutSec){
        WebDriver wd = WebDriverRunner.getWebDriver();
        WebDriverWait wait = new WebDriverWait(wd, timeoutSec);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }



}
