package ru.yandex.tests.portfolio.mainPageTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.tests.portfolio.TestBase;
import ru.yandex.tests.portfolio.pages.CalculatorPageSteps;
import ru.yandex.tests.portfolio.pages.SearchPageSteps;
import ru.yandex.tests.portfolio.testData.CalculatorParameters;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static ru.yandex.tests.portfolio.pages.CommonSteps.openURL;

public class SearchPagePositive extends TestBase {

    @Test
    public void checkMainAreasAvailable(){
        openURL("https://www.yandex.ru");
        SearchPageSteps searchSteps = new SearchPageSteps();
        searchSteps.checkSearchControl();
    }




}

