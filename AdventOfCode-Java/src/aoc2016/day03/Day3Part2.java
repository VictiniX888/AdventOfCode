package aoc2016.day03;

import java.util.Scanner;

public class Day3Part2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();

        String[] splitInput = input.split(";");
        String[][] splitSplitInput = new String[splitInput.length][3];
        for (int i = 0; i < splitInput.length; i++) {
            String[] sides = splitInput[i].split("\\s+");
            splitSplitInput[i][0] = sides[1];
            splitSplitInput[i][1] = sides[2];
            splitSplitInput[i][2] = sides[3];
        }

        int count = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < splitInput.length - 2; j+=3) {
                int side1 = Integer.parseInt(splitSplitInput[j][i]);
                int side2 = Integer.parseInt(splitSplitInput[j+1][i]);
                int side3 = Integer.parseInt(splitSplitInput[j+2][i]);
                int largest;

                if(side1 > side2) {largest = side1;}
                else {largest = side2;}
                if(side3 > largest) {largest = side3;}

                if(-(largest - side1 - side2 - side3) > largest) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
