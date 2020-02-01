package util;

import java.lang.Comparable;

public class Pair<K, V extends Comparable> implements Comparable{

    public K first;
    public V second;

    /**
     * Pairのコンストラクタ
     *
     * @param first  要素1
     * @param second 要素2
     */
    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    /**
     * 2要素の比較
     */
    public int compareTo(Object other) {
        Pair otherPair = (Pair)other;
        return second.compareTo(otherPair.second);
    }

}

