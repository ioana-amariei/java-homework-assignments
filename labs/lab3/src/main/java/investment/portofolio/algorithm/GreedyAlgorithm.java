/**
 * @author Birsan Ioana (cas. Amariei) B5
 * @author Gensthaler Octavian B5
 */

package investment.portofolio.algorithm;

import investment.portofolio.asset.Asset;
import investment.portofolio.comparators.AssetComparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class GreedyAlgorithm implements Algorithm {
    private static final Comparator <Asset> ASSET_COMPARATOR = new AssetComparator();

    /**
     * Sorts descending the specified list according to the profit.
     *
     * @param assets the list of assets to be ordered
     */
    @Override
    public void orderAssetsAccordingToStrategy(List <Asset> assets) {
        assets.sort(ASSET_COMPARATOR);
        Collections.reverse(assets);
    }
}
