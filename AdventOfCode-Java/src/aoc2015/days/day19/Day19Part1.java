package aoc2015.days.day19;

import aoc2015.lib.ReadInput;

import java.util.HashMap;
import java.util.Map;

public class Day19Part1 {

    public Day19Part1() {

        ReadInput readInput = new ReadInput();
        String[] stuff = readInput.input.split(";;");
        String[] replacements = stuff[0].split(";");
        String input = stuff[1];
        Map<String, Integer> molecules = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < replacements.length; j++) {

               String[] splitInput = replacements[j].split(" ");
                if(Character.toString(input.charAt(i)).equals(splitInput[0])) {
                    String str1 = input.substring(0, i);
                    String str2 = splitInput[2];
                    String str3 = input.substring(i+1);
                    String string = str1 + str2 + str3;
                    molecules.putIfAbsent(string, 1);
                }
                if(i < input.length() - 1) {
                    if ((Character.toString(input.charAt(i)) + Character.toString(input.charAt(i + 1))).equals(splitInput[0])) {
                        String str1 = input.substring(0, i);
                        String str2 = splitInput[2];
                        String str3 = input.substring(i + 2);
                        String string = str1 + str2 + str3;
                        molecules.putIfAbsent(string, 1);
                    }
                }
            }
        }

        System.out.println(molecules.size());
    }
}
