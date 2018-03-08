package investment.portofolio.comparators;

import investment.portofolio.asset.Asset;

import java.util.Comparator;

/**
 * Created by AMI on 2018-03-08.
 */
public class ProfitComparator implements Comparator<Asset> {
    @Override
    public int compare(Asset o1, Asset o2) {
        return o1.computeProfit() - o2.computeProfit();
    }
}
