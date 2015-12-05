package days;

import lib.MessageRemoveLinebreak;

import java.util.Scanner;

public class Day5Part2 {

    public Day5Part2() {

        Scanner scanner = new Scanner(System.in);
        new MessageRemoveLinebreak();
        System.out.print("Input: ");
        String input = scanner.next();

        String[] splitInput = input.split(",");
        String doubleString;
        String[] threeSplitInput;
        boolean doublePass;
        boolean splitPass;
        int answer = 0;

        for (int i = 0; i < splitInput.length; i++) {
            doublePass = false;
            splitPass = false;

            for (int j = 0; j < splitInput[i].length() - 1; j++) {
                doubleString = splitInput[i].substring(j, j + 2);
                if (splitInput[i].substring(j + 2).contains(doubleString)) {
                    doublePass = true;
                    break;
                }
            }

            if (doublePass) {
                for (int j = 0; j < splitInput[i].length() - 2; j++) {
                    threeSplitInput = splitInput[i].substring(j, j + 3).split("");
                    if (threeSplitInput[0].equals(threeSplitInput[2])) {
                        splitPass = true;
                        break;
                    }
                }

                if(splitPass) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
