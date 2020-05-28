package com.epam.il.openbank.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    private static final Properties PROPERTIES;
    private static final String PROPERTIES_PATH = "test.properties";
    private static final String BASE_URI = "base_uri";
    private static final String API_USERS = "api_users";

    static {
        PROPERTIES = new Properties();
        try (InputStream resourceAsStream = new PropertiesLoader()
                .getClass()
                .getClassLoader()
                .getResourceAsStream(PROPERTIES_PATH)) {
            PROPERTIES.load(resourceAsStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + PROPERTIES_PATH);
        }
    }

    private PropertiesLoader() {
    }

    /**
     * Get base uri.
     *
     * @return String base uri
     */
    public static String getBaseUri() {
        return PROPERTIES.getProperty(BASE_URI);
    }

    /**
     * Get '/api/users' endpoint.
     *
     * @return String '/api/users' endpoint
     */
    public static String getApiUsersEndpoint() {
        return PROPERTIES.getProperty(API_USERS);
    }
}
