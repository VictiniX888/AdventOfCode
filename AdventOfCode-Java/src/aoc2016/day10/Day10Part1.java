package aoc2016.day10;

import java.util.*;

public class Day10Part1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();
        String[] splitInput = input.split(";");

        int[][] bots = new int[210][2];
        for (int i = 0; i < bots.length; i++) {
            bots[i][0] = -1;
            bots[i][1] = -1;
        }
        int[][] botOut = new int[210][2];

        for (String s : splitInput) {
            String[] split2Input = s.split(" ");
            if (split2Input[0].equals("value")) {
                if(bots[Integer.parseInt(split2Input[5])][0] == -1) {
                    bots[Integer.parseInt(split2Input[5])][0] = Integer.parseInt(split2Input[1]);
                }
                else {
                    bots[Integer.parseInt(split2Input[5])][1] = Integer.parseInt(split2Input[1]);
                }
            }
            else {
                for (int i = 0; i < 2; i++) {
                    if(split2Input[i*5+5].equals("bot")) {
                        botOut[Integer.parseInt(split2Input[1])][i] = Integer.parseInt(split2Input[i*5+6]);
                    }
                    else {
                        botOut[Integer.parseInt(split2Input[1])][i] = -1;
                    }
                }
            }
        }

        pants:
        while(true) {
            for (int i = 0; i < bots.length; i++) {
                if(bots[i][0] != -1 && bots[i][1] != -1) {
                    Arrays.sort(bots[i]);
                    if(bots[i][0] == 17 && bots[i][1] == 61) {
                        System.out.println(i);
                        break pants;
                    }
                    else {
                        for (int j = 0; j < 2; j++) {
                            if(botOut[i][j] != -1) {
                                if(bots[botOut[i][j]][0] == -1) {
                                    bots[botOut[i][j]][0] = bots[i][j];
                                }
                                else {
                                    bots[botOut[i][j]][1] = bots[i][j];
                                }
                            }
                            bots[i][j] = -1;
                        }
                    }
                    break;
                }
            }
        }
    }
}
