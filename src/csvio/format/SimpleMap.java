package csvio.format;

import java.text.NumberFormat;

public class SimpleMap extends CSVData {

    public String name;
    public double value;

    /**
     * データセット(CSVDataの抽象メソッド)
     *
     * @param data 登録するデータ
     */
    @Override
    public void setData(String ... args) {
        // 引数チェック
        if(!checkArgsSize(args, 2))
            throw new IllegalArgumentException();

        // データ格納
        name = args[0];
        value = Double.parseDouble(args[1]);
    }

}
