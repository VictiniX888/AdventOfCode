package days.day05;

import lib.ReadInput;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day5Part2 {

    public Day5Part2() {

        ReadInput readInput = new ReadInput();
        String[] splitInput = readInput.input.split(";");
        int answer = 0;

        for (int i = 0; i < splitInput.length; i++) {

            Pattern doubles = Pattern.compile("([a-z][a-z])[a-z]*\\1");
            Matcher doublesMatcher = doubles.matcher(splitInput[i]);

            Pattern repeat = Pattern.compile("([a-z]).\\1");
            Matcher repeatMatcher = repeat.matcher(splitInput[i]);

            if(doublesMatcher.find() && repeatMatcher.find()) {
                answer++;
            }
        }

        System.out.println("Day 5 Part 2 answer: " + answer);
    }
}
