package csvio;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CSVReader {

    private String filepath;
    private List<String> rawData;

    /**
     * CSVReaderのコンストラクタ
     *
     * @param filepath CSVファイルのパス
     */
    public CSVReader(String filepath) {
        this.filepath = filepath;
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
     * 引数で指定された配列に値を書き込む
     *
     * @param data CSVDataを継承したクラスのインスタンスの配列
     */
    public void load(CSVData data[]) {
        int maxSize = data.length;
        for(int idx = 1; idx < rawData.size() && idx <= maxSize; ++ idx) {
            String splittedLine[] = rawData.get(idx).split(",");
            data[idx-1].setData(splittedLine);
        }
    }

 }
