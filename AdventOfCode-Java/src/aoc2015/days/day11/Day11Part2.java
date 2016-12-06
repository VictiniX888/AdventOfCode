package aoc2015.days.day11;

import aoc2015.lib.ReadInput;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day11Part2 {

    String input;

    public Day11Part2() {

        ReadInput readInput = new ReadInput();
        input = readInput.input;

        increment();
        while(!validPassword(input)) {
            increment();
        }

        increment();
        while(!validPassword(input)) {
            increment();
        }

        System.out.println(input);
    }

    public boolean validPassword(String input) {

        boolean straightIncrease = false;
        boolean confusingChars = false;
        boolean pairs = false;

        char[] chars = input.toCharArray();
        for (int i = 0; i < input.length() - 2; i++) {
            char plus1 = ++chars[i];
            char plus2 = ++chars[i];
            if(chars[i+1] == plus1 && chars[i+2] == plus2) {
                straightIncrease = true;
            }
        }

        Pattern patternConfusing = Pattern.compile("[iol]");
        Matcher matcherConfusing = patternConfusing.matcher(input);
        if(matcherConfusing.find()) {
            confusingChars = true;
        }

        boolean pair1 = false;
        char pair = '0';
        chars = input.toCharArray();
        for (int i = 0; i < input.length() - 1; i++) {
            if(!pair1) {
                if (chars[i] == chars[i + 1]) {
                    pair = chars[i];
                    pair1 = true;
                }
            }
            else if(chars[i] != pair && chars[i] == chars[i + 1]) {
                pairs = true;
                break;
            }
        }

        if(straightIncrease && pairs && !confusingChars) {
            return true;
        }
        else {
            return false;
        }
    }

    public void increment() {

        char[] chars = input.toCharArray();
        if(chars[chars.length-1] != 'z') {
            chars[chars.length-1]++;
            input = new String(chars);
        }
        else {
            for (int i = chars.length - 2; i >= 0; i--) {
                chars[chars.length-1] = 'a';
                if(chars[i] != 'z') {
                    chars[i]++;
                    input = new String(chars);
                    break;
                }
                else {
                    chars[i] = 'a';
                }
            }
        }
    }
}
