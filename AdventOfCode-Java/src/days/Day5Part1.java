package days;

import lib.MessageRemoveLinebreak;

import java.util.Scanner;

public class Day5Part1 {

    public Day5Part1() {

        Scanner scanner = new Scanner(System.in);
        new MessageRemoveLinebreak();
        System.out.print("Input: ");
        String input = scanner.next();

        String[] splitInput = input.split(",");
        String[] twoSplitInput;
        char[] splitVowel;
        boolean vowelPass;
        boolean doublePass;
        boolean specialPass;
        int vowelCount;
        int answer = 0;

        for (int i = 0; i < splitInput.length; i++) {
            vowelPass = false;
            doublePass = false;
            specialPass = true;
            vowelCount = 0;
            splitVowel = splitInput[i].toCharArray();
            for (int j = 0; j < splitVowel.length; j++) {
                if(splitVowel[j] == 'a' || splitVowel[j] == 'e' || splitVowel[j] == 'i' || splitVowel[j] == 'o' || splitVowel[j] == 'u') {
                    vowelCount++;
                }
                if(vowelCount == 3) {
                    vowelPass = true;
                    break;
                }
            }

            if(vowelPass) {
                for (int j = 0; j < splitInput[i].length() - 1; j++) {
                    twoSplitInput = splitInput[i].substring(j, j + 2).split("");
                    if (twoSplitInput[0].equals(twoSplitInput[1])) {
                        doublePass = true;
                        break;
                    }
                }

                if(doublePass) {

                    for (int j = 0; j < splitInput[i].length() - 1; j++) {
                        twoSplitInput = splitInput[i].substring(j, j + 2).split("");
                        if ((twoSplitInput[0].equals("a") && twoSplitInput[1].equals("b")) ||
                                (twoSplitInput[0].equals("c") && twoSplitInput[1].equals("d")) ||
                                (twoSplitInput[0].equals("p") && twoSplitInput[1].equals("q")) ||
                                (twoSplitInput[0].equals("x") && twoSplitInput[1].equals("y"))) {
                            specialPass = false;
                            break;
                        }
                    }

                    if (specialPass) {
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
