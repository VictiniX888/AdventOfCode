package days;

import lib.MessageRemoveLinebreak;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day5Part1 {

    public Day5Part1() {

        Scanner scanner = new Scanner(System.in);
        new MessageRemoveLinebreak();
        System.out.print("Input: ");
        String input = scanner.next();

        String[] splitInput = input.split(",");
        int answer = 0;

        for (int i = 0; i < splitInput.length; i++) {
            Pattern vowel = Pattern.compile("[aeiou]");
            Matcher vowelMatcher = vowel.matcher(splitInput[i]);
            int count = 0;
            while(vowelMatcher.find()) {
                count++;
            }

            Pattern doubles = Pattern.compile("([a-z])\\1");
            Matcher doublesMatcher = doubles.matcher(splitInput[i]);

            Pattern special = Pattern.compile("ab|cd|pq|xy");
            Matcher specialMatcher = special.matcher(splitInput[i]);

            if(count >= 3 && doublesMatcher.find() && !specialMatcher.find()) {
                answer++;
            }
        }

        System.out.println("Day 5 Part 1 answer: " + answer);
    }
}
