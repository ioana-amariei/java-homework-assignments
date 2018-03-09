/**
 * @author Birsan Ioana (cas. Amariei) B5
 * @author Gensthaler Octavian B5
 */

package investment.portofolio.item;

public abstract class Item {
    private String name;
    private int price;

    /**
     * Constructor with arguments
     *
     * @param name  a string representing the name
     * @param price a numerical value representing the price
     */
    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        Item item = (Item) o;

        if (price != item.price) return false;
        return name.equals(item.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", price=" + price;
    }

    public String getName() {
        return name;
    }

    /**
     * Sets the name
     *
     * @param name a string representing the name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the price
     *
     * @return the price of the Item
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price
     *
     * @param price the price to be set
     */
    public void setPrice(int price) {

        this.price = price;
    }
}
