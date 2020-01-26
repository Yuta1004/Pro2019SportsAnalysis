package simulator;

import csvio.format.SwimData;

public class SwimDataWithSimulator extends SwimData {

    private static final double BUTTERFLY_METs = 13.5;
    private static final double BACKSTROKE_METs = 9.0;
    private static final double BRASTSTROKE_METs = 12.0;
    private static final double FREE_METs = 13.0;
    private static final double[] METs = {
        BUTTERFLY_METs, BACKSTROKE_METs, BRASTSTROKE_METs, FREE_METs
    };

    private double maxCalorie;
    private double p[], origTimes[];

    /**
     * SwimDataWithPのコンストラクタ
     */
    public SwimDataWithSimulator() {
        maxCalorie = 0.0;
        p = new double[4];
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
     * @param p1~p4 力の入れ具合(0.1 ~ 2.0)、標準を1として大きいほど力を入れて泳ぐ
     */
    public void setPValue(double p1, double p2, double p3, double p4) {
        p[0] = 0.45*Math.log10(p1)+1;
        p[1] = 0.45*Math.log10(p2)+1;
        p[2] = 0.45*Math.log10(p3)+1;
        p[3] = 0.45*Math.log10(p4)+1;
        for(int i = 0; i < 4; ++ i)
            System.out.println(p[i]);
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
