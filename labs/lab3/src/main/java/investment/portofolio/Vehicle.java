package investment.portofolio;

import investment.portofolio.asset.Asset;
import investment.portofolio.item.Item;

import java.util.Random;

/**
 * Created by AMI on 2018-03-04.
 */
public class Vehicle extends Item implements Asset {
    private int performance;

    @Override
    public String toString() {
        return "Vehicle{" + super.toString() + ", " +
                "performance=" + performance + ", " +
                "profit=" + computeProfit() +
                '}';
    }

    public Vehicle(String name, int performance, int price) {
        super(name, price);
        this.performance = performance;
    }

    @Override
    public int computeProfit() {
        int price = performance / getPrice();
        double risk = 1 - riskFactor();

        return (int) (price * risk);
    }

    @Override
    public double riskFactor(){
        return 0.7;
    }
}
