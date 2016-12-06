package aoc2015.days.day25;

import aoc2015.lib.ReadInput;

public class Day25Part1 {

    public Day25Part1() {

        ReadInput readInput = new ReadInput();
        int row = Integer.parseInt(readInput.input.split(" ")[16].substring(0, readInput.input.split(" ")[16].length() - 1));
        int column = Integer.parseInt(readInput.input.split(" ")[18].substring(0, readInput.input.split(" ")[18].length() - 1));
        long start = 20151125;
        long[][] grid = new long[10000][10000];
        grid[1][1] = start;

        int i = 1;
        int j = 1;
        i++;

        while(true) {

            if(i > 1 && j > 1) {
                grid[i][j] = grid[i+1][j-1] * 252533 % 33554393;
                if(i == row && j == column) {
                    System.out.println(grid[i][j]);
                    break;
                }
                i--;
                j++;
            }
            else if(i > 1 && j == 1) {
                grid[i][j] = grid[1][i-1] * 252533 % 33554393;
                i--;
                j++;
            }
            else if(i == 1 && j > 1) {
                grid[i][j] = grid[i+1][j-1] * 252533 % 33554393;
                i = j+1;
                j = 1;
            }
            else {
                System.out.println("Error");
                break;
            }
        }
    }
}
