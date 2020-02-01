package simulator;

import util.Pair;

import java.util.ArrayList;
import java.util.Collections;

public class RouletteSelect {

    private double sum;
    private ArrayList<Pair<Integer, Double>> data;

    /**
     * RouletteSelectのコンストラクタ
     */
    @SuppressWarnings("unchecked")
    public RouletteSelect(double[] argDataArray) {
        // 全データの合計
        for(int idx = 0; idx < argDataArray.length; ++ idx) {
            if(argDataArray[idx] >= 0)
                sum += argDataArray[idx];
        }

        // data初期化
        data = new ArrayList<Pair<Integer, Double>>();
        for(int idx = 0; idx < argDataArray.length; ++ idx) {
            if(argDataArray[idx] >= 0) {
                data.add(
                    new Pair<Integer, Double>(idx, argDataArray[idx] / sum)
                );
            }
        }
        Collections.sort(data);
    }

}