package com.epam.il.openbank.dto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class UsersList {

    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<UserInfo> data;
    private Ad ad;

    public int getPage() {
        return page;
    }

    public int getPer_page() {
        return per_page;
    }

    public int getTotal() {
        return total;
    }

    public int getTotal_pages() {
        return total_pages;
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
        if (per_page != usersList.per_page)
            return false;
        if (total != usersList.total)
            return false;
        if (total_pages != usersList.total_pages)
            return false;
        if (!data.equals(usersList.data))
            return false;
        return ad.equals(usersList.ad);
    }

    @Override
    public int hashCode() {
        int result = page;
        result = 31 * result + per_page;
        result = 31 * result + total;
        result = 31 * result + total_pages;
        result = 31 * result + data.hashCode();
        result = 31 * result + ad.hashCode();
        return result;
    }

    public boolean areAllFieldsNotNull() {
        boolean areReferenceTypesNotNull = Stream.of(page, per_page, total, total_pages)
                .noneMatch(Objects::isNull);
        boolean arePrimitiveTypesNotZero = Stream.of(page, per_page, total, total_pages).anyMatch(field -> field != 0);
        return areReferenceTypesNotNull && arePrimitiveTypesNotZero;
    }
}
