import test.Test;
import test.CSVReaderTest;
import test.SwimSimulatorTest;

class ExecuteTest {

    public static void main(String[] args) {
        Test allTests[] = {
            new CSVReaderTest(),
            new SwimSimulatorTest()
        };

        for(Test test: allTests) {
            System.out.println("**"+test.getClass().getSimpleName()+"**");
            test.doTest();
            System.out.println();
        }
    }

}

