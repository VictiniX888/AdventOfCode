package aoc2016.day03;

import java.util.Scanner;

public class Day3Part1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();

        String[] splitInput = input.split(";");

        int count = 0;

        for (int i = 0; i < splitInput.length; i++) {
            String[] sides = splitInput[i].split("\\s+");

            int side1 = Integer.parseInt(sides[1]);
            int side2 = Integer.parseInt(sides[2]);
            int side3 = Integer.parseInt(sides[3]);
            int largest;

            if(side1 > side2) {largest = side1;}
            else {largest = side2;}
            if(side3 > largest) {largest = side3;}

            if(-(largest - side1 - side2 - side3) > largest) {
                count++;
            }
        }

        System.out.println(count);
    }
}
