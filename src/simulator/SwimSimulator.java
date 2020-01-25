package simulator;

import csvio.format.SwimData;
import static csvio.util.makeCSVDataArray;

public class SwimSimulator {

    SwimData data[];


    public SwimSimulator() {
        data = makeCSVDataArray(SwimData.class, 4);
    }

}
