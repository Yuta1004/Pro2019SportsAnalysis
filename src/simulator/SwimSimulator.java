package simulator;

import csvio.reader.CSVReader;

import java.util.ArrayList;

public class SwimSimulator {

    private static final double BUTTERFLY_METs = 13.5;
    private static final double BACKSTROKE_METs = 9.0;
    private static final double BRASTSTROKE_METs = 12.0;
    private static final double FREE_METs = 13.0;

    private ArrayList<SwimDataWithP> data;

    /**
     * SwimSimulatorのコンストラクタ
     *
     * @param csvPath CSVファイルのパス
     */
    public SwimSimulator(String csvPath) {
        // CSVファイル読み込み
        CSVReader reader = new CSVReader(csvPath);
        data = reader.load(SwimDataWithP.class);

        // 最大消費カロリー計算
        for(SwimDataWithP elem : data) {
            double maxCalorie = 0.0;
            maxCalorie += calcCalorie(BUTTERFLY_METs, elem.butterfly, elem.weight);
            maxCalorie += calcCalorie(BACKSTROKE_METs, elem.backstroke, elem.weight);
            maxCalorie += calcCalorie(BRASTSTROKE_METs, elem.braststroke, elem.weight);
            maxCalorie += calcCalorie(FREE_METs, elem.free, elem.weight);
            elem.maxCalorie = maxCalorie;
        }
    }

    /**
     * 消費カロリー計算
     *
     * @param mets METs
     * @param time 運動時間(s)
     * @param weight 体重
     */
    private double calcCalorie(double mets, double time, double weight) {
        return mets * (time/3600.0) * weight * 1.05;
    }

}
