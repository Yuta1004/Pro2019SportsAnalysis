package yuge.test;

import yuge.csvio.CSVReader;

public class CSVReaderTest extends Test {

    @Override
    public void doTest() {
        CSVReader reader = new CSVReader("src/data/test.csv");
    }

}

