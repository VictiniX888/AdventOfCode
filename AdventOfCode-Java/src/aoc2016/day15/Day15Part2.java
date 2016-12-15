package aoc2016.day15;

import java.util.Scanner;

public class Day15Part2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: "); // split by ':'
        String input = scanner.nextLine();
        String[] splitInput = input.split(":");

        int[][] positions = new int[splitInput.length + 1][2];
        int time = 0;

        for (int i = 0; i < splitInput.length; i++) {
            String[] sSplit = splitInput[i].split("\\s|\\.");
            positions[i][0] = Integer.parseInt(sSplit[3]);
            positions[i][1] = (Integer.parseInt(sSplit[11]) + i + 1) % positions[i][0];
        }

        positions[splitInput.length][0] = 11;
        positions[splitInput.length][1] = (splitInput.length + 1) % 11;

        while(!canPress(positions)) {
            for (int i = 0; i < positions.length; i++) {
                positions[i][1]++;
                positions[i][1] %= positions[i][0];
            }

            time++;
        }

        System.out.println(time);
    }

    private static boolean canPress(int[][] pos) {

        boolean legit = true;

        for (int[] p : pos) {
            if (p[1] != 0) {
                legit = false;
                break;
            }
        }

        return legit;
    }
}
