package aoc2016.day20;

import javafx.util.Pair;

import java.util.Comparator;

class PairComparator implements Comparator<Pair<Long, Long>> {

    @Override
    public int compare(Pair<Long, Long> o1, Pair<Long, Long> o2) {

        if(compare1(o1, o2) == 0) {
            return compare2(o1, o2);
        }
        else {
            return compare1(o1, o2);
        }
    }

    private int compare1 (Pair<Long, Long> p1, Pair<Long, Long> p2) {

        return p1.getKey().compareTo(p2.getKey());
    }

    private int compare2 (Pair<Long, Long> p1, Pair<Long, Long> p2) {

        return p1.getValue().compareTo(p2.getValue());
    }
}
