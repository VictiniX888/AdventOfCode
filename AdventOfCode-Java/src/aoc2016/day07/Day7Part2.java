package aoc2016.day07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day7Part2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();
        String[] splitInput = input.split(";");

        int count = 0;

        for (String s : splitInput) {
            List<String> aba = new ArrayList<>();
            String[] split2Input = s.split("\\[|\\]");
            for (int i = 0; i < split2Input.length; i+=2) {
                for (int j = 0; j < split2Input[i].length() - 2; j++) {
                    String a = Character.toString(split2Input[i].charAt(j));
                    String b = Character.toString(split2Input[i].charAt(j+1));
                    if(split2Input[i].substring(j, j+3).equals(a+b+a) && !a.equals(b)) {
                        aba.add(a+b+a);
                    }
                }
            }

            if(!aba.isEmpty()) {
                pants2:
                for (int i = 1; i < split2Input.length; i+=2) {
                    for (String t : aba) {
                        String a = Character.toString(t.charAt(0));
                        String b = Character.toString(t.charAt(1));
                        for (int j = 0; j < split2Input[i].length() - 2; j++) {
                            if (split2Input[i].substring(j, j+3).equals(b+a+b)) {
                                count++;
                                break pants2;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}
