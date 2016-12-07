package aoc2016.day06;

import java.util.Scanner;

public class Day6Part1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();
        String[] splitInput = input.split(";");

        String output = "";

        for (int i = 0; i < splitInput[0].length(); i++) {
            int[] alphaCount = new int[26];
            for (String s : splitInput) {
                alphaCount[s.charAt(i)-97]++;
            }

            int largest = 0;
            int alphaLargest = 0;
            for (int j = 0; j < alphaCount.length; j++) {
                if(alphaCount[j] > largest) {
                    largest = alphaCount[j];
                    alphaLargest = j;
                }
            }

            output = output.concat(Character.toString((char)(alphaLargest+97)));
        }

        System.out.println(output);
    }
}
