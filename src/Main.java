import csvio.CSVReader;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");
    }

    /**
     * SwimData初期化
     *
     * @param size サイズ
     */
    private SwimData[] initData(int size) {
        SwimData[] data = new SwimData[size];
        for(int idx = 0; idx < data; ++ idx)
            data = new SwimData();
        return data;
    }

 }
