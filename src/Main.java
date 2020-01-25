import csvio.reader.CSVReader;

public class Main {

    public static void main(String[] args) {
        analysisPart1();
    }

    /**
     * 分析1 ~タイム割合~
     * - 担当 : mori
     */
    private static void analysisPart1() {
        // データ読み込み
        SwimData data[] = initData(4);
        CSVReader reader = new CSVReader("src/data/swim.csv");
        reader.load(data);

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
     * SwimData初期化
     *
     * @param size サイズ
     */
    private static SwimData[] initData(int size) {
        SwimData[] data = new SwimData[size];
        for(int idx = 0; idx < size; ++ idx)
            data[idx] = new SwimData();
        return data;
    }

 }
