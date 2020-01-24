import csvio.CSVData;

public class SwimData extends CSVData {

    String name;
    public double backstroke, braststroke, butterfly, free;    

    @Override
    public void setData(String ... args) {
        // 引数長さチェック
        if(!checkArgsSize(args, 5))
            throw new IllegalArgumentException();

        // 選手名
        name = (String)args[0];

        // その他データ
        backstroke = Double.parseDouble(args[1]);
        braststroke = Double.parseDouble(args[2]);
        butterfly = Double.parseDouble(args[3]);
        free = Double.parseDouble(args[4]);
    }

}
