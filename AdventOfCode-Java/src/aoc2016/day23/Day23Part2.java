package aoc2016.day23;

import java.util.Scanner;

public class Day23Part2 {

    private static final int INIT_A = 12;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();
        String[] splitInput = input.split(";");

        int[] registers = new int[4];
        registers[0] = INIT_A;

        for (int i = 0; i < splitInput.length; i++) {
            String[] t = splitInput[i].split(" ");
            if(t[0].equals("cpy")) {
                if (!isInteger(t[2])) {
                    registers[t[2].charAt(0) % 97] = cpy(t[1], registers);
                }
            }
            else if(t[0].equals("inc")) {
                if(!isInteger(t[1])) {
                    registers[t[1].charAt(0) % 97]++;
                }
            }
            else if(t[0].equals("dec")) {
                if (!isInteger(t[1])) {
                    registers[t[1].charAt(0) % 97]--;
                }
            }
            else if(t[0].equals("jnz")) {
                if(isInteger(t[1])) {
                    if(Integer.parseInt(t[1]) != 0) {
                        if(isInteger(t[2])) {
                            i = i + Integer.parseInt(t[2]) - 1;
                        }
                        else {
                            i = i + registers[t[2].charAt(0)%97] - 1;
                        }
                    }
                }
                else {
                    if(registers[t[1].charAt(0)%97] != 0) {
                        if(isInteger(t[2])) {
                            i = i + Integer.parseInt(t[2]) - 1;
                        }
                        else {
                            i = i + registers[t[2].charAt(0)%97] - 1;
                        }
                    }
                }
            }
            else if(t[0].equals("tgl")) {
                if(isInteger(t[1])) {
                    if (Integer.parseInt(t[1]) + i < splitInput.length && Integer.parseInt(t[1]) + i >= 0) {
                        splitInput[Integer.parseInt(t[1]) + i] = tgl(splitInput[Integer.parseInt(t[1]) + i]);
                    }
                }
                else {
                    if(registers[t[1].charAt(0)%97] + i < splitInput.length && registers[t[1].charAt(0)%97] + i >= 0) {
                        splitInput[registers[t[1].charAt(0)%97] + i] = tgl(splitInput[registers[t[1].charAt(0)%97] + i]);
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

    private static String tgl(String x) {

        String[] toToggle =  x.split(" ");

        switch (toToggle[0]) {
            case "inc": return "dec " + toToggle[1];
            case "dec": case "tgl": return "inc " + toToggle[1];
            case "jnz": return "cpy " + toToggle[1] + " " + toToggle[2];
            default: return "jnz " + toToggle[1] + " " + toToggle[2];
        }

    }

    private static boolean isInteger(String s) {

        boolean legit = true;

        for (char c : s.toCharArray()) {
            if((c < 48 || c > 57) && c != 45) {
                legit = false;
            }
        }

        return legit;
    }
}
