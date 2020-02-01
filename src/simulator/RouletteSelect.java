package simulator;

import util.Pair;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class RouletteSelect {

    private Random rand;
    private double sum;
    private ArrayList<Pair<Integer, Double>> data;

    /**
     * RouletteSelectのコンストラクタ
     */
    @SuppressWarnings("unchecked")
    public RouletteSelect(int seed, double[] argDataArray) {
        // rand初期化
        rand = new Random(seed);

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
        Collections.reverse(data);

        // 0 ~ 1.0の範囲で正規化
        double val = 1.0;
        for(Pair<Integer, Double> elem : data) {
            val -= elem.second;
            elem.second = val;
        }
    }

}