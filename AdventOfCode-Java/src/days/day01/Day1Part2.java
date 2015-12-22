package days.day01;

import lib.ReadInput;

public class Day1Part2 {

    private int answer;

    public Day1Part2() {

        ReadInput readInput = new ReadInput();
        char[] charArray = readInput.input.toCharArray();
        answer = 0;

        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i] == '(') {
                answer++;
            }
            else if(charArray[i] == ')') {
                answer--;
            }

            if(answer == -1) {
                System.out.println("Day 1 Part 2 answer: " + (i + 1));
                break;
            }
        }
    }
}
