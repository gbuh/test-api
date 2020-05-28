package com.epam.il.openbank.requests;

import com.epam.il.openbank.dto.User;
import com.epam.il.openbank.dto.UsersList;
import com.epam.il.openbank.util.PropertiesLoader;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

/**
 * This class receives data from the '/api/users' endpoint.
 */
public class UserRequests {
    private static final String API_USERS_ENDPOINT = PropertiesLoader.getApiUsersEndpoint();

    /**
     * This method receives Users list from resource.
     *
     * @param pageNumber additional parameter with page number
     * @return UserList object
     */
    public UsersList getUsersListFromPage(int pageNumber) {
        return getResponseFromUsersPage(pageNumber)
                .then()
                .extract()
                .body()
                .as(UsersList.class);
    }

    /**
     * This method receives User from resource.
     *
     * @param user newly created User
     * @return User object
     */
    public User getNewlyCreatedUser(User user) {
        return postUser(user)
                .then()
                .extract()
                .body()
                .as(User.class);
    }

    private Response getResponseFromUsersPage(int pageNumber) {
        return given()
                .spec(RequestSpecConfigurator.getBaseRequestSpecification(API_USERS_ENDPOINT.concat("?{page}")))
                .pathParam("page", pageNumber)
                .when()
                .get();
    }

    private static Response postUser(User user) {
        return given()
                .spec(RequestSpecConfigurator.getBaseRequestSpecification(API_USERS_ENDPOINT))
                .body(user)
                .when()
                .post();
    }
}
