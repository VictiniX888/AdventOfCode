package aoc2015.days.day08;

import aoc2015.lib.ReadInput;

public class Day8Part2 {

    public Day8Part2() {

        ReadInput readInput = new ReadInput();

        String[] splitInput = readInput.input.split(";");
        int answer = 0;
        int oldInput = 0;

        for (int i = 0; i < splitInput.length; i++) {

            String newInput = splitInput[i];

            newInput = newInput.replaceAll("\\\\{2}", "aaaa");
            newInput = newInput.replaceAll("\\\\\"", "aaaa");
            newInput = newInput.replaceAll("\\\\x[0-9a-f][0-9a-f]", "aaaaa");
            newInput = newInput.replaceAll("\"", "aa");
            newInput = "a" + newInput + "a";

            oldInput += splitInput[i].length();
            answer += newInput.length();
        }

        System.out.println(answer - oldInput);
    }
}
