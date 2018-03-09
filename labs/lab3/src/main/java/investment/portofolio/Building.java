/**
 * @author Birsan Ioana (cas. Amariei) B5
 * @author Gensthaler Octavian B5
 */

package investment.portofolio;

import investment.portofolio.asset.Asset;
import investment.portofolio.item.Item;


public class Building extends Item implements Asset {
    private int area;

    /**
     * Constructor with arguments
     *
     * @param name  a string representing the name
     * @param area  a numerical value representing the area
     * @param price a numerical value representing the price
     */
    public Building(String name, int area, int price) {
        super(name, price);
        this.area = area;
    }

    @Override
    public String toString() {
        return "Building{" + super.toString() + ", " +
                "area=" + area + ", " +
                "profit=" + computeProfit() +
                '}';
    }

    @Override
    public int computeProfit() {
        int initialProfit = area / getPrice();
        double risk = 1 - riskFactor();

        return (int) (initialProfit * risk);
    }

    @Override
    public double riskFactor() {
        return 0.3;
    }
}


