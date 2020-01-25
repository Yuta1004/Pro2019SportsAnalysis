package csvio.format;

public abstract class CSVData {

    /**
     * データセット
     *
     * @param args 登録するデータを渡す(可変長引数)
     */
    abstract public void setData(String ... args);

    /**
     * 引数サイズをチェックする
     *
     * @param args 引数の配列
     * @param checkSize サイズ
     */
    protected boolean checkArgsSize(Object args[], int size) {
        return args.length == size;
    }

}
