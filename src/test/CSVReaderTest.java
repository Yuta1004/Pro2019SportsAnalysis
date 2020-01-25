package test;

import csvio.reader.CSVReader;
import csvio.format.SimpleMap;
import static csvio.util.makeCSVDataArray;


public class CSVReaderTest extends Test {

    /**
     * テストケース実行(Testの抽象メソッド)
     */
    @Override
    public void doTest() {
        SimpleMap data[] = makeCSVDataArray(SimpleMap.class, 4);
        CSVReader reader = new CSVReader("src/data/test.csv");
        reader.load(data);

        String names[] = {"ああああ", "いいいい", "うううう", "ええええ"};
        for(int idx = 0; idx < 4; ++ idx) {
            test("Test-"+idx+"-name", data[idx].name, names[idx]);
            test("Test-"+idx+"-value", data[idx].value, (idx+1)*10.0);
        }
    }

}

