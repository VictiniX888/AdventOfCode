package aoc2016.day20;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day20Part1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();
        String[] splitInput = input.split(";");

        List<Pair<Long, Long>> blocked = new ArrayList<>();
        for (String s : splitInput) {
            String[] sSplit = s.split("-");
            blocked.add(new Pair<>(Long.parseLong(sSplit[0]), Long.parseLong(sSplit[1])));
        }

        PairComparator pairComparator = new PairComparator();
        blocked.sort(pairComparator);

        if(blocked.get(0).getKey() != 0) {
            System.out.println(0);
        }
        else {
            Long currentEnd = blocked.get(0).getValue();
            for (Pair<Long, Long> p : blocked) {
                Long nextStart = p.getKey();
                Long nextEnd = p.getValue();

                if(nextStart > currentEnd + 1) {
                    System.out.println(currentEnd + 1);
                    break;
                }
                else if(nextEnd > currentEnd) {
                    currentEnd = nextEnd;
                }
            }
        }
    }
}
