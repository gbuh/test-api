package com.epam.il.openbank.dto;

/**
 * Representation of additional information about the company.
 *
 * @see com.epam.il.openbank.dto.UsersList class.
 */
public class Ad {

    private String company;
    private String url;
    private String text;

    public String getCompany() {
        return company;
    }

    public String getUrl() {
        return url;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Ad ad = (Ad) o;

        if (!company.equals(ad.company))
            return false;
        if (!url.equals(ad.url))
            return false;
        return text.equals(ad.text);
    }

    @Override
    public int hashCode() {
        int result = company.hashCode();
        result = 31 * result + url.hashCode();
        result = 31 * result + text.hashCode();
        return result;
    }
}
