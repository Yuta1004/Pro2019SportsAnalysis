package test;

abstract public class Test {

    private boolean status;
    private static final boolean SUCCESS = true;
    private static final boolean FAIL = false;

    /**
     * テスト結果を返す
     */
    public boolean getStatus() {
        return status;
    }

    /**
     * 値の比較を行う
     *
     * @param a 比較対象1
     * @param b 比較対象2
     */
    protected <T> void test(T a, T b) {
        test("Test", a, b);
    }

    /**
     * 値の比較を行う
     *
     * @param name テストケース名
     * @param a 比較対象1
     * @param b 比較対象2
     */
    protected <T> void test(String name, T a, T b) {
        if(a.equals(b)) {
            status &= SUCCESS;
            outResult(name, SUCCESS);
        } else {
            status = FAIL;
            outResult(name, FAIL);
        }
    }

    /**
     * 結果出力
     *
     * @param name テストケース名
     * @param result SUCCESS or FAIL
     */    
    private void outResult(String name, boolean result) {
        String resultToStr[] = {"FAIL", "SUCCESS"};
        System.out.println("\""+name+"\": "+resultToStr[result?1:0]);
    }

    /**
     * テストケースを実行する
     * 継承先でオーバーライドする
     */
    abstract public void doTest();
}
