package simulator;

import csvio.reader.CSVReader;
import csvio.format.SwimData;

import java.util.ArrayList;

public class SwimSimulator {

    private static final double BUTTERFLY_METs = 13.5;
    private static final double BRASTSTROKE_METs = 12.0;
    private static final double BACKSTROKE_METs = 9.0;
    private static final double FREE_METs = 13.0;

    private ArrayList<SwimData> data;

    public SwimSimulator(String csvPath) {
        CSVReader reader = new CSVReader(csvPath);
        data = reader.load(SwimData.class);
    }

}
