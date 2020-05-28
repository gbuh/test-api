package com.epam.il.openbank.tests;

import com.epam.il.openbank.dto.User;
import com.epam.il.openbank.dto.UsersList;
import com.epam.il.openbank.requests.UserRequests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Test class for '/api/users' endpoint.
 */
public class ApiUsersTest extends BaseTest {
    private UserRequests request;

    @BeforeClass(alwaysRun = true)
    public void setupRequests() {
        request = new UserRequests();
    }

    @Test(groups = "Smoke",
          description = "As a User, when I send a request with the GET method, then I should get an object that does"
                  + " not have nullable fields")
    public void verifyThatReceivedObjectDoesNotHaveNullableFields() {
        UsersList usersList = request.getUsersListFromPage(2);

        assertTrue(usersList.areAllFieldsNotNull(), "All user list fields should be non-null (not zero).");
    }

    @Test(groups = {"Smoke", "Regression"},
            description = "As a User, when I create a new one with the POST method, then I should get an object that"
                    + " has the same values as in the request.")
    public void verifyThatObjectWithCreatedUserHasTheSameValuesAsInTheRequest() {
        User expectedUser = new User();
        expectedUser.setName("morpheus");
        expectedUser.setJob("leader");
        User newUser = request.getNewlyCreatedUser(expectedUser);

        assertTrue(expectedUser.getName().equals(newUser.getName()) && expectedUser.getJob().equals(newUser.getJob()),
                   "The name and job of the created user should have the same values as in the request ");
    }
}
