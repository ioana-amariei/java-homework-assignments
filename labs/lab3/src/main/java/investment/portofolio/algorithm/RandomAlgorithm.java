/**
 * @author Birsan Ioana (cas. Amariei) B5
 * @author Gensthaler Octavian B5
 */

package investment.portofolio.algorithm;

import investment.portofolio.asset.Asset;

import java.util.*;


public class RandomAlgorithm implements Algorithm {
    /**
     * Randomly permutes the specified list using a default source of randomness.
     * All permutations occur with approximately equal likelihood.
     * @param assets the list of assets to be ordered
     */
    @Override
    public void orderAssetsAccordingToStrategy(List <Asset> assets) {
        Collections.shuffle(assets);
    }
}
