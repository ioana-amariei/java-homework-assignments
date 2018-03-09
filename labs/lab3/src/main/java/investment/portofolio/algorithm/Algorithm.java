/**
 * @author Birsan Ioana (cas. Amariei) B5
 * @author Gensthaler Octavian B5
 */

package investment.portofolio.algorithm;

import investment.portofolio.asset.Asset;
import java.util.List;

public interface Algorithm {
    /**
     * Orders assets according to strategy:
     * @param assets the list of assets to be ordered
     */
    void orderAssetsAccordingToStrategy(List <Asset> assets);
}
