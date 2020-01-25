package test;

import simulator.SwimSimulator;

public class SwimSimulatorTest extends Test {

    /**
     * テストケース実行(Testの抽象メソッド)
    */
    @Override
    public void doTest() {
        SwimSimulator simulator = new SwimSimulator("src/data/swim.csv");
        test("TestConstract", simulator==null, false);
    }

}
