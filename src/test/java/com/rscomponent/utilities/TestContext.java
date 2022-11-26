package com.rscomponent.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestContext {

    Properties prop = new Properties();

    InputStream inputStream = null;

    private static TestContext propertyLoader = new TestContext();


    public TestContext(){
        loadprop();
    }

    public void loadprop() {
        try {
            inputStream = new FileInputStream("src/test/resources/project.properties");
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String  readproperty(String key){
        return prop.getProperty(key);
    }

    public static TestContext getInstance() {
        return propertyLoader;
    }

}
