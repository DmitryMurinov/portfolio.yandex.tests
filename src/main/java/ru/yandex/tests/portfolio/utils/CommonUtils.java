package ru.yandex.tests.portfolio.utils;

public class CommonUtils {

    public static void sleep(int sec){
        try {
            Thread.sleep(1000 * sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
