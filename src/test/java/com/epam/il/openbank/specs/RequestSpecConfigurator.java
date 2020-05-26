package com.epam.il.openbank.specs;

import com.epam.il.openbank.util.PropertiesLoader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Properties;

/**
 * Request Specification Configurator.
 */
public class RequestSpecConfigurator {
    private static String baseUri;

    static {
        Properties properties = new PropertiesLoader().loadPropertiesFile("test.properties");
        baseUri = properties.getProperty("base_uri");
    }

    private RequestSpecConfigurator() {
    }

    /**
     *Get a base RequestSpecification.
     *
     * @param parameters for path configure
     * @return RequestSpecification object
     */
    public static RequestSpecification getBaseRequestSpecification(String parameters) {
        return new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setContentType(ContentType.JSON)
                .setBasePath(parameters)
                .build();
    }
}
