package aoc2016.day13;

import javafx.util.Pair;

import java.util.*;

public class Day13Part1 {

    private static final int XDEST = 31;
    private static final int YDEST = 39;
    private static final Pair<Integer, Integer> start = new Pair<>(1, 1);
    private static int[][] maze = new int[50][50];  // 1 = open space ; 0 = wall ; 2 = destination
    private static List<Pair<Integer, Integer>> moves = new ArrayList<>();
    private static Set<Pair<Integer, Integer>> visited = new HashSet<>();
    private static int steps = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        int input = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < maze.length; i++) {        // i = x
            for (int j = 0; j < maze[i].length; j++) { // j = y
                String binary = Integer.toBinaryString(i*i + 3*i + 2*i*j + j + j*j + input);
                int ones = 0;
                for (char c : binary.toCharArray()) {
                    if(c == '1') {
                        ones++;
                    }
                }
                if(ones % 2 == 0) {
                    maze[i][j] = 1;
                }
            }
        }

        maze[XDEST][YDEST] = 2;

        moves.add(start);
        visited.add(start);
        bfs();
    }

    private static void bfs() {

        steps++;
        List<Pair<Integer, Integer>> newMoves = new ArrayList<>();

        for (int i = 0; i < moves.size(); i++) {
            Pair<Integer, Integer> currentMove = moves.get(i);
            int x = currentMove.getKey();
            int y = currentMove.getValue();
            if(x > 0) {
                if(maze[x-1][y] == 1 && !visited.contains(new Pair<>(x - 1, y))) {
                    newMoves.add(new Pair<>(x - 1, y));
                    visited.add(new Pair<>(x - 1, y));
                }
                else if(maze[x-1][y] == 2) {
                    System.out.println(steps);
                    System.exit(1);
                }
            }
            if(x < maze.length) {
                if(maze[x+1][y] == 1 && !visited.contains(new Pair<>(x + 1, y))) {
                    newMoves.add(new Pair<>(x + 1, y));
                    visited.add(new Pair<>(x + 1, y));
                }
                else if(maze[x+1][y] == 2) {
                    System.out.println(steps);
                    System.exit(1);
                }
            }
            if(y > 0) {
                if(maze[x][y-1] == 1 && !visited.contains(new Pair<>(x, y - 1))) {
                    newMoves.add(new Pair<>(x, y - 1));
                    visited.add(new Pair<>(x, y - 1));
                }
                else if(maze[x][y-1] == 2) {
                    System.out.println(steps);
                    System.exit(1);
                }
            }
            if(y < maze[x].length) {
                if(maze[x][y+1] == 1 && !visited.contains(new Pair<>(x, y + 1))) {
                    newMoves.add(new Pair<>(x, y + 1));
                    visited.add(new Pair<>(x, y + 1));
                }
                else if(maze[x][y+1] == 2) {
                    System.out.println(steps);
                    System.exit(1);
                }
            }
        }

        if(newMoves.size() == 0) {
            System.exit(-1);
        }
        moves = newMoves;
        bfs();
    }
}
