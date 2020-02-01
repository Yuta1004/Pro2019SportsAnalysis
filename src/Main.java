import csvio.reader.CSVReader;
import csvio.format.SwimData;
import simulator.SwimDataWithSimulator;
import simulator.SimpleGeneticAlgorithm;

import java.util.Random;
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

        // seed
        Random rand = new Random();
        int seed = rand.nextInt();
        // seed = 1204;
        System.out.println("Seed: " + seed);

        // SGA
        int select = 0, gen = 100;
        SimpleGeneticAlgorithm sga = new SimpleGeneticAlgorithm(data.get(select), 5, seed);
        for(int cnt = 1; cnt <= gen; ++ cnt) {
            if(cnt == 1 || cnt % 1 == 0)
                printResult(cnt, sga.goNextGen());
        }
    }

    /**
     * SGAの途中経過をCSV形式で出力する
     *
     * @param gen 世代
     * @param data SwimDataWithSimulator
     */
    private static void printResult(int gen, SwimDataWithSimulator data) {
        // 世代, タイム(評価値)
        System.out.print(gen + ",");
        System.out.print(data.getTime() + ",");

        // p値
        double p[] = data.getPValue();
        for(int idx = 0; idx < p.length; ++ idx)
            System.out.print(p[idx] + ",");
        System.out.println();
    }

 }
