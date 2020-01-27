package simulator;

import csvio.format.SwimData;

public class SwimDataWithSimulator extends SwimData {

    private static final double BUTTERFLY_METs = 12.5;
    private static final double BACKSTROKE_METs = 8.0;
    private static final double BRASTSTROKE_METs = 11.0;
    private static final double FREE_METs = 12.0;
    private static final double[] METs = {
        BUTTERFLY_METs, BACKSTROKE_METs, BRASTSTROKE_METs, FREE_METs
    };

    private double maxCalorie;
    private double p[], origP[], origTimes[];

    /**
     * SwimDataWithPのコンストラクタ
     */
    public SwimDataWithSimulator() {
        maxCalorie = 0.0;
        p = new double[4];
        origP = new double[4];
    }

    /**
     * データセット
     */
    public void setData(String ... args) {
        super.setData(args);
        origTimes = new double[4];
        origTimes[0] = butterfly;
        origTimes[1] = backstroke;
        origTimes[2] = braststroke;
        origTimes[3] = free;
        for(int idx = 0; idx < 4; ++ idx)
            maxCalorie += calcCalorie(METs[idx], origTimes[idx]);
    }

    /**
     * p値セット(各泳法の力の入れ具合)
     *
     * @param p double型配列
     */
    public void setPValue(double p[]) {
        if(p.length != 4)
            throw new IllegalArgumentException();
        for(int idx = 0; idx < 4; ++ idx) {
            this.origP[idx] = p[idx];
            this.p[idx] = 0.45*Math.log10(p[idx])+1;
        }
    }

    /**
     * p値取得
     *
     * @return double[] p値の配列
     */
    public double[] getPValue() {
        return origP;
    }

    /**
     * p値を元に合計タイムを計算して返す
     *
     * @return double タイム
     */
    public double getTime() {
        double time = 0;
        for(int idx = 0; idx < 4; ++ idx)
            time += (1.0/p[idx]) * origTimes[idx];
        return time;
    }

    /**
     * p値を元に合計消費カロリーを計算して返す
     * ただし、消費限界を超えた場合は-1を返す
     *
     * @return double 消費カロリー
     */
    public double getCalorie() {
        double calorie = 0.0;
        for(int idx = 0; idx < 4; ++ idx)
            calorie += calcCalorie(METs[idx], p[idx]*origTimes[idx]);
        return calorie <= maxCalorie ? calorie : -1;
    }

    /**
     * clone(p値は引き継がない)
     *
     * @return SwimDataWithSimulaotr
     */
    public SwimDataWithSimulator clone() {
        SwimDataWithSimulator tmp = new SwimDataWithSimulator();
        tmp.setData(name, weight+"", butterfly+"", backstroke+"", braststroke+"", free+"");
        return tmp;
    }

    /**
     * 消費カロリー計算
     *
     * @param mets METs
     * @param time 運動時間(s)
     * @param weight 体重
     */
    private double calcCalorie(double mets, double time) {
        return mets * (time/3600.0) * weight * 1.05;
    }

}
