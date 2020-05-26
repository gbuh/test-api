package com.epam.il.openbank.dto;

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
