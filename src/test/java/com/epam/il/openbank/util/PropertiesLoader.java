package com.epam.il.openbank.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    /**
     * Load data from properties file.
     *
     * @param filePath to properties
     * @return Properties object
     */
    public Properties loadPropertiesFile(final String filePath) {
        Properties properties = new Properties();
        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + filePath);
        }
        return properties;
    }
}
