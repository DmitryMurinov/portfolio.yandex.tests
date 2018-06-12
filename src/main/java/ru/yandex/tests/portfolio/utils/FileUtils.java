package ru.yandex.tests.portfolio.utils;

import java.io.File;

public class FileUtils {

    public static String getProjectPath(){
        return new File("").getAbsolutePath();
    }

}
