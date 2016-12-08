package aoc2016.day08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day8Part1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();
        String[] splitInput = input.split(";");

        boolean[][] screen = new boolean[50][6];

        for (String s : splitInput) {
            String[] params = s.split(" ");

            if(params[0].equals("rect")) {
                screen = rect(screen, Integer.parseInt(params[1].split("x")[0]), Integer.parseInt(params[1].split("x")[1]));
            }
            else if(params[1].equals("row")) {
                screen = row(screen, Integer.parseInt(params[2].substring(2)), Integer.parseInt(params[4]));
            }
            else if(params[1].equals("column")) {
                screen = column(screen, Integer.parseInt(params[2].substring(2)), Integer.parseInt(params[4]));
            }
        }

        int count = 0;
        for (boolean[] bArray : screen) {
            for (boolean b : bArray) {
                if(b) {count++;}
            }
        }

        System.out.println(count);
    }

    private static boolean[][] rect(boolean[][] screen, int a, int b) {

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                screen[i][j] = true;
            }
        }

        return screen;
    }

    private static boolean[][] row(boolean[][] screen, int a, int b) {

        List<Integer> on = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            if(screen[i][a]) {
                on.add(i);
                screen[i][a] = false;
            }
        }
        for (int i : on) {
            screen[(i+b)%50][a] = true;
        }

        return screen;
    }

    private static boolean[][] column(boolean[][] screen, int a, int b) {

        List<Integer> on = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            if(screen[a][i]) {
                on.add(i);
                screen[a][i] = false;
            }
        }
        for (int i : on) {
            screen[a][(i+b)%6] = true;
        }

        return screen;
    }
}
