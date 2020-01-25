package test;

import simulator.SwimSimulator;

public class SwimSimulatorTest extends Test {

    /**
     * テストケース実行(Testの抽象メソッド)
    */
    @Override
    public void doTest() {
        SwimSimulator simulator = new SwimSimulator();
        test("TestConstract", simulator==null, false);
    }

}
