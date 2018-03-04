package investment.portofolio;

import investment.portofolio.asset.Asset;
import investment.portofolio.item.Item;

/**
 * Created by AMI on 2018-03-04.
 */
public class Building extends Item implements Asset {
   private int area;

    @Override
    public String toString() {
        return "Building{" + super.toString() + ", " +
                "area=" + area + ", " +
                "profit=" + computeProfit() +
                '}';
    }

    public Building(String name, int area, int price) {
        super(name, price);
        this.area = area;
    }

    @Override
    public int computeProfit() {
        return area / getPrice();
    }
}
