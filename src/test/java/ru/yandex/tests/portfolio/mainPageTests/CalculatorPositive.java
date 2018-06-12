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

public class CalculatorPositive extends TestBase {

    @DataProvider(name = "calculationsProvider")
    public Iterator<Object[]> calculatorTestData(){
        List<CalculatorParameters> calculatorParametersList = Arrays.asList(
                new CalculatorParameters("5 + 5", "10"),
                new CalculatorParameters("10 * 8", "80"),
                new CalculatorParameters("500^2", "250 000"),
                new CalculatorParameters("10^-5", "0,00001"),
                new CalculatorParameters("10^-10", "1 × 10−10")
        );
        return calculatorParametersList.stream().map((val) -> new Object[]{val}).collect(Collectors.toList()).iterator();
    }

    @Test(dataProvider = "calculationsProvider")
    public void calculatorTest(CalculatorParameters calculatorParameters){
        openURL("https://www.yandex.ru");
        SearchPageSteps searchSteps = new SearchPageSteps();
        searchSteps.setSearchValue(calculatorParameters.getInputString());
        searchSteps.clickSearch();
        CalculatorPageSteps calculatorPageSteps = new CalculatorPageSteps();
        calculatorPageSteps.waitUntilCalculatorVisible();
        calculatorPageSteps.checkResultUpRow(calculatorParameters.getExpectedResult());
    }
}
