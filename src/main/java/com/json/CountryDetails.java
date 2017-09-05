package com.json;

public class CountryDetails {

    private String count;
    private String status;
    private String code;
    private Country country[];

    public Country[] getCountry() {
        return country;
    }

    public void setCountry(Country []country) {
        this.country = country;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
