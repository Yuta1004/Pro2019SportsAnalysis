package util;

import java.lang.Comparable;

public class Pair<K, V extends Number & Comparable> implements Comparable{

    public K first;
    public V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public int compareTo(Object other) {
        Pair otherPair = (Pair)other;
        return second.compareTo(otherPair.second);
    }

} 

