package ru.yandex.tests.portfolio.pages;

import io.qameta.allure.Step;
import ru.yandex.tests.portfolio.utils.CommonUtils;
import ru.yandex.tests.portfolio.utils.WebDriverUtils;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CalculatorPageSteps extends CalculatorPage {

    @Step("Дожидаемся загрузки калькулятора и отображения результата")
    public void waitUntilCalculatorVisible() {
        try {
            WebDriverUtils.waitUntilVisibleByXpath(calculatorWindowsXpath);
            CommonUtils.sleep(2);
        } catch (Exception e) {
            throw new IllegalStateException("Обнаружен дефект: " + e);
        }
    }

    @Step("Проверяем результат, выведенный наверху калькулятора")
    public void checkResultUpRow(String expectedResult) {
        try {
            assertThat("Значение не соответствует ожидаемому: ", expectedResultValue.getText(), is(expectedResult));
        } catch (Exception e) {
            throw new IllegalStateException("Обнаружен дефект: " + e);
        }
    }

}
