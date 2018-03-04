package investment.portofolio;

import investment.portofolio.asset.Asset;
import investment.portofolio.comparators.AssetComparator;
import investment.portofolio.comparators.ItemComparator;
import investment.portofolio.item.Item;

import java.util.*;

/**
 * Created by AMI on 2018-03-04.
 */
public class AssetManager {
    private static final Comparator <Item> ITEM_COMPARATOR = new ItemComparator();
    private static final Comparator <Asset> ASSETS_COMPARATOR = new AssetComparator();
    private Set <Item> items;

    public AssetManager() {
        items = new HashSet <>();
    }

    public void add(Item... items) {
        this.items.addAll(Arrays.asList(items));
    }


    public List <Item> getItems() {
        List <Item> copy = new LinkedList <>(items);
        copy.sort(ITEM_COMPARATOR);

        return copy;
    }


    public List <Asset> getAssets() {
        List <Asset> assets = new LinkedList <>();
        for(Item item : items){
            if (item instanceof Asset){
                assets.add((Asset) item);
            }
        }
        assets.sort(ASSETS_COMPARATOR);

        return assets;

    }
}
