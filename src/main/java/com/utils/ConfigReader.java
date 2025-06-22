package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    public static Properties loadProperties() throws IOException {
        prop = new Properties();
        FileInputStream file = new FileInputStream("src/main/resources/config/config.properties");
        prop.load(file);
        return prop;
    }

    public static String getPropKey(String key) throws IOException {
        return loadProperties().getProperty(key);
    }
}