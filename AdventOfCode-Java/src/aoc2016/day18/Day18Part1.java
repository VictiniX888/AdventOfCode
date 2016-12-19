package aoc2016.day18;

import java.util.Scanner;

public class Day18Part1 {

    private static final int ROWS = 40;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();

        boolean[][] tiles = new boolean[ROWS][input.length()];   // false = safe ; true = trap
        int safeCount = 0;

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                if(i == 0) {
                    char c = input.charAt(j);
                    if(c == '^') {
                        tiles[i][j] = true;
                    }
                    else {
                        safeCount++;
                    }
                }
                else {
                    boolean left = false, centre = false, right = false;
                    if(j != 0) {
                        left = tiles[i-1][j-1];
                    }
                    centre = tiles[i-1][j];
                    if(j != tiles[i-1].length - 1) {
                        right = tiles[i-1][j+1];
                    }

                    if((left && centre && !right) || (!left && centre && right) || (left && !centre && !right) || (!left && !centre && right)) {
                        tiles[i][j] = true;
                    }
                    else {
                        safeCount++;
                    }
                }
            }
        }

        System.out.println(safeCount);
    }
}
