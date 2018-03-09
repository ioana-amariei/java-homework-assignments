/**
 * @author Birsan Ioana (cas. Amariei) B5
 * @author Gensthaler Octavian B5
 */
package investment.portofolio.comparators;

import investment.portofolio.item.Item;
import java.util.Comparator;


public class ItemComparator implements Comparator <Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
