package com.epam.il.openbank.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * Representation of information about the user.
 *
 * @see com.epam.il.openbank.dto.UsersList class.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserInfo {

    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String avatar;

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAvatar() {
        return avatar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        UserInfo userInfo = (UserInfo) o;

        if (id != userInfo.id)
            return false;
        if (!email.equals(userInfo.email))
            return false;
        if (!firstName.equals(userInfo.firstName))
            return false;
        if (!lastName.equals(userInfo.lastName))
            return false;
        return avatar.equals(userInfo.avatar);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + email.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + avatar.hashCode();
        return result;
    }
}
