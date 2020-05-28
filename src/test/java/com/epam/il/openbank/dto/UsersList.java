package com.epam.il.openbank.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Presenting information that will be retrieved on request to resource 'https://reqres.in' at the '/api/users'
 * endpoint by the GET method using the existing page parameter. Request example, '/api/users?page=2'.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UsersList {

    private int page;
    private int perPage;
    private int total;
    private int totalPages;
    private List<UserInfo> data;
    private Ad ad;

    public int getPage() {
        return page;
    }

    public int getPerPage() {
        return perPage;
    }

    public int getTotal() {
        return total;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public List<UserInfo> getData() {
        return data;
    }

    public Ad getAd() {
        return ad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        UsersList usersList = (UsersList) o;

        if (page != usersList.page)
            return false;
        if (perPage != usersList.perPage)
            return false;
        if (total != usersList.total)
            return false;
        if (totalPages != usersList.totalPages)
            return false;
        if (!data.equals(usersList.data))
            return false;
        return ad.equals(usersList.ad);
    }

    @Override
    public int hashCode() {
        int result = page;
        result = 31 * result + perPage;
        result = 31 * result + total;
        result = 31 * result + totalPages;
        result = 31 * result + data.hashCode();
        result = 31 * result + ad.hashCode();
        return result;
    }

    public boolean areAllFieldsNotNull() {
        boolean areReferenceTypesNotNull = Stream.of(page, perPage, total, totalPages).noneMatch(Objects::isNull);
        boolean arePrimitiveTypesNotZero = Stream.of(page, perPage, total, totalPages).anyMatch(field -> field != 0);
        return areReferenceTypesNotNull && arePrimitiveTypesNotZero;
    }
}
