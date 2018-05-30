package controller;

import config.GetRequest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountryController {
    private String allCountriesInfo = "/websamples.countryinfo/CountryInfoService.wso/FullCountryInfoAllCountries/JSON/debug";
    private String countryInfoByCode = "/websamples.countryinfo/CountryInfoService.wso/FullCountryInfo/JSON/debug?sCountryISOCode=";
    private String countryCurrencyByCode = "/websamples.countryinfo/CountryInfoService.wso/CountryCurrency/JSON/debug?sCountryISOCode=";
    private  String capitalCityByCountryCode = "/websamples.countryinfo/CountryInfoService.wso/CapitalCity/JSON/debug?sCountryISOCode=";

    private GetRequest getRequest;

    public CountryController(GetRequest request) {
        this.getRequest = request;
    }

    public void saveCountries() {
        getRequest.get(allCountriesInfo, "countries.json");
    }

    public void saveCountry(String countryCode){
        getRequest.get(countryInfoByCode + countryCode, "countryByCode.json");
    }

    public String saveCapitalCity(String countryCode) throws IOException {
        String path = "capitalCity.txt";
        String capitalCity;

        getRequest.get(capitalCityByCountryCode + countryCode, path);

        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        return (capitalCity = bufferedReader.readLine()) != null ? capitalCity : null;
    }

    public void saveCurrency(String countryCode){
        getRequest.get(countryCurrencyByCode + countryCode, "currencyByCode.json");
    }
}
