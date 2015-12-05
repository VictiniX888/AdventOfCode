package days;

import java.util.Scanner;

public class Day1Part1 {

    private int answer;

    public Day1Part1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.next();
        char[] charArray = input.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i] == '(') {
                answer++;
            }
            else if(charArray[1] == ')') {
                answer--;
            }
        }

        System.out.println("Day 1 Part 1 answer: " + answer);
    }
}
