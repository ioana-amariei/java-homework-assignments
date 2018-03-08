package investment.portofolio.algorithm;

import investment.portofolio.asset.Asset;
import java.util.List;

/**
 * Created by AMI on 2018-03-08.
 */
public interface Algorithm {
    void orderAssetsAccordingToStrategy(List <Asset> assets);
}
