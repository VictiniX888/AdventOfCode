import days.*;

import java.util.Scanner;

public class AdventOfCode {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Day: ");
        int day = scanner.nextInt();
        System.out.print("Part: ");
        int part = scanner.nextInt();

        if(day == 1) {
            if(part == 1) new Day1Part1();
            if(part == 2) new Day1Part2();
        }
        if(day == 2) {
            if(part == 1) new Day2Part1();
            if(part == 2) new Day2Part2();
        }
        if(day == 3) {
            if(part == 1) new Day3Part1();
            if(part == 2) new Day3Part2();
        }
        if(day == 4) {
            if(part == 1) new Day4Part1();
            if(part == 2) new Day4Part2();
        }
        if(day == 5) {
            if(part == 1) new Day5Part1();
            if(part == 2) new Day5Part2();
        }
    }
}
