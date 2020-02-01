package csvio.reader;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.ArrayList;

import csvio.format.CSVData;

public class CSVReader {

    private List<String> rawData;

    /**
     * CSVReaderのコンストラクタ
     *
     * @param filepath CSVファイルのパス
     */
    public CSVReader(String filepath) {
        loadFile(filepath);
	}

    /**
     * ファイル読み込みを行う
     *
     * @param filepath CSVファイルのパス
     */
    private void loadFile(String filepath) {
        // 存在チェック
        Path path = Paths.get(filepath);
        if(!path.toFile().exists()) {
            System.err.println("CSVファイルが存在しません");
            return;
        }

        // ファイル読み取り
        try {
            rawData = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("CSVファイルの読み込み中にエラーが発生しました");
            return;
        }
    }

    /**
     * データ読み込みを行う
     *
     * @param fmtClass csvio.formatで定義されたCSVDataを継承するクラス
     * @return ArrayList<fmtClass> fmtClassのArrayList
     */
    public <T extends CSVData> ArrayList<T> load(Class<T> fmtClass) {
        ArrayList<T> data = new ArrayList<T>();
        for(int idx = 1; idx < rawData.size(); ++ idx) {
            try {
                T elem = fmtClass.getDeclaredConstructor().newInstance();
                elem.setData( rawData.get(idx).split(",") );
                data.add(elem);
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
        return data;
    }

 }
