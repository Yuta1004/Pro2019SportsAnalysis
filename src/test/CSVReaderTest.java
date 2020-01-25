package test;

import csvio.reader.CSVReader;
import csvio.format.CSVData;

public class CSVReaderTest extends Test {

    /**
     * テストケース実行(Testの抽象メソッド)
     */
    @Override
    public void doTest() {
        TestData data[] = initData(4);
        CSVReader reader = new CSVReader("src/data/test.csv");
        reader.load(data);

        String names[] = {"ああああ", "いいいい", "うううう", "ええええ"};
        for(int idx = 0; idx < 4; ++ idx) {
            test("Test-"+idx+"-name", data[idx].name, names[idx]);
            test("Test-"+idx+"-value", data[idx].value, (idx+1)*10.0);
        }
    }

    /**
     * TestData配列を初期化する(with コンストラクト)
     *
     * @param size サイズ
     */
    private TestData[] initData(int size) {
        TestData data[] = new TestData[size];
        for(int idx = 0; idx < size; ++ idx)
            data[idx] = new TestData();
        return data;
    }
}

/**
 * テストデータを扱うクラス
 */
class TestData extends CSVData {

    public String name;
    public double value;

    /**
     * データセット(CSVDataの抽象メソッド)
     *
     * @param data 登録するデータ
     */
    @Override
    public void setData(String ... args) {
        // 引数チェック
        if(!checkArgsSize(args, 2))
            throw new IllegalArgumentException();

        // データ格納
        name = args[0];
        value = Double.parseDouble(args[1]);
    }

}
