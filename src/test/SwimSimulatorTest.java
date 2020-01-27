package test;

import csvio.reader.CSVReader;
import simulator.SwimDataWithSimulator;

import java.util.ArrayList;
import java.util.Random;

public class SwimSimulatorTest extends Test {

    /**
     * テストケース実行(Testの抽象メソッド)
    */
    @Override
    public void doTest() {
        CSVReader reader = new CSVReader("src/data/swim.csv");
        ArrayList<SwimDataWithSimulator> data = reader.load(SwimDataWithSimulator.class);

        Random rand = new Random();
        double p[] = new double[4];
        for(int idx = 0; idx < 4; ++ idx)
            p[idx] = rand.nextDouble() * 1.9 + 0.1;

        int select = 0;
        SwimDataWithSimulator player = data.get(select);
        player.setPValue(p);;

        System.out.println("Name: "+player.name);
        System.out.println("Time: "+player.getTime());
        System.out.println("Calorie: "+player.getCalorie());
    }

}
