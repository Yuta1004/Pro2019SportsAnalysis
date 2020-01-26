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
        double p1 = rand.nextDouble() * 1.9 + 0.1;
        double p2 = rand.nextDouble() * 1.9 + 0.1;
        double p3 = rand.nextDouble() * 1.9 + 0.1;
        double p4 = rand.nextDouble() * 1.9 + 0.1;

        int select = 0;
        SwimDataWithSimulator player = data.get(select);
        player.setPValue(p1, p2, p3, p4);

        System.out.println("Name: "+player.name);
        System.out.println("Time: "+player.getTime());
        System.out.println("Calorie: "+player.getCalorie());
        System.out.println("PValues: "+p1+" ,"+p2+", "+p3+", "+p4);
    }

}
