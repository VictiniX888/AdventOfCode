package aoc2016.day10;

import java.util.Arrays;
import java.util.Scanner;

public class Day10Part2 {

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
        int[] output = new int[210];
        Arrays.fill(output, -1);

        for (String s : splitInput) {
            String[] split2Input = s.split(" ");
            if (split2Input[0].equals("value")) {
                if (bots[Integer.parseInt(split2Input[5])][0] == -1) {
                    bots[Integer.parseInt(split2Input[5])][0] = Integer.parseInt(split2Input[1]);
                } else {
                    bots[Integer.parseInt(split2Input[5])][1] = Integer.parseInt(split2Input[1]);
                }
            } else {
                for (int i = 0; i < 2; i++) {
                    if (split2Input[i * 5 + 5].equals("bot")) {
                        botOut[Integer.parseInt(split2Input[1])][i] = Integer.parseInt(split2Input[i * 5 + 6]);
                    } else {
                        botOut[Integer.parseInt(split2Input[1])][i] = Integer.parseInt(split2Input[i * 5 + 6]) + 210;
                    }
                }
            }
        }

        pants:
        while (true) {
            for (int i = 0; i < bots.length; i++) {
                if (bots[i][0] != -1 && bots[i][1] != -1) {
                    Arrays.sort(bots[i]);
                    if (output[0] != -1 && output[1] != -1 && output[2] != -1) {
                        System.out.println(output[0]*output[1]*output[2]);
                        break pants;
                    } else {
                        for (int j = 0; j < 2; j++) {
                            if (botOut[i][j] < 210) {
                                if (bots[botOut[i][j]][0] == -1) {
                                    bots[botOut[i][j]][0] = bots[i][j];
                                } else {
                                    bots[botOut[i][j]][1] = bots[i][j];
                                }
                            }
                            else {
                                output[botOut[i][j]%210] = bots[i][j];
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
