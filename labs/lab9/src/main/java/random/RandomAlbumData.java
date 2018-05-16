package random;

import java.util.Random;

public class RandomAlbumData {
    private static final String[] names = {"Everybody Knows This Is Nowhere",
                                            "Hand Sown ... Home Grown",
                                            "Last Time Around",
                                            "Stage Fright",
                                            "New Morning",
                                            "Back in Memphis",
                                            "American Beauty",
                                            "Seven Bridges Road",
                                            "Stories We Could Tell",
                                            "A Good Feelin’ To Know",
                                            "Wonderfull",
                                            "Fantasy",
                                            "In the sunset",
                                            "Phenomenal",
                                            "New world",
                                            "Money speaking"};

    private static  final Integer[] releaseYear = {1968, 1970, 2017, 2013, 2009, 2013, 1967, 1997, 2005, 2000, 1997};
    private Random randomNames;
    private Random randomYears;

    public RandomAlbumData() {
        randomNames = new Random();
        randomYears = new Random();
    }

    public String getRandomName() {
        return names[randomNames.nextInt(names.length)];
    }

    public Integer getRandomYear() {
        return releaseYear[randomYears.nextInt(releaseYear.length)];
    }
}
