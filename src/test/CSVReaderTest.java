package test;

import csvio.reader.CSVReader;
import csvio.format.SimpleMap;

import java.util.ArrayList;

public class CSVReaderTest extends Test {

    /**
     * テストケース実行(Testの抽象メソッド)
     */
    @Override
    public void doTest() {
        CSVReader reader = new CSVReader("src/data/test.csv");
        ArrayList<SimpleMap> data = reader.load(SimpleMap.class);

        String names[] = {"ああああ", "いいいい", "うううう", "ええええ"};
        for(int idx = 0; idx < 4; ++ idx) {
            test("Test-"+idx+"-name", data.get(idx).name, names[idx]);
            test("Test-"+idx+"-value", data.get(idx).value, (idx+1)*10.0);
        }
    }

}

