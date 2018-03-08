package investment.portofolio.algorithm;

import investment.portofolio.asset.Asset;
import investment.portofolio.item.Item;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by AMI on 2018-03-08.
 */
public class Portofolio {
    private List<Asset> assets;

    public Portofolio() {
        assets = new LinkedList <>();
    }

    public void addAsset(Asset asset){
        assets.add(asset);
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Selected assets: ");

        for(Asset asset : assets){
            Item item = (Item) asset;
            stringBuilder.append(item.getName());
            stringBuilder.append(", ");
        }

        return stringBuilder.toString();
    }

    public Portofolio(List<Asset> assets) {
        this.assets = new LinkedList <>(assets);
    }
}
