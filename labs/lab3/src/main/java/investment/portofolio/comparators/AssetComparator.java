/**
 * @author Birsan Ioana (cas. Amariei) B5
 * @author Gensthaler Octavian B5
 */

package investment.portofolio.comparators;

import investment.portofolio.asset.Asset;
import java.util.Comparator;


public class AssetComparator implements Comparator<Asset> {
    @Override
    public int compare(Asset o1, Asset o2) {
        return o1.computeProfit() - o2.computeProfit();
    }
}
