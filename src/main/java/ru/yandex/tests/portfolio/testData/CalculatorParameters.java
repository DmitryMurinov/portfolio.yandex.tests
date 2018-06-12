package ru.yandex.tests.portfolio.testData;

import lombok.Getter;

@Getter
public class CalculatorParameters {

    private String inputString = "";
    private String expectedResult = "";

    public CalculatorParameters(String inputString, String expectedResult){
        this.inputString = inputString;
        this.expectedResult = expectedResult;
    }

}
