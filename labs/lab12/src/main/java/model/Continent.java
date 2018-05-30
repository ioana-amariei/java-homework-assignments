package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Continent {
    @JsonProperty("sCode")
    private String code;
    @JsonProperty("sName")
    private String name;

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

    @Override
    public String toString() {
        return "Continent{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
