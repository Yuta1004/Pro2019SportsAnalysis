package simulator;

import csvio.reader.CSVReader;
import csvio.format.SwimData;

import java.util.ArrayList;

public class SwimSimulator {

    ArrayList<SwimData> data;

    public SwimSimulator(String csvPath) {
        CSVReader reader = new CSVReader(csvPath);
        data = reader.load(SwimData.class);
    }

}
