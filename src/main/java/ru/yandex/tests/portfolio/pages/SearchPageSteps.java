package ru.yandex.tests.portfolio.pages;

import io.qameta.allure.Step;
import ru.yandex.tests.portfolio.utils.SoftHamcrestAssert;
import ru.yandex.tests.portfolio.utils.WebDriverUtils;

import static org.hamcrest.Matchers.is;

public class SearchPageSteps extends SearchPage {

    @Step("Проверяем наличие строки поиска и сопутствующих ей элементов")
    public void checkSearchControl() {
        try {
            SoftHamcrestAssert sa = new SoftHamcrestAssert();
            sa.assertThat("Строка поиска не отображается", searchString.exists(), is(true));
            sa.assertThat("Лого слева от строки поиска не отображается", searchStringLeftLogo.exists(), is(true));
            //TODO в случае реального теста дополнить проверки списком из элементов, визуально находящихся вкоруг строки поиска
            sa.assertAll();
        } catch (Exception e){
            throw new IllegalStateException("Один или несколько элементов строки поиска не отображаются: " + e);
        }
    }

    @Step("Указываем данные для поиска: {inputString}")
    public void setSearchValue(String inputString) {
        try {
            searchString.sendKeys(inputString);
        } catch (Exception e){
            throw new IllegalStateException("Обнаружен дефект: " + e);
        }
    }

    @Step("Кликаем по иконке поиска")
    public void clickSearch() {
        try {
            searchButton.click();
        } catch (Exception e){
            throw new IllegalStateException("Обнаружен дефект: " + e);
        }
    }
}
