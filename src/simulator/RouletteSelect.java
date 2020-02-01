package simulator;

import util.Pair;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class RouletteSelect {

    private Random rand;
    private int selectTable[];
    private ArrayList<Pair<Integer, Double>> data;

    /**
     * RouletteSelectのコンストラクタ
     */
    public RouletteSelect(int seed, double[] array) {
        rand = new Random(seed);
        normalization(array);
        initSelectTable();
    }

    /**
     * ルーレット選択
     */
    public int nextVal() {
        return selectTable[rand.nextInt(1000)];
    }

    /**
     * データの正規化を行う
     *
     * @param data double要素の配列
     */
    @SuppressWarnings("unchecked")
    private void normalization(double array[]) {
        // 全データの合計
        double sum = 0;
        for(int idx = 0; idx < array.length; ++ idx) {
            if(array[idx] >= 0)
                sum += array[idx];
        }

        // data初期化
        data = new ArrayList<Pair<Integer, Double>>();
        for(int idx = 0; idx < array.length; ++ idx) {
            if(array[idx] >= 0) {
                data.add(
                    new Pair<Integer, Double>(idx, array[idx] / sum)
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

    /**
     * 選択テーブルを初期化する
     */
    private void initSelectTable() {
        // テーブル初期化
        selectTable = new int[1000];

        // 値セット
        int dataIdx = -1, prop = 1000;
        for(int idx = 999; idx >= 0; -- idx) {
            if(prop > idx) {
                ++ dataIdx;
                prop = (int)(data.get(dataIdx).second*1000.0);
            }
            selectTable[idx] = data.get(dataIdx).first;
        }
    }

}