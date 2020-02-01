package simulator;

import util.Pair;

import java.util.ArrayList;

public class RouletteSelect {

    private double sum;
    private ArrayList<Pair<Integer, Double>> data;

    /**
     * RouletteSelectのコンストラクタ
     */
    public RouletteSelect(double[] argDataArray) {
        // 全データの合計
        for(int idx = 0; idx < argDataArray.length; ++ idx) {
            if(argDataArray[idx] >= 0)
                sum += argDataArray[idx];
        }

        // data初期化
        for(int idx = 0; idx < argDataArray.length; ++ idx) {
            if(argDataArray[idx] >= 0) {
                data.add(
                    new Pair<Integer, Double>(idx, argDataArray[idx] / sum)
                );
            }
        }
    }

}