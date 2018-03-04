package investment.portofolio.item;

/**
 * Created by AMI on 2018-03-04.
 */
public abstract class Item {
    private String name;
    private int price;

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

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
