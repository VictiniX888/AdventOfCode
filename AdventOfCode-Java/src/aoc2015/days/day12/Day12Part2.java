package aoc2015.days.day12;

import aoc2015.lib.ReadInput;

public class Day12Part2 {

    String input;
    int answer;

    public Day12Part2() {

        ReadInput readInput = new ReadInput();
        input = readInput.input;
        answer = 0;

        removeRed();
        for (int i = 1; i < input.length(); i++) {
            findNumber(i);
        }

        System.out.println(answer);
    }

    public int findOpeningBracket(int i) {

        int charPos = -1;
        int countCurly = 0;
        for (int j = i; j >= 0; j--) {
            if(Character.toString(input.charAt(j)).equals("}")) {
                countCurly++;
            }
            else if(Character.toString(input.charAt(j)).equals("{")) {
                countCurly--;
            }
            if(countCurly == -1) {
                charPos = j;
                break;
            }
        }

        return charPos;
    }

    public int findClosingBracket(int i) {

        int charPos = -1;
        int countCurly = 0;
        for (int j = i; j < input.length(); j++) {
            if(Character.toString(input.charAt(j)).equals("{")) {
                countCurly++;
            }
            else if(Character.toString(input.charAt(j)).equals("}")) {
                countCurly--;
            }
            if(countCurly == -1) {
                charPos = j;
                break;
            }
        }

        return charPos;
    }

    public void removeRed() {

        int i = input.indexOf(":\"red\"");
        while(i != -1 && findOpeningBracket(i) != -1 && findClosingBracket(i) != -1) {
            String firstHalf = input.substring(0, findOpeningBracket(i) + 1);
            String secondHalf = input.substring(findClosingBracket(i));
            input = firstHalf + secondHalf;
            i = input.indexOf(":\"red\"");
        }
    }

    public void findNumber(int i) {

        String number = "";
        int currentNumber = 0;
        if(!Character.toString(input.charAt(i - 1)).matches("[0-9]") && !Character.toString(input.charAt(i - 1)).equals("-")) {
            if(Character.toString(input.charAt(i)).equals("-")) {
                number = number.concat(Character.toString(input.charAt(i)));
                for (int j = i + 1; j < input.length(); j++) {
                    if(Character.toString(input.charAt(j)).matches("[0-9]")) {
                        number = number.concat(Character.toString(input.charAt(j)));
                    }
                    else {
                        break;
                    }
                }
                currentNumber = Integer.parseInt(number);
            }
            else if(Character.toString(input.charAt(i)).matches("[0-9]")) {
                number = number.concat(Character.toString(input.charAt(i)));
                for (int j = i + 1; j < input.length(); j++) {
                    if(Character.toString(input.charAt(j)).matches("[0-9]")) {
                        number = number.concat(Character.toString(input.charAt(j)));
                    }
                    else {
                        break;
                    }
                }
                currentNumber = Integer.parseInt(number);
            }

            answer += currentNumber;
        }
    }
}
