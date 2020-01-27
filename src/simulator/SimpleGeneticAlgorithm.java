package simulator;

import java.util.Random;
import java.util.ArrayList;

public class SimpleGeneticAlgorithm {

    ArrayList<SwimDataWithSimulator> children;

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
     * childrenのp値の初期化
     */
    private void initGen() {
        for(int idx = 0; idx < children.size(); ++ idx) {
            Random rand = new Random();
            double p1 = rand.nextDouble() * 1.9 + 0.1;
            double p2 = rand.nextDouble() * 1.9 + 0.1;
            double p3 = rand.nextDouble() * 1.9 + 0.1;
            double p4 = rand.nextDouble() * 1.9 + 0.1;
            children.get(idx).setPValue(p1, p2, p3, p4);
        }
    }

}
