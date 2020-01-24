package csvio;

public abstract class CSVData {

    protected int size;

    abstract public void setData(Object ... args);

    public int getSize() {
        return size;
    }

    protected boolean checkArgsSize(Object args[], int checkSize) {
        return args.length != checkSize;
    }

}
