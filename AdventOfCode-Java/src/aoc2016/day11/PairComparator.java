package aoc2016.day11;

import javafx.util.Pair;

import java.util.Comparator;

class PairComparator implements Comparator<Pair<Integer, Integer>> {

    @Override
    public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {

        if(compare1(o1, o2) == 0) {
            return compare2(o1, o2);
        }
        else {
            return compare1(o1, o2);
        }
    }

    private int compare1 (Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {

        return p1.getKey().compareTo(p2.getKey());
    }

    private int compare2 (Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {

        return p1.getValue().compareTo(p2.getValue());
    }
}
