package aoc2016.day02;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day2Part1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();
        String[] splitInput = input.split(";");

        Map<Pair<Integer, Integer>, Integer> keypadMap = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                keypadMap.put(new Pair<>(i, j), i + (j*3) + 1);
            }
        }
        Pair<Integer, Integer> lastPos = new Pair<>(1, 1);
        String answer = "";

        for (int i = 0; i < splitInput.length; i++) {
            char[] directions = splitInput[i].toCharArray();
            int x = lastPos.getKey();
            int y = lastPos.getValue();

            for (int j = 0; j < directions.length; j++) {
                switch(directions[j]) {
                    case 'U' : y -= 1; break;
                    case 'D' : y += 1; break;
                    case 'L' : x -= 1; break;
                    case 'R' : x += 1; break;
                }

                if(x <= -1) {
                    x = 0;
                }
                else if(x >= 3) {
                    x = 2;
                }
                if(y <= -1) {
                    y = 0;
                }
                else if(y >= 3) {
                    y = 2;
                }
            }

            lastPos = new Pair<>(x, y);
            answer = answer.concat(keypadMap.get(lastPos).toString());
        }

        System.out.println(answer);
    }
}
