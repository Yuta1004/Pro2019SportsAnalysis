import csvio.reader.CSVReader;
import csvio.format.SwimData;
import simulator.SwimDataWithSimulator;
import simulator.SimpleGeneticAlgorithm;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        analysisPart1();
        analysisPart2();
    }

    /**
     * 分析1 ~タイム割合~
     * - 担当 : mori
     */
    private static void analysisPart1() {
        // データ読み込み
        CSVReader reader = new CSVReader("src/data/swim.csv");
        ArrayList<SwimData> data = reader.load(SwimData.class);

        for(SwimData elem: data) {
            System.out.println(elem.name + " : ");
            System.out.print(elem.backstroke + ", ");
            System.out.print("(" + ((elem.backstroke/elem.sum)*100)+ "%), ");

            System.out.print(elem.braststroke + ", ");
            System.out.print("(" + ((elem.braststroke/elem.sum)*100)+ "%), ");

            System.out.print(elem.butterfly + ", ");
            System.out.print("(" + ((elem.butterfly/elem.sum)*100)+ "%), ");

            System.out.print(elem.free + ", ");
            System.out.print("(" + ((elem.free/elem.sum)*100)+ "%), ");
            System.out.println(elem.sum);
        }
    }

    /**
     * 分析2 ~体力分配~
     * - 担当 : nakagami
     */
    private static void analysisPart2() {
        // データ読み込み
        CSVReader reader = new CSVReader("src/data/swim.csv");
        ArrayList<SwimDataWithSimulator> data = reader.load(SwimDataWithSimulator.class);

        // SGA
        int select = 0, gen = 500;
        SimpleGeneticAlgorithm sga = new SimpleGeneticAlgorithm(data.get(select), 1000, 1204);
        for(int idx = 0; idx < gen; ++ idx)
            System.out.println(idx + "," + sga.goNextGen());
    }

 }
