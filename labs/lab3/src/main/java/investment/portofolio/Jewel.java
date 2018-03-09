/**
 * @author Birsan Ioana (cas. Amariei) B5
 * @author Gensthaler Octavian B5
 */

package investment.portofolio;

import investment.portofolio.item.Item;


public class Jewel extends Item {
    /**
     * Constructor with arguments
     *
     * @param name  a string representing the name
     * @param price a numerical value representing the price
     */
    public Jewel(String name, int price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "Jewel{" + super.toString() + "}";
    }
}
