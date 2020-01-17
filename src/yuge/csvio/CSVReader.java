package yuge.csvio;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CSVReader {

    private String filepath;

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
        List<String> rawData = null;
        try {
            rawData = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("CSVファイルの読み込み中にエラーが発生しました");
            return;
        }
    }

 }
