package aoc2016.day24;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day24Part2 {

    private static int leastSteps = Integer.MAX_VALUE;
    private static Pair<Integer, Integer> startPos = null;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();
        String[] splitInput = input.split(";");

        int[][] grid = new int[splitInput.length][splitInput[0].length()];
        int points = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(splitInput[i].charAt(j) == '#') {
                    grid[i][j] = -1;  // wall
                }
                else if(splitInput[i].charAt(j) == '.') {
                    grid[i][j] = -2;  // space
                }
                else if(splitInput[i].charAt(j) == '0') {
                    grid[i][j] = 0;
                    startPos = new Pair<>(i, j);  // start pos
                }
                else {
                    grid[i][j] = Integer.parseInt(Character.toString(splitInput[i].charAt(j)));   // points
                    points++;
                }
            }
        }

        String pointsString = "";
        for (int i = 1; i <= points; i++) {
            pointsString = pointsString.concat(Integer.toString(i));
        }
        Set<String> paths = permutation(pointsString);

        for (String path : paths) {
            path = path.concat("0");
            Set<Pair<Integer, Integer>> moves = new HashSet<>();
            Set<Pair<Integer, Integer>> visited = new HashSet<>();
            if(startPos != null) {
                moves.add(startPos);
                visited.add(startPos);
            }
            int[][] newGrid = Arrays.stream(grid).map(int[]::clone).toArray(int[][]::new);
            int steps = bfs(path, 0, moves, visited, newGrid);
            if(steps < leastSteps) {
                leastSteps = steps;
                System.out.println(leastSteps);
            }
        }

        System.out.println(leastSteps);
    }

    private static int bfs(String path, int steps, Set<Pair<Integer, Integer>> moves, Set<Pair<Integer, Integer>> visited, int[][] grid) {

        int newSteps = -1;
        steps++;
        Set<Pair<Integer, Integer>> newMoves = new HashSet<>();
        int nextPoint = Integer.parseInt(Character.toString(path.charAt(0)));

        for (Pair<Integer, Integer> move : moves) {
            int y = move.getKey();
            int x = move.getValue();
            if(grid[y+1][x] != -1) {
                if(grid[y+1][x] == nextPoint) {
                    if(path.length() > 1) {
                        newMoves.clear();
                        newMoves.add(new Pair<>(y+1, x));
                        visited.clear();
                        grid[y+1][x] = -2;
                        newSteps = bfs(path.substring(1), steps, newMoves, visited, grid);
                    }
                    else {
                        newSteps = steps;
                        visited.clear();
                    }
                    break;
                }
                else if((grid[y+1][x] == -2 || grid[y+1][x] == 0) && !visited.contains(new Pair<>(y+1, x))) {
                    newMoves.add(new Pair<>(y+1, x));
                    visited.add(new Pair<>(y+1, x));
                }
            }
            if(grid[y-1][x] != -1) {
                if(grid[y-1][x] == nextPoint) {
                    if(path.length() > 1) {
                        newMoves.clear();
                        newMoves.add(new Pair<>(y-1, x));
                        visited.clear();
                        grid[y-1][x] = -2;
                        newSteps = bfs(path.substring(1), steps, newMoves, visited, grid);
                    }
                    else {
                        newSteps = steps;
                        visited.clear();
                    }
                    break;
                }
                else if((grid[y-1][x] == -2 || grid[y-1][x] == 0) && !visited.contains(new Pair<>(y-1, x))) {
                    newMoves.add(new Pair<>(y-1, x));
                    visited.add(new Pair<>(y-1, x));
                }
            }
            if(grid[y][x+1] != -1) {
                if(grid[y][x+1] == nextPoint) {
                    if(path.length() > 1) {
                        newMoves.clear();
                        newMoves.add(new Pair<>(y, x+1));
                        visited.clear();
                        grid[y][x+1] = -2;
                        newSteps = bfs(path.substring(1), steps, newMoves, visited, grid);
                    }
                    else {
                        newSteps = steps;
                        visited.clear();
                    }
                    break;
                }
                else if((grid[y][x+1] == -2 || grid[y][x+1] == 0) && !visited.contains(new Pair<>(y, x+1))) {
                    newMoves.add(new Pair<>(y, x+1));
                    visited.add(new Pair<>(y, x+1));
                }
            }
            if(grid[y][x-1] != -1) {
                if(grid[y][x-1] == nextPoint) {
                    if(path.length() > 1) {
                        newMoves.clear();
                        newMoves.add(new Pair<>(y, x-1));
                        visited.clear();
                        grid[y][x-1] = -2;
                        newSteps = bfs(path.substring(1), steps, newMoves, visited, grid);
                    }
                    else {
                        newSteps = steps;
                        visited.clear();
                    }
                    break;
                }
                else if((grid[y][x-1] == -2 || grid[y][x-1] == 0) && !visited.contains(new Pair<>(y, x-1))) {
                    newMoves.add(new Pair<>(y, x-1));
                    visited.add(new Pair<>(y, x-1));
                }
            }
        }

        if(newSteps > -1) {
            return newSteps;
        }
        else if(newMoves.size() == 0) {
            return Integer.MAX_VALUE;
        }
        else {
            return bfs(path, steps, newMoves, visited, grid);
        }
    }

    private static Set<String> permutation(String str) {
        Set<String> result = new HashSet<>();
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            result.add("");
            return result;
        }

        char firstChar = str.charAt(0);
        String rem = str.substring(1);
        Set<String> words = permutation(rem);
        for (String newString : words) {
            for (int i = 0; i <= newString.length(); i++) {
                result.add(charAdd(newString, firstChar, i));
            }
        }
        return result;
    }

    private static String charAdd(String str, char c, int j) {
        String first = str.substring(0, j);
        String last = str.substring(j);
        return first + c + last;
    }
}
