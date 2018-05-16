package random;

import java.util.Random;

public class RandomArtistData {
    private static final String[] names = {"Mary Ramsey",
                                            "Jake Holmes",
                                            "Iron & Wine",
                                            "Frankie Valli",
                                            "Chun Myung-hoon",
                                            "Deitiphobia",
                                            "Gilme",
                                            "KittiB",
                                            "Luis Alberto Spinetta",
                                            "Simon and Garfunkel",
                                            "Madalina Manole",
                                            "ABA",
                                            "Modern talking",
                                            "Scorpions",
                                            "Yiruma"};

    private static final String[] countries = {"South Korea",
                                                "United States",
                                                "Great Britain",
                                                "Norway",
                                                "Sweeden",
                                                "France",
                                                "South Africa",
                                                "Australia",
                                                "Canada",
                                                "Ukraine",
                                                "Netherlands",
                                                "Denmark",
                                                "Italy",
                                                "Romania"};
    private Random randomNames;
    private Random randomCountries;

    public RandomArtistData() {
        randomNames = new Random();
        randomCountries = new Random();
    }

    public String getRandomName() {
        return names[randomNames.nextInt(names.length)];
    }

    public String getRandomCountry() {
        return countries[randomCountries.nextInt(countries.length)];
    }

}
