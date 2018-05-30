package view;

import config.GetRequest;
import controller.CountryController;
import deserializer.JsonDeserializer;
import model.Country;

import java.io.IOException;
import java.util.List;

public class CountryView {
    private static JsonDeserializer jsonDeserializer = new JsonDeserializer();
    private static GetRequest getRequest = new GetRequest();
    private static CountryController countryController = new CountryController(getRequest);

    public void displayCountryInfo(String countryCode) throws IOException {
        countryController.saveCountry(countryCode);

        System.out.println("All the stored country information about country with code: " + countryCode);
        Country country = jsonDeserializer.country();
        System.out.println("Code: " + country.getCode());
        System.out.println("Name: " + country.getName());
        System.out.println("Capital city: " + country.getCapitalCity());
        System.out.println("Phone code: " + country.getPhoneCode());
        System.out.println("Continent code: " + country.getContinentCode());
        System.out.println("Currency code: " + country.getCurrencyCode());
        System.out.println("Flag link: " + country.getCountryFlag());
    }

    public void displayCountries() throws IOException {
        countryController.saveCountries();

        List <Country> countries = jsonDeserializer.countries();

        for (Country country : countries) {
            System.out.println(country);
            System.out.println(' ');
        }
    }

    public void displayCurrency(String countryCode) throws IOException {
        countryController.saveCurrency(countryCode);

        System.out.println("Currency info for country with code: " +
                countryCode + " is \n" +
                jsonDeserializer.currency());
    }

    public void displayCapitalCity(String countryCode) throws IOException {
        System.out.println("Capital city for country with country code: " +
                countryCode + " is " +
                countryController.saveCapitalCity(countryCode));
    }
}
