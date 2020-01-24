import test.Test;
import test.CSVReaderTest;

class ExecuteTest {

    public static void main(String[] args) {
        Test allTests[] = {
            new CSVReaderTest()
        };

        for(Test test: allTests) {
            System.out.println("**"+test.getClass().getSimpleName()+"**");
            test.doTest();
            System.out.println();
        }
    }

}

