package investment.portofolio;

import investment.portofolio.item.Item;

/**
 * Created by AMI on 2018-03-04.
 */
public class Jewel extends Item {
    public Jewel(String name, int price) {
        super(name, price);
    }

    @Override
    public String toString(){
        return "Jewel{" + super.toString() + "}";
    }
}
