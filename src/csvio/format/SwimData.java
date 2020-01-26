package csvio.format;

public class SwimData extends CSVData {

    public String name;
    public double weight, butterfly, backstroke, braststroke, free, sum;

    /**
     * データセット(CSVDataの抽象メソッド)
     *
     * @param args データ
     */
    @Override
    public void setData(String ... args) {
        // 引数長さチェック
        if(!checkArgsSize(args, 6))
            throw new IllegalArgumentException();

        // 選手名
        name = (String)args[0];

        // その他データ
        weight = Double.parseDouble(args[1]);
        butterfly = Double.parseDouble(args[2]);
        backstroke = Double.parseDouble(args[3]);
        braststroke = Double.parseDouble(args[4]);
        free = Double.parseDouble(args[5]);
        sum = butterfly + backstroke + braststroke + free;
    }

}
