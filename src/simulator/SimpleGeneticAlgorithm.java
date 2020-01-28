package simulator;

import util.Pair;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

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
        for(int cnt = 0; cnt < size; ++ cnt)
            children.add((SwimDataWithSimulator)parentG.clone());

        // p値初期化
        initGen();
    }

    /**
     * 子の評価、交叉、突然変異をまとめて行う
     *
     * @return double 最も成績が良い子の評価値
     */
    public double goNextGen() {
        double evalValues[] = eval();
        select(evalValues, 10);
        return 0.0;
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
        for(int idx = 0; idx < children.size(); ++ idx) {
            double time = children.get(idx).getTime();
            double cal = children.get(idx).getCalorie();
            evalValues[idx] = cal < 0 ? INF : time;
        }
        return evalValues;
    }

    /**
     * 子の選択(単純に上位size個)
     *
     * @param eval 評価値の配列
     * @param size 選択数
     * @return ArrayList<SwimDataWithSimulator> 選択された子のリスト
     */
    @SuppressWarnings("unchecked") 
    private ArrayList<SwimDataWithSimulator> select(double[] evalValues, int size) {
        // 評価値ソート
        ArrayList<Pair<Integer, Double>> evalKV = new ArrayList<Pair<Integer, Double>>();
        for(int idx = 0; idx < evalValues.length; ++ idx)
            evalKV.add(new Pair<Integer, Double>(idx, evalValues[idx]));
        Collections.sort(evalKV);

        // 上位n個の子を選択
        ArrayList<SwimDataWithSimulator> selectedChildren = new ArrayList<SwimDataWithSimulator>();
        for(int idx = 0; idx < size; ++ idx)
            selectedChildren.add(children.get(evalKV.get(idx).first));
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
        // サイズ検証
        size = size > Math.pow(parentList.size(), 2) ? (int)Math.pow(parentList.size(), 2) : size;

        // 子を生成
        ArrayList<SwimDataWithSimulator> genChildren = new ArrayList<SwimDataWithSimulator>();
        for(int idxA = 0; idxA < parentList.size(); ++ idxA) {
            for(int idxB = 0; idxB < parentList.size(); ++ idxB) {
                if(idxA*parentList.size()+idxB >= size)
                    break;
                SwimDataWithSimulator child = parentList.get(0).clone();
                child.setPValue(genP(parentList.get(idxA), parentList.get(idxB)));
                genChildren.add(child);
            }
        }
        return genChildren;
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

    /** p値生成(親の情報を元に)
     *
     * @return double[] p値の配列
     */
    private double[] genP(SwimDataWithSimulator parentA, SwimDataWithSimulator parentB) {
        Random rand = new Random();
        double p[] = new double[4];
        double parentP[][] = { parentA.getPValue(), parentB.getPValue() };
        for(int idx = 0; idx < 4; ++ idx) {
            p[idx] = parentP[rand.nextInt(2)][idx]; 
        }
        return p;
    }
}
