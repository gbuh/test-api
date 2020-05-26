package com.epam.il.openbank.dto;

public class UserInfo {

    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
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
        if (!first_name.equals(userInfo.first_name))
            return false;
        if (!last_name.equals(userInfo.last_name))
            return false;
        return avatar.equals(userInfo.avatar);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + email.hashCode();
        result = 31 * result + first_name.hashCode();
        result = 31 * result + last_name.hashCode();
        result = 31 * result + avatar.hashCode();
        return result;
    }
}
