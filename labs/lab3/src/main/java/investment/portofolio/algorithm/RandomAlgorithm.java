package investment.portofolio.algorithm;

import investment.portofolio.asset.Asset;

import java.util.*;

/**
 * Created by AMI on 2018-03-08.
 */
public class RandomAlgorithm implements Algorithm {

    public RandomAlgorithm() {
    }

    @Override
    public void orderAssetsAccordingToStrategy(List <Asset> assets) {
        Collections.shuffle(assets);
    }
}
