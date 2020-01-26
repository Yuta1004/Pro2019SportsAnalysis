package simulator;

import csvio.format.SwimData;

public class SwimDataWithSimulator extends SwimData {

    private static final double BUTTERFLY_METs = 13.5;
    private static final double BACKSTROKE_METs = 9.0;
    private static final double BRASTSTROKE_METs = 12.0;
    private static final double FREE_METs = 13.0;

    private double maxCalorie;
    private double p[];

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
        maxCalorie += calcCalorie(BUTTERFLY_METs, butterfly, weight);
        maxCalorie += calcCalorie(BACKSTROKE_METs, backstroke, weight);
        maxCalorie += calcCalorie(BRASTSTROKE_METs, braststroke, weight);
        maxCalorie += calcCalorie(FREE_METs, free, weight);
    }

    /**
     * p値セット(各泳法の力の入れ具合)
     *
     * @param p1~p4 力の入れ具合(0.1 ~ 2.0)、標準を1として大きいほど力を入れて泳ぐ
     */
    public void setPValue(double p1, double p2, double p3, double p4) {
        p[0] = Math.log10(p1)+1;
        p[1] = Math.log10(p2)+1;
        p[2] = Math.log10(p3)+1;
        p[3] = Math.log10(p4)+1;
    }

    /**
     * p値を元に合計タイムを計算して返す
     */
    public double getTime() {
        return p[0] * butterfly +
               p[1] * backstroke +
               p[2] * braststroke +
               p[3] * free;
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
