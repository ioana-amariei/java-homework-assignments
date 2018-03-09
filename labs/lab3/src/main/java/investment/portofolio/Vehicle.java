/**
 * @author Birsan Ioana (cas. Amariei) B5
 * @author Gensthaler Octavian B5
 */

package investment.portofolio;

import investment.portofolio.asset.Asset;
import investment.portofolio.item.Item;


public class Vehicle extends Item implements Asset {
    private int performance;

    /**
     * Constructor with arguments
     * @param name a string representing the name
     * @param performance a numerical value representing the performance
     * @param price a numerical value representing the price
     */
    public Vehicle(String name, int performance, int price) {
        super(name, price);
        this.performance = performance;
    }

    @Override
    public String toString() {
        return "Vehicle{" + super.toString() + ", " +
                "performance=" + performance + ", " +
                "profit=" + computeProfit() +
                '}';
    }

    @Override
    public int computeProfit() {
        int initialProfit = performance / getPrice();
        double risk = 1 - riskFactor();

        return (int) (initialProfit * risk);
    }

    @Override
    public double riskFactor() {
        return 0.7;
    }
}
