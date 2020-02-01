import test.Test;
import test.CSVReaderTest;
import test.SwimSimulatorTest;
import test.RouletteSelectTest;

class ExecuteTest {

    public static void main(String[] args) {
        Test allTests[] = {
            new CSVReaderTest(),
            new SwimSimulatorTest(),
            new RouletteSelectTest()
        };

        for(Test test: allTests) {
            System.out.println("**"+test.getClass().getSimpleName()+"**");
            test.doTest();
            System.out.println();
        }
    }

}

