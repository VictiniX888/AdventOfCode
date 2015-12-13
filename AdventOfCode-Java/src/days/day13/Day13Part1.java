package days.day13;

import javafx.util.Pair;
import lib.ReadInput;

import java.util.*;

public class Day13Part1 {

    public Day13Part1() {

        ReadInput readInput = new ReadInput();
        String[] input = readInput.input.split(";");
        String[] affected = new String[input.length];
        String[] affects = new String[input.length];
        int[] happiness = new int[input.length];
        Map<Pair<String, String>, Integer> map = new HashMap<>();
        int happiest = 0;

        for (int i = 0; i < input.length; i++) {
            String[] splitInput = input[i].split(" ");
            affected[i] = splitInput[0];
            affects[i] = splitInput[10].substring(0, splitInput[10].length() - 1);
            if(splitInput[2].equals("lose")) {
                splitInput[3] = "-" + splitInput[3];
                happiness[i] = Integer.parseInt(splitInput[3]);
            }
            else {
                happiness[i] = Integer.parseInt(splitInput[3]);
            }
        }

        for (int i = 0; i < input.length; i++) {
            switch (affected[i]) {
                case "Alice" : affected[i] = "A"; break;
                case "Bob" : affected[i] = "B"; break;
                case "Carol" : affected[i] = "C"; break;
                case "David" : affected[i] = "D"; break;
                case "Eric" : affected[i] = "E"; break;
                case "Frank" : affected[i] = "F"; break;
                case "George" : affected[i] = "G"; break;
                case "Mallory" : affected[i] = "H"; break;
            }
            switch (affects[i]) {
                case "Alice" : affects[i] = "A"; break;
                case "Bob" : affects[i] = "B"; break;
                case "Carol" : affects[i] = "C"; break;
                case "David" : affects[i] = "D"; break;
                case "Eric" : affects[i] = "E"; break;
                case "Frank" : affects[i] = "F"; break;
                case "George" : affects[i] = "G"; break;
                case "Mallory" : affects[i] = "H"; break;
            }
            map.put(new Pair<>(affected[i], affects[i]), happiness[i]);
        }

        Set<String> stringSet = permutation("ABCDEFGH");
        String[] strings = stringSet.toArray(new String[stringSet.size()]);

        for (int i = 0; i < strings.length; i++) {
            int answer = 0;
            for (int j = 1; j < strings[i].length() - 1; j++) {
                String left = strings[i].substring(j - 1, j + 1);
                answer += map.get(new Pair<>(left.substring(1), left.substring(0,1)));

                String right = strings[i].substring(j, j + 2);
                answer += map.get(new Pair<>(right.substring(0,1), right.substring(1)));
            }

            String left = Character.toString(strings[i].charAt(strings[i].length() - 1)) + Character.toString(strings[i].charAt(0));
            answer += map.get(new Pair<>(left.substring(1), left.substring(0,1)));
            String right = strings[i].substring(0, 2);
            answer += map.get(new Pair<>(right.substring(0,1), right.substring(1)));

            left = strings[i].substring(strings[i].length() - 2, strings[i].length());
            answer += map.get(new Pair<>(left.substring(1), left.substring(0, 1)));
            right = Character.toString(strings[i].charAt(strings[i].length() - 1)) + Character.toString(strings[i].charAt(0));
            answer += map.get(new Pair<>(right.substring(0,1), right.substring(1)));

            if(answer > happiest) {
                happiest = answer;
            }
        }

        System.out.println(happiest);
    }

    public static Set<String> permutation(String str) {
        Set<String> result = new HashSet<String>();
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            result.add("");
            return result;
        }

        char firstChar = str.charAt(0);
        String rem = str.substring(1);
        Set<String> words = permutation(rem);
        for (String newString : words) {
            for (int i = 0; i <= newString.length(); i++) {
                result.add(charAdd(newString, firstChar, i));
            }
        }
        return result;
    }

    public static String charAdd(String str, char c, int j) {
        String first = str.substring(0, j);
        String last = str.substring(j);
        return first + c + last;
    }
}
