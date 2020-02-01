package test;

import simulator.RouletteSelect;

public class RouletteSelectTest extends Test {

    /**
     * テストケース実行(Testの抽象メソッド)
     */
    @Override
    public void doTest() {
        double numbers[] = {1, 2, 5, 6, 8, 9, 4, 1, 1, 0};
        RouletteSelect selector = new RouletteSelect(1204,numbers);
    }

}

