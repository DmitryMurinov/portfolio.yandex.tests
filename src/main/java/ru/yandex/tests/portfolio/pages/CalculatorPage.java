package ru.yandex.tests.portfolio.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CalculatorPage {

    String calculatorWindowsXpath = "//div[@class='calculator__wrapper']";
    SelenideElement expectedResultValue = $(By.xpath(calculatorWindowsXpath + "//span[@class='calculator-display__result']"));


}
