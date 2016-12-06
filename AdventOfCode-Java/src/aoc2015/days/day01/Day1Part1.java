package aoc2015.days.day01;

import aoc2015.lib.ReadInput;

public class Day1Part1 {

    private int answer;

    public Day1Part1() {

        ReadInput readInput = new ReadInput();
        char[] charArray = readInput.input.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i] == '(') {
                answer++;
            }
            else if(charArray[i] == ')') {
                answer--;
            }
        }

        System.out.println("Day 1 Part 1 answer: " + answer);
    }
}
