package com.epam.il.openbank.tests;

import com.epam.il.openbank.util.PropertiesLoader;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

/**
 * Base test class.
 */
public abstract class BaseTest {
    protected static final String API_USERS_ENDPOINT;
    protected static final ObjectMapper MAPPER;

    static {
        API_USERS_ENDPOINT = PropertiesLoader.getApiUsersEndpoint();
        MAPPER = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
    }
}
