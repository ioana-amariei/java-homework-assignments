package model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {
    @JsonProperty("sISOCode")
    private String code;
    @JsonProperty("sName")
    private String name;
    @JsonProperty("sCapitalCity")
    private String capitalCity;
    @JsonProperty("sPhoneCode")
    private String phoneCode;
    @JsonProperty("sContinentCode")
    private String continentCode;
    @JsonProperty("sCurrencyISOCode")
    private String currencyCode;
    @JsonProperty("sCountryFlag")
    private String countryFlag;
    @JsonProperty("Languages")
    private List<Language> languages;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getContinentCode() {
        return continentCode;
    }

    public void setContinentCode(String continentCode) {
        this.continentCode = continentCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCountryFlag() {
        return countryFlag;
    }

    public void setCountryFlag(String countryFlag) {
        this.countryFlag = countryFlag;
    }

    public List <Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List <Language> languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", capitalCity='" + capitalCity + '\'' +
                ", phoneCode='" + phoneCode + '\'' +
                ", continentCode='" + continentCode + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                ", countryFlag='" + countryFlag + '\'' +
                ", languages=" + languages +
                '}';
    }
}

