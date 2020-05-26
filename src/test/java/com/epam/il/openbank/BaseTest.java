package com.epam.il.openbank;

import com.epam.il.openbank.util.PropertiesLoader;

import java.util.Properties;

/**
 * Base test class.
 */
public abstract class BaseTest {

 protected static String apiUsers;

        static {
            Properties properties = new PropertiesLoader().loadPropertiesFile("test.properties");
            apiUsers = properties.getProperty("api_users");
        }
}
