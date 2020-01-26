package simulator;

import csvio.reader.CSVReader;

import java.util.ArrayList;

public class SwimSimulator {

    private static final double BUTTERFLY_METs = 13.5;
    private static final double BRASTSTROKE_METs = 12.0;
    private static final double BACKSTROKE_METs = 9.0;
    private static final double FREE_METs = 13.0;

    private ArrayList<SwimDataWithP> data;

    /**
     * SwimSimulatorのコンストラクタ
     *
     * @param csvPath CSVファイルのパス
     */
    public SwimSimulator(String csvPath) {
        CSVReader reader = new CSVReader(csvPath);
        data = reader.load(SwimDataWithP.class);
    }

    /**
     * 消費カロリー計算
     *
     * @param mets METs
     * @param time 運動時間
     * @param weight 体重
     */
    private double calcCalorie(double mets, double time, double weight) {
        return mets * time * weight * 1.05;
    }

}
