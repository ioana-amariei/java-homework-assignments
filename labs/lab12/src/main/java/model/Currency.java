package model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Currency {
    @JsonProperty("sISOCode")
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
        return "Currency{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
