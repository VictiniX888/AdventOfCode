package days;

import lib.ReadInput;

public class Day1Part2 {

    private int answer;

    public Day1Part2() {

        ReadInput readInput = new ReadInput();
        char[] charArray = readInput.input.toCharArray();
        answer = 1;

        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i] == '(') {
                answer++;
            }
            else if(charArray[1] == ')') {
                answer--;
            }

            if(answer == -1) {
                System.out.println("Day 1 Part 2 answer: " + i);
                break;
            }
        }
    }
}
