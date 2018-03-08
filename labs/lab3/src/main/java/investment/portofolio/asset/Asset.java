package investment.portofolio.asset;

/**
 * Created by AMI on 2018-03-04.
 */
public interface Asset {
    int computeProfit();

    default double riskFactor(){
        return 0;
    }
}
