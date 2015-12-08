package days.day08;

import lib.ReadInput;

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
            newInput = newInput.replaceAll("\\\\x..", "aaaaa");
            newInput = newInput.replaceAll("\"", "aa");
            newInput = "a" + newInput + "a";

            System.out.println(newInput);

            oldInput += splitInput[i].length();
            answer += newInput.length();
        }

        System.out.println(answer - oldInput);
    }
}
