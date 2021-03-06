package simulator;

import java.util.Random;
import java.util.ArrayList;

public class SimpleGeneticAlgorithm {

    private Random rand;
    private int parentSize, childrenSize;
    private double mutationRate;
    private ArrayList<SwimDataWithSimulator> children;

    /**
     * SimpleGeneticAlgorithmのコンストラクタ
     * 全体的な初期化処理を行う
     *
     * @param parentG 親
     * @param size 子の数
     * @param mutationRate 突然変異率
     * @param seed 乱数のシード
     */
    public SimpleGeneticAlgorithm(SwimDataWithSimulator parentG, int size, double mutationRate, int seed) {
        // メンバ初期化
        rand = new Random(seed);
        this.mutationRate = mutationRate;

        // サイズ設定
        parentSize = (int)Math.sqrt(size);
        childrenSize = size - parentSize;

        // children初期化
        children = new ArrayList<SwimDataWithSimulator>();
        for(int cnt = 0; cnt < size; ++ cnt)
            children.add((SwimDataWithSimulator)parentG.clone());

        // p値初期化
        initGen();
    }

    /**
     * 子の評価、交叉、突然変異をまとめて行う
     *
     * @return SwimDataWithSimulator 最も成績が良い子の評価値
     */
    public SwimDataWithSimulator goNextGen() {
        mutation(mutationRate);
        double evalValues[] = eval();
        ArrayList<SwimDataWithSimulator> elite = select(evalValues, parentSize);
        ArrayList<SwimDataWithSimulator> genChildren = crossover(elite, childrenSize);
        children.clear();
        children.addAll(elite);
        children.addAll(genChildren);
        return elite.get(0);
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
        // 全個体のタイムを計測
        double maxVal = 0.0;
        double evalValues[] = new double[children.size()];
        for(int idx = 0; idx < children.size(); ++ idx) {
            double time = children.get(idx).getTime();
            double cal = children.get(idx).getCalorie();
            evalValues[idx] = cal < 0 ? -1 : time;
            maxVal = Math.max(evalValues[idx], maxVal);
        }

        // タイムを評価値に変換(短いものほど評価値を高く)
        for(int idx = 0; idx < children.size(); ++ idx)
            if(evalValues[idx] >= 0)
                evalValues[idx] = (maxVal - evalValues[idx]);

        return evalValues;
    }

    /**
     * 子の選択(ルーレット選択)
     *
     * @param eval 評価値の配列
     * @param size 選択数
     * @return ArrayList<SwimDataWithSimulator> 選択された子のリスト
     */
    private ArrayList<SwimDataWithSimulator> select(double[] evalValues, int size) {
        RouletteSelect selector = new RouletteSelect(rand.nextInt(), evalValues);
        ArrayList<SwimDataWithSimulator> selectedChildren = new ArrayList<SwimDataWithSimulator>();
        for(int cnt = 0; cnt < size; ++ cnt)
            selectedChildren.add(children.get(selector.nextVal()));
        return selectedChildren;
    }

    /**
     * 交叉を行う
     * 与えられた親を元に指定された数の子を生成して返す
     *
     * @param parentList 親のリスト
     * @param size 生成数
     * @return ArrayList<SwimDataWithSimulator> 生成した子のリスト
     */
    private ArrayList<SwimDataWithSimulator> crossover(ArrayList<SwimDataWithSimulator> parentList, int size) {
        ArrayList<SwimDataWithSimulator> genChildren = new ArrayList<SwimDataWithSimulator>();
        for(; size > 0; -- size) {
            int pa = rand.nextInt(parentList.size());
            int pb = rand.nextInt(parentList.size());
            SwimDataWithSimulator child = parentList.get(0).clone();
            child.setPValue(genP(parentList.get(pa), parentList.get(pb)));
            genChildren.add(child);
        }
        return genChildren;
    }

    /**
     * 突然変異
     */
    private void mutation(double rate) {
        for(int idx = 0; idx < children.size(); ++ idx) {
            double p[] = children.get(idx).getPValue();
            children.get(idx).setPValue(genP(p, rate));
        }
    }


    /**
     * p値生成(ランダム)
     *
     * @return double[] p値の配列
     */
    private double[] genP() {
        double p[] = new double[4];
        for(int idx = 0; idx < 4; ++ idx)
            p[idx] = rand.nextDouble() * 1.7 + 0.3;
        return p;
    }

    /** p値生成(親の情報を元に一様交叉)
     *
     * @return double[] p値の配列
     */
    private double[] genP(SwimDataWithSimulator parentA, SwimDataWithSimulator parentB) {
        double p[] = new double[4];
        double parentP[][] = { parentA.getPValue(), parentB.getPValue() };
        for(int idx = 0; idx < 4; ++ idx)
            p[idx] = parentP[(rand.nextDouble()<0.5)?0:1][idx];
        return p;
    }

    /**
     * p値生成(一部をランダムに増減)
     *
     * @return double[] p値の配列
     */
    private double[] genP(double origP[], double rate) {
        double p[] = new double[4];
        for(int idx = 0; idx < 4; ++ idx) {
            p[idx] = origP[idx];
            p[idx] += rand.nextDouble() > rate ? 0.0 : rand.nextDouble()*0.5-0.25;
        }
        return p;
    }
}
