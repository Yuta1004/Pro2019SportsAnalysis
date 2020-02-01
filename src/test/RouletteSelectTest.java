package test;

import simulator.RouletteSelect;

public class RouletteSelectTest extends Test {

    /**
     * テストケース実行(Testの抽象メソッド)
     */
    @Override
    public void doTest() {
        double numbers[] = {1, 2, 3, 4, 5, 4, 3, 2, 1};
        RouletteSelect selector = new RouletteSelect(1204, numbers);

        int cnt[] = new int[numbers.length];
        for(int idx = 0; idx < 100; ++ idx)
            ++ cnt[selector.nextVal()];

        for(int idx = 0; idx < numbers.length; ++ idx)
            System.out.println(idx + ": " + cnt[idx]);
    }

}

