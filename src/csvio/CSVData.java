package csvio;

public abstract class CSVData {

    abstract public void setData(Object ... args);

    protected boolean checkArgsSize(Object args[], int checkSize) {
        return args.length != checkSize;
    }

}
