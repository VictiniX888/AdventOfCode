package days;

import java.util.Scanner;

public class Day1Part2 {

    private int answer;

    public Day1Part2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.next();
        char[] charArray = input.toCharArray();
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
