package model;

public class Language {
    private String sISOCode;
    private String sName;

    public String getsISOCode() {
        return sISOCode;
    }

    public void setsISOCode(String sISOCode) {
        this.sISOCode = sISOCode;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    @Override
    public String toString() {
        return "Language{" +
                "sISOCode='" + sISOCode + '\'' +
                ", sName='" + sName + '\'' +
                '}';
    }
}
