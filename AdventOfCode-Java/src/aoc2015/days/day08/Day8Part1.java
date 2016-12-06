package aoc2015.days.day08;

import aoc2015.lib.ReadInput;

public class Day8Part1 {

    public Day8Part1() {

        ReadInput readInput = new ReadInput();

        String[] splitInput = readInput.input.split(";");
        int answer = 0;
        int oldInput = 0;

        for (int i = 0; i < splitInput.length; i++) {

            String newInput = splitInput[i];

            newInput = newInput.replaceAll("\\\\{2}", "a");
            newInput = newInput.replaceAll("\\\\\"", "a");
            newInput = newInput.replaceAll("\\\\x[0-9a-f][0-9a-f]", "a");
            newInput = newInput.replaceAll("\"", "");

            oldInput += splitInput[i].length();
            answer += newInput.length();
        }

        System.out.println(oldInput - answer);
    }
}
