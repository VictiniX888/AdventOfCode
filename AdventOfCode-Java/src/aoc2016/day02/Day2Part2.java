package aoc2016.day02;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day2Part2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();
        String[] splitInput = input.split(";");

        Map<Pair<Integer, Integer>, Character> keypadMap = new HashMap<>();
            keypadMap.put(new Pair<>(2, 0), '1');
            keypadMap.put(new Pair<>(1, 1), '2');
            keypadMap.put(new Pair<>(2, 1), '3');
            keypadMap.put(new Pair<>(3, 1), '4');
            keypadMap.put(new Pair<>(0, 2), '5');
            keypadMap.put(new Pair<>(1, 2), '6');
            keypadMap.put(new Pair<>(2, 2), '7');
            keypadMap.put(new Pair<>(3, 2), '8');
            keypadMap.put(new Pair<>(4, 2), '9');
            keypadMap.put(new Pair<>(1, 3), 'A');
            keypadMap.put(new Pair<>(2, 3), 'B');
            keypadMap.put(new Pair<>(3, 3), 'C');
            keypadMap.put(new Pair<>(2, 4), 'D');

        Pair<Integer, Integer> lastPos = new Pair<>(0, 2);
        String answer = "";

        for (int i = 0; i < splitInput.length; i++) {
            char[] directions = splitInput[i].toCharArray();
            int x = lastPos.getKey();
            int y = lastPos.getValue();

            for (int j = 0; j < directions.length; j++) {
                switch(directions[j]) {
                    case 'U' :
                        if(keypadMap.containsKey(new Pair<>(x, y-1))) {y -= 1; break;}
                        else {break;}
                    case 'D' :
                        if(keypadMap.containsKey(new Pair<>(x, y+1))) {y += 1; break;}
                        else {break;}
                    case 'L' :
                        if(keypadMap.containsKey(new Pair<>(x-1, y))) {x -= 1; break;}
                        else {break;}
                    case 'R' :
                        if(keypadMap.containsKey(new Pair<>(x+1, y))) {x += 1; break;}
                        else {break;}
                }
            }

            lastPos = new Pair<>(x, y);
            answer = answer.concat(keypadMap.get(lastPos).toString());
        }

        System.out.println(answer);
    }
}
