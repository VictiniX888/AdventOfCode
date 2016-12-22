package aoc2016.day22;

import java.util.Scanner;

public class Day22Part1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();
        String[] splitInput = input.split(";");

        int pairs = 0;

        for (int i = 2; i < splitInput.length; i++) {
            String[] sSplit = splitInput[i].split("\\s+");
            int used = Integer.parseInt(sSplit[2].substring(0, sSplit[2].length()-1));
            for (int j = 2; j < splitInput.length; j++) {
                if(i != j) {
                    String[] tSplit = splitInput[j].split("\\s+");
                    int avail = Integer.parseInt(tSplit[3].substring(0, tSplit[3].length()-1));
                    if(used != 0 && used <= avail) {
                        pairs++;
                    }
                }
            }
        }

        System.out.println(pairs);
    }
}
