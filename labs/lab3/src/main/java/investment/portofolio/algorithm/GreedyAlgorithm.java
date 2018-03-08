package investment.portofolio.algorithm;

import investment.portofolio.AssetManager;
import investment.portofolio.asset.Asset;
import investment.portofolio.comparators.ProfitComparator;

import java.util.Comparator;
import java.util.List;

/**
 * Created by AMI on 2018-03-08.
 */
public class GreedyAlgorithm implements Algorithm {
    private static final Comparator<Asset> PROFIT_COMPARATOR = new ProfitComparator();
    @Override
    public void orderAssetsAccordingToStrategy(List <Asset> assets) {
        assets.sort(PROFIT_COMPARATOR);
    }
}
