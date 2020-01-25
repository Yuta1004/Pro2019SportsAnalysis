package csvio;

import csvio.format.CSVData;

import java.lang.reflect.Array;

public class util {

    @SuppressWarnings("unchecked")
    public static <T extends CSVData> T[] makeCSVDataArray(Class<T> childCls, int size) {
        T[] data = (T[])Array.newInstance(childCls, size);
        try {
            for(int idx = 0; idx < size; ++ idx)
                data[idx] = childCls.getDeclaredConstructor().newInstance();
        } catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }


}
