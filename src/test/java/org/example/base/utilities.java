package org.example.base;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class utilities {
    @Test
    public Properties readproperties(){
Properties properties=null;
        try {
            FileReader fileReader=new FileReader(System.getProperty("user.dir")+"//src//test///resources//application.properties");
            properties=new Properties();
            properties.load(fileReader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

}
