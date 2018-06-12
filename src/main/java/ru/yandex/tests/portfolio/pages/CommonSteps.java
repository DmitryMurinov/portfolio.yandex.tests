package ru.yandex.tests.portfolio.pages;

import com.codeborne.selenide.Selenide;

public class CommonSteps {

    public static void openURL(String url){
        Selenide.open(url);
    }

}
