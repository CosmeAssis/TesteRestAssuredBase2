package org.example.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class ApiConfig {
    public static final String BASE_URL = "https://petstore.swagger.io/v2";

    public static RequestSpecification getRequestPetStore() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .addHeader("Content-Type", "application/json")
                .build();
    }
}