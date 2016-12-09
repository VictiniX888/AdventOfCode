package aoc2016.day09;

import java.util.Scanner;

public class Day9Part1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine().replaceAll(";| ", "");

        String decompressed = "";

        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '(') {
                String[] marker = input.substring(i+1).split("x|\\)");
                for (int j = 0; j < Integer.parseInt(marker[1]); j++) {
                    decompressed = decompressed.concat(input.substring(i+3+marker[0].length()+marker[1].length(), i+3+marker[0].length()+marker[1].length()+Integer.parseInt(marker[0])));
                }
                i += 3 + marker[0].length() + marker[1].length() + (Integer.parseInt(marker[0]) - 1);
            }
            else {
                decompressed = decompressed.concat(Character.toString(input.charAt(i)));
            }
        }

        System.out.println(decompressed.length());
    }
}
