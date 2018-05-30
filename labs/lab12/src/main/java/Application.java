import view.ContinentView;
import view.CountryView;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        ContinentView continentView = new ContinentView();
        CountryView countryView = new CountryView();
        String countryCode = "RO";

        countryView.displayCountries();
        System.out.println(' ');

        countryView.displayCountryInfo(countryCode);
        System.out.println(' ');

        countryView.displayCapitalCity(countryCode);
        System.out.println(' ');

        countryView.displayCurrency(countryCode);
        System.out.println(' ');

        continentView.displayAllContinents();
    }

}
