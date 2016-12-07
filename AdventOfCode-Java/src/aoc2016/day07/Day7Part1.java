package aoc2016.day07;

import java.util.Scanner;

public class Day7Part1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();
        String[] splitInput = input.split(";");

        int count = 0;

        for (String s : splitInput) {
            boolean tls = true;
            String[] split2Input = s.split("\\[|\\]");
            pants1:
            for (int i = 1; i < split2Input.length; i+=2) {
                for (int j = 0; j < split2Input[i].length() - 3; j++) {
                    String a = Character.toString(split2Input[i].charAt(j));
                    String b = Character.toString(split2Input[i].charAt(j+1));
                    if(split2Input[i].substring(j, j+4).equals(a+b+b+a) && !a.equals(b)) {tls = false; break pants1;}
                }
            }

            if(tls) {
                pants2:
                for (int i = 0; i < split2Input.length; i += 2) {
                    for (int j = 0; j < split2Input[i].length() - 3; j++) {
                        String a = Character.toString(split2Input[i].charAt(j));
                        String b = Character.toString(split2Input[i].charAt(j + 1));
                        if (split2Input[i].substring(j, j + 4).equals(a + b + b + a) && !a.equals(b)) {
                            count++;
                            break pants2;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}
