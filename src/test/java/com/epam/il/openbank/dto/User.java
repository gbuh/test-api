package com.epam.il.openbank.dto;

/**
 * Representation of a user registration object that will be retrieved on request to resource 'https://reqres.in' at
 * the '/api/users' endpoint by the POST method. Request example, '/api/users' using the next body
 * {
 * "name": "morpheus",
 * "job": "leader"
 * }
 */
public class User {

    private String name;
    private String job;
    private String id;
    private String createdAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        User user = (User) o;

        if (!name.equals(user.name))
            return false;
        return job.equals(user.job);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + job.hashCode();
        return result;
    }
}
