package simulator;

import java.util.Random;
import java.util.ArrayList;

public class SimpleGeneticAlgorithm {

    private static final double INF = (1 << 30);

    private ArrayList<SwimDataWithSimulator> children;

    /**
     * SimpleGeneticAlgorithmのコンストラクタ
     * 全体的な初期化処理を行う
     *
     * @param parentG 親
     * @param size 子の数
     */
    public SimpleGeneticAlgorithm(SwimDataWithSimulator parentG, int size) {
        // childre初期化
        children = new ArrayList<SwimDataWithSimulator>();
        for(int cnt = 0; cnt < size; ++ cnt) {
            SwimDataWithSimulator tmp = new SwimDataWithSimulator();
            tmp.setData(parentG.name, parentG.weight+"", parentG.butterfly+"",
                        parentG.backstroke+"", parentG.braststroke+"", parentG.free+"");
            children.add(tmp);
        }

        // p値初期化
        initGen();
    }

    /**
     * 子の評価、交叉、突然変異をまとめて行う
     *
     * @return double 最も成績が良い子の評価値
     */
    public double goNextGen() {
    }


    /**
     * childrenのp値の初期化
     */
    private void initGen() {
        for(int idx = 0; idx < children.size(); ++ idx)
            children.get(idx).setPValue(genP());
    }

    /**
     * 子の評価
     *
     * @return double[] 評価値の配列(childrenに対応)
     */
    private double[] eval() {
        double evalValues[] = new double[children.size()];
        for(int idx = 0; idx < 4; ++ idx) {
            double time = children.getTime();
            double cal = children.getCalorie();
            eval[idx] = cal < 0 ? INF : time;
        }
        return eval;
    }

    /**
     * p値生成(ランダム)
     *
     * @return double[] p値の配列
     */
    private double[] genP() {
        Random rand = new Random();
        double p[] = new double[4];
        for(int idx = 0; idx < 4; ++ idx)
            p[idx] = rand.nextDouble() * 1.9 + 0.1;
        return p;
    }
}
