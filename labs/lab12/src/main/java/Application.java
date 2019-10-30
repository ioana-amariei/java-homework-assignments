import view.ContinentView;
import view.CountryView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Application {

    public static void main(String[] args) throws IOException {
        ContinentView continentView = new ContinentView();
        CountryView countryView = new CountryView();
        String countryCode = "MD";

//        countryView.displayCountries();
//        System.out.println(' ');

        countryView.displayCountryInfo(countryCode);
        System.out.println(' ');

        countryView.displayCapitalCity(countryCode);
        System.out.println(' ');

        countryView.displayCurrency(countryCode);
        System.out.println(' ');

//        continentView.displayAllContinents();

        cleanAllFiles();
    }


    private static void cleanAllFiles() throws FileNotFoundException {
        cleanFile("capitalCity.txt");
        cleanFile("continents.json");
        cleanFile("countries.json");
        cleanFile("countryByCode.json");
        cleanFile("currencyByCode.json");
    }

    private static void cleanFile(String filename) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(filename);
        writer.print("");
        writer.close();
    }

}
