package test;

import csvio.reader.CSVReader;
import simulator.SwimDataWithSimulator;

public class SwimSimulatorTest extends Test {

    /**
     * テストケース実行(Testの抽象メソッド)
    */
    @Override
    public void doTest() {
        CSVReader reader = new CSVReader("src/data/swim.csv");
        reader.load(SwimDataWithSimulator.class);
        test("TestConstract", true, true);
    }

}
