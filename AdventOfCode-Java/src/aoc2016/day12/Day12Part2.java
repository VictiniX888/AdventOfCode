package aoc2016.day12;

import java.util.Scanner;

public class Day12Part2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();
        String[] splitInput = input.split(";");

        int[] registers = new int[4];
        registers[2] = 1;

        for (int i = 0; i < splitInput.length; i++) {
            String[] t = splitInput[i].split(" ");
            if(t[0].equals("cpy")) {
                registers[t[2].charAt(0)%97] = cpy(t[1], registers);
            }
            else if(t[0].equals("inc")) {
                registers[t[1].charAt(0)%97]++;
            }
            else if(t[0].equals("dec")) {
                registers[t[1].charAt(0)%97]--;
            }
            else if(t[0].equals("jnz")) {
                if(isInteger(t[1])) {
                    if(Integer.parseInt(t[1]) != 0) {
                        i = i + Integer.parseInt(t[2]) - 1;
                    }
                }
                else {
                    if(registers[t[1].charAt(0)%97] != 0) {
                        i = i + Integer.parseInt(t[2]) - 1;
                    }
                }
            }
        }

        System.out.println(registers[0]);
    }

    private static int cpy(String x, int[] r) {

        if(isInteger(x)) {
            return Integer.parseInt(x);
        }
        else {
            switch(x) {
                case "a" : return r[0];
                case "b" : return r[1];
                case "c" : return r[2];
                case "d" : return r[3];
                default : return 0;
            }
        }
    }

    private static boolean isInteger(String s) {

        boolean legit = true;

        for (char c : s.toCharArray()) {
            if(c < 48 || c > 57) {
                legit = false;
            }
        }

        return legit;
    }
}
