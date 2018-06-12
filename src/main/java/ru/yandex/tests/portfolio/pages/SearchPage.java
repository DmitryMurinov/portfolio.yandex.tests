package ru.yandex.tests.portfolio.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

//Имеет смысл выносить в отдельные объекты общие для всех/многих страниц сайта части. Строку поиска можно увидеть много где,
//так что выносим
public class SearchPage {

    //1. Часто элементы имеют одинаковый class, id и не имеют больше ничего или некий плавающий атрибут.
    //тогда имеет смысл выстраивать путь к элементу по цепочке из DOM. И для каждого верхнеуровневого элемента прописывать
    //свой xpath. Когда под одним верхнеуровневым элементов несколько десятков других и у него меняется путь,
    //рефакторинг гораздо быстрее при кажущейся на первый взгляд громоздкой структуре PageObject'a.
    //2. В некоторых проектах имеет смысл сначала дождаться определённого элемента, а затем делать
    //что-то с ним или другими элементами. Тогда удобна эта конструкция. Также применима, если время ожидания предполагается
    // отличным от общего для проекта.
    static String searchStringXpath = "//input[contains(@class,'input__control input__input')]";
    static SelenideElement searchString = $(By.xpath(searchStringXpath));

    static SelenideElement searchStringLeftLogo = $(By.xpath("//div[@class=\"home-logo__custom\"]/img"));
    static SelenideElement searchButton = $(By.xpath("//span[text()='Найти']/.."));

}
