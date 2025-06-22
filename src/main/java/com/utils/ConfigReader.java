package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    
    static Properties prop=new Properties();
    
    public void loadProperty(){

        try {
            FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\config\\config.properties");
            prop.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getPropKey(String key){
        return prop.getProperty(key);
    }
}
