package csvio.format;

import CSVData;

public class SwimData extends CSVData {

    String name;
    public double backstroke, braststroke, butterfly, free, sum; 

    /**
     * データセット(CSVDataの抽象メソッド)
     *
     * @param args データ
     */
    @Override
    public void setData(String ... args) {
        // 引数長さチェック
        if(!checkArgsSize(args, 5))
            throw new IllegalArgumentException();

        // 選手名
        name = (String)args[0];

        // その他データ
        butterfly = Double.parseDouble(args[1]);
        backstroke = Double.parseDouble(args[2]);
        braststroke = Double.parseDouble(args[3]);
        free = Double.parseDouble(args[4]);
        sum = butterfly + backstroke + braststroke + free;
    }

}
