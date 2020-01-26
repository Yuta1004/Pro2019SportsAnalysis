package simulator;

import csvio.format.SwimData;

public class SwimDataWithP extends SwimData {

    public double maxCalorie;
    public double p[];

    // 0 -> バタフライ
    // 1 -> 背泳ぎ
    // 2 -> 平泳ぎ
    // 3 -> 自由形
    public SwimDataWithP() {
        p = new double[4];
    }

}
