import days.day01.Day1Part1;
import days.day01.Day1Part2;
import days.day02.Day2Part1;
import days.day02.Day2Part2;
import days.day03.Day3Part1;
import days.day03.Day3Part2;
import days.day04.Day4Part1;
import days.day04.Day4Part2;
import days.day05.Day5Part1;
import days.day05.Day5Part2;
import days.day06.Day6Part1;
import days.day06.Day6Part2;
import days.day07.Day7Part1;
import days.day07.Day7Part2;
import days.day08.Day8Part1;
import days.day08.Day8Part2;
import days.day09.Day9Part1;
import days.day09.Day9Part2;
import days.day10.Day10Part1;
import days.day10.Day10Part2;
import days.day11.Day11Part1;
import days.day11.Day11Part2;
import days.day12.Day12Part1;
import days.day12.Day12Part2;
import days.day13.Day13Part1;
import days.day13.Day13Part2;

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
        if(day == 6) {
            if(part == 1) new Day6Part1();
            if(part == 2) new Day6Part2();
        }
        if(day == 7) {
            if(part == 1) new Day7Part1();
            if(part == 2) new Day7Part2();
        }
        if(day == 8) {
            if(part == 1) new Day8Part1();
            if(part == 2) new Day8Part2();
        }
        if(day == 9) {
            if(part == 1) new Day9Part1();
            if(part == 2) new Day9Part2();
        }
        if(day == 10) {
            if(part == 1) new Day10Part1();
            if(part == 2) new Day10Part2();
        }
        if(day == 11) {
            if(part == 1) new Day11Part1();
            if(part == 2) new Day11Part2();
        }
        if(day == 12) {
            if(part == 1) new Day12Part1();
            if(part == 2) new Day12Part2();
        }
        if(day == 13) {
            if(part == 1) new Day13Part1();
            if(part == 2) new Day13Part2();
        }
    }
}
