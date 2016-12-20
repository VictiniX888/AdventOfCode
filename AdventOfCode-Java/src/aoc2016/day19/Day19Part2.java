package aoc2016.day19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day19Part2 {

    private static int pos = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        int input = Integer.parseInt(scanner.nextLine());

        List<Integer> circle = new ArrayList<>();
        for (int i = 0; i < input; i++) {
            circle.add(i+1);
        }

        while(circle.size() > 1) {
            circle = elephant(circle);
        }

        System.out.println(circle.get(0));
    }

    private static List<Integer> elephant(List<Integer> circle) {

        if(circle.size() % 2 == 0) {
            circle.remove(circle.size()/2);
            int i = circle.get(0);
            circle.remove(0);
            circle.add(i);
        }
        else {
            circle.remove((circle.size() - 1)/2);
            int i = circle.get(0);
            circle.remove(0);
            circle.add(i);
        }

        return circle;
    }
}
