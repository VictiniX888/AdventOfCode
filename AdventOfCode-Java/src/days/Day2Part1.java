package days;

import lib.MessageRemoveLinebreak;

import java.util.Scanner;

public class Day2Part1 {


    public Day2Part1() {

        int answer = 0;

        Scanner scanner = new Scanner(System.in);
        new MessageRemoveLinebreak();
        System.out.print("Input: ");
        String input = scanner.next();
        String[] splitInput = input.split(",");
        for (int i = 0; i < splitInput.length; i++) {
            String[] splitSortedInput = splitInput[i].split("x");
            int l = Integer.parseInt(splitSortedInput[0]);
            int w = Integer.parseInt(splitSortedInput[1]);
            int h = Integer.parseInt(splitSortedInput[2]);

            int surface = 2*l*w + 2*w*h + 2*h*l;
            int face1 = l*w;
            int face2 = w*h;
            int face3 = h*l;

            int small = Math.min(face1, Math.min(face2, face3));

            int total = surface + small;
            answer = answer + total;
        }

        System.out.println("Day 2 Part 1 answer: " + answer);
    }
}
