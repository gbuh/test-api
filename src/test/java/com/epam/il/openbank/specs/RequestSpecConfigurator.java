package com.epam.il.openbank.specs;

import com.epam.il.openbank.util.PropertiesLoader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

/**
 * Request Specification Configurator.
 */
public class RequestSpecConfigurator {

    private RequestSpecConfigurator() {
    }

    /**
     * Get a base RequestSpecification.
     *
     * @param parameters for path configure
     * @return RequestSpecification object
     */
    public static RequestSpecification getBaseRequestSpecification(String parameters) {
        return new RequestSpecBuilder()
                .setBaseUri(PropertiesLoader.getBaseUri())
                .setContentType(ContentType.JSON)
                .setBasePath(parameters)
                .build();
    }
}
