package random;

import java.util.Random;

public class RandomCriteriaData {
    private static final Integer[] sales = {200, 340, 1200, 3400, 100000, 12000, 5670, 16785, 967};
    private static final Float[] ratings = {3.0f, 4.6f, 5.0f, 3.5f, 3.6f, 2.4f, 5.0f, 4.5f, 3.5f};
    private static final Integer[] downloads = {100000, 23000, 4500, 12500, 6700, 7800, 450000, 3450, 235000};

    private Random randomSales;
    private Random randomRating;
    private Random randomDownloads;

    public RandomCriteriaData() {
        randomSales = new Random();
        randomRating = new Random();
        randomDownloads = new Random();
    }

    public Integer getSales() {
        return sales[randomSales.nextInt(sales.length)];
    }

    public Float getRating() {
        return ratings[randomRating.nextInt(ratings.length)];
    }

    public Integer getDownloads() {
        return downloads[randomDownloads.nextInt(downloads.length)];
    }
}
