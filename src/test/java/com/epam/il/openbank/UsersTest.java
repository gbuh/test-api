package com.epam.il.openbank;

import com.epam.il.openbank.specs.RequestSpecConfigurator;
import com.epam.il.openbank.dto.User;
import com.epam.il.openbank.dto.UsersList;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

/**
 * Test class for '/api/users' endpoint.
 */
public class UsersTest extends BaseTest {
    @Test(groups = "Smoke",
          description = "As a User, when I send a request with the GET method, then I should get an object that does"
                  + " not have nullable fields")
    public void verifyThatReceivedObjectDoesNotHaveNullableFields() {
        String pathWithParameters = apiUsers.concat("?{page}");
        RequestSpecification requestSpecification = RequestSpecConfigurator
                .getBaseRequestSpecification(pathWithParameters);
        UsersList usersList = getUsersListWithParameters(requestSpecification, "page", 2);
        assertTrue(usersList.areAllFieldsNotNull(), "All user list fields should be non-null (not zero).");
    }

    @Test(groups = "Smoke",
            description = "As a User, when I create a new one with the POST method, then I should get an object that"
                    + " has the same values as in the request.")
    public void verifyThatObjectWithCreatedUserHasTheSameValuesAsInTheRequest() {
        RequestSpecification requestSpecification = RequestSpecConfigurator
                .getBaseRequestSpecification(apiUsers);
        User expectedUser = new User();
        expectedUser.setName("morpheus");
        expectedUser.setJob("leader");
        User newUser = getNewlyCreatedUser(requestSpecification, expectedUser);
        assertTrue(expectedUser.getName().equals(newUser.getName()) && expectedUser.getJob().equals(newUser.getJob()),
                   "The name and job of the created user should have the same values as in the request ");
    }

    private UsersList getUsersListWithParameters(RequestSpecification requestSpecification, String parameterName,
            Object parameterValue) {
        return given()
                .spec(requestSpecification)
                .pathParam(parameterName, parameterValue)
                .when()
                .get()
                .then()
                .extract()
                .body()
                .as(UsersList.class);
    }

    private User getNewlyCreatedUser(RequestSpecification requestSpecification, User requestBody) {
        return given()
                .spec(requestSpecification)
                .body(requestBody)
                .when()
                .post()
                .then()
                .extract()
                .body()
                .as(User.class);
    }
}
