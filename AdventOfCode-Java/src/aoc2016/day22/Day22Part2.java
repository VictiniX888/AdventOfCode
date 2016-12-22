package aoc2016.day22;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day22Part2 {

    private static List<Pair<Integer, Integer>> visited = new ArrayList<>();
    private static int steps = 0;
    private static int foundData = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();
        String[] splitInput = input.split(";");

        int[][] grid = new int[Integer.parseInt(splitInput[splitInput.length-1].split("\\s+")[0].split("-")[1].substring(1)) + 1][Integer.parseInt(splitInput[splitInput.length-1].split("\\s+")[0].split("-")[2].substring(1)) + 1];
        Pair<Integer, Integer> pos = null;

        for (int i = 2; i < splitInput.length; i++) {
            String[] data = splitInput[i].split("\\s+");
            String[] filesystem = data[0].split("-");
            int x = Integer.parseInt(filesystem[1].substring(1));
            int y = Integer.parseInt(filesystem[2].substring(1));
            int size = Integer.parseInt(data[1].substring(0, data[1].length()-1));
            int used = Integer.parseInt(data[2].substring(0, data[2].length()-1));
            if (size > 100) {
                grid[x][y] = -1;
            }
            else if (used == 0) {
                grid[x][y] = 1;
                pos = new Pair<>(x, y);
            }
            else {
                grid[x][y] = 1;
            }
        }

        List<Pair<Integer, Integer>> moves = new ArrayList<>();
        moves.add(pos);
        visited.add(pos);
        bfs(moves, new Pair<>(Integer.parseInt(splitInput[splitInput.length-1].split("\\s+")[0].split("-")[1].substring(1)), 0), grid);
    }

    private static void bfs(List<Pair<Integer, Integer>> moves, Pair<Integer, Integer> data, int[][] grid) {

        List<Pair<Integer, Integer>> newMoves = new ArrayList<>();
        int dataX = data.getKey();
        int dataY = data.getValue();

        if (foundData == 0) {
            steps++;
            for (Pair<Integer, Integer> p : moves) {
                int posX = p.getKey();
                int posY = p.getValue();

                if (posX > 0) {
                    if (grid[posX - 1][posY] == 1 && !visited.contains(new Pair<>(posX - 1, posY))) {
                        if (posX - 1 == dataX - 1 && posY == dataY) {
                            foundData = 1;
                            break;
                        }
                        else {
                            newMoves.add(new Pair<>(posX - 1, posY));
                            visited.add(new Pair<>(posX - 1, posY));
                        }
                    }
                }
                if (posX < grid.length - 1) {
                    if (grid[posX + 1][posY] == 1 && !visited.contains(new Pair<>(posX + 1, posY))) {
                        if (posX + 1 == dataX - 1 && posY == dataY) {
                            foundData = 1;
                            break;
                        }
                        else {
                            newMoves.add(new Pair<>(posX + 1, posY));
                            visited.add(new Pair<>(posX + 1, posY));
                        }
                    }
                }
                if (posY > 0) {
                    if (grid[posX][posY - 1] == 1 && !visited.contains(new Pair<>(posX, posY - 1))) {
                        if (posX == dataX - 1 && posY - 1 == dataY) {
                            foundData = 1;
                            break;
                        }
                        else {
                            newMoves.add(new Pair<>(posX, posY - 1));
                            visited.add(new Pair<>(posX, posY - 1));
                        }
                    }
                }
                if (posY < grid[0].length - 1) {
                    if (grid[posX][posY + 1] == 1 && !visited.contains(new Pair<>(posX, posY + 1))) {
                        if (posX == dataX - 1 && posY + 1 == dataY) {
                            foundData = 1;
                            break;
                        }
                        else {
                            newMoves.add(new Pair<>(posX, posY + 1));
                            visited.add(new Pair<>(posX, posY + 1));
                        }
                    }
                }
            }

            bfs(newMoves, data, grid);
        }
        else if (foundData == 1) {
            steps += 1 + (5*(dataX-1));
            System.out.println(steps);
            System.exit(1);
        }
        else {
            System.out.println("ERROR");
        }
    }
}
