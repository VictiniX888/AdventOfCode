package days.day09;

import javafx.util.Pair;
import lib.ReadInput;

import java.util.*;

public class Day9Part2 {

    public Day9Part2() {

        ReadInput readInput = new ReadInput();
        String[] input = readInput.input.split(";");
        String[] from = new String[input.length*2];
        String[] to = new String[input.length*2];
        int[] distance = new int[input.length*2];
        Map<Pair<String, String>, Integer> map = new HashMap<>();
        int longest = 0;

        for (int i = 0; i < input.length; i++) {
            String[] splitInput = input[i].split(" ");
            from[i*2] = splitInput[0];
            to[i*2] = splitInput[2];
            distance[i*2] = Integer.parseInt(splitInput[4]);
            from[i*2+1] = splitInput[2];
            to[i*2+1] = splitInput[0];
            distance[i*2+1] = Integer.parseInt(splitInput[4]);
        }

        for (int i = 0; i < input.length * 2; i++) {
            switch (from[i]) {
                case "Faerun" : from[i] = "A"; break;
                case "Tristram" : from[i] = "B"; break;
                case "Tambi" : from[i] = "C"; break;
                case "Norrath" : from[i] = "D"; break;
                case "Snowdin" : from[i] = "E"; break;
                case "Straylight" : from[i] = "F"; break;
                case "AlphaCentauri" : from[i] = "G"; break;
                case "Arbre" : from[i] = "H"; break;
            }
            switch (to[i]) {
                case "Faerun" : to[i] = "A"; break;
                case "Tristram" : to[i] = "B"; break;
                case "Tambi" : to[i] = "C"; break;
                case "Norrath" : to[i] = "D"; break;
                case "Snowdin" : to[i] = "E"; break;
                case "Straylight" : to[i] = "F"; break;
                case "AlphaCentauri" : to[i] = "G"; break;
                case "Arbre" : to[i] = "H"; break;
            }
            map.put(new Pair<>(from[i], to[i]), distance[i]);
        }

        Set<String> stringSet = permutation("ABCDEFGH");
        String[] strings = stringSet.toArray(new String[stringSet.size()]);

        for (int i = 0; i < stringSet.size(); i++) {
            int answer = 0;
            for (int j = 0; j < strings[i].length() - 1; j++) {
                String subString = strings[i].substring(j, j + 2);
                answer += map.get(new Pair<>(subString.substring(0,1), subString.substring(1)));
            }
            if(answer > longest) {
                longest = answer;
            }
        }

        System.out.println(longest);
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
