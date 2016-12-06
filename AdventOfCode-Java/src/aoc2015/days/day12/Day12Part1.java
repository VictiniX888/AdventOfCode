package aoc2015.days.day12;

import aoc2015.lib.ReadInput;

public class Day12Part1 {

    String input;

    public Day12Part1() {

        ReadInput readInput = new ReadInput();
        input = readInput.input;
        int answer = 0;

        for (int i = 1; i < input.length(); i++) {
            String number = "";
            int currentNumber = 0;
            if(!Character.toString(input.charAt(i - 1)).matches("[0-9]") && !Character.toString(input.charAt(i - 1)).equals("-")) {
                if(Character.toString(input.charAt(i)).equals("-")) {
                    number = number.concat(Character.toString(input.charAt(i)));
                    for (int j = i + 1; j < input.length(); j++) {
                        if(Character.toString(input.charAt(j)).matches("[0-9]")) {
                            number = number.concat(Character.toString(input.charAt(j)));
                        }
                        else {
                            break;
                        }
                    }
                    currentNumber = Integer.parseInt(number);
                }
                else if(Character.toString(input.charAt(i)).matches("[0-9]")) {
                    number = number.concat(Character.toString(input.charAt(i)));
                    for (int j = i + 1; j < input.length(); j++) {
                        if(Character.toString(input.charAt(j)).matches("[0-9]")) {
                            number = number.concat(Character.toString(input.charAt(j)));
                        }
                        else {
                            break;
                        }
                    }
                    currentNumber = Integer.parseInt(number);
                }

                answer += currentNumber;
            }
        }

        System.out.println(answer);
    }
}
