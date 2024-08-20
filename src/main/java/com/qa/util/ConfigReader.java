package com.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    static {
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("C:\\Users\\deben\\eclipse-workspace\\CucumberWithBDD2\\src\\test\\resources\\Configs\\Alliance.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}
