package investment.portofolio.comparators;

import investment.portofolio.item.Item;

import java.util.Comparator;

/**
 * Created by AMI on 2018-03-04.
 */
public class ItemComparator implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
