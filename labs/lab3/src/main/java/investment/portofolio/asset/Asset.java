/**
 * @author Birsan Ioana (cas. Amariei) B5
 * @author Gensthaler Octavian B5
 */

package investment.portofolio.asset;

public interface Asset {
    /**
     * Computes the expected profit considering the risk factor and the following:
     * 1) for an object of type Building: area / price;
     * 2) for an object of type Vehicle: performance / price.
     * @return the expected profit
     */
    int computeProfit();

    /**
     * Evaluates the financial risk of purchasing an item
     * @return the risk factor (default value is 0 -- no risk)
     */
    default double riskFactor(){
        return 0;
    }
}
