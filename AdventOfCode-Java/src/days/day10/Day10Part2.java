package days.day10;

import lib.ReadInput;

public class Day10Part2 {

    public Day10Part2() {

        ReadInput readInput = new ReadInput();
        String input = readInput.input;

        for (int i = 0; i < 50; i++) {
            String newInput = "";
            for (int j = 0; j < input.length(); j++) {
                int count = 1;
                int number = Character.getNumericValue(input.charAt(j));
                for (int k = 1; k < input.length(); k++) {
                    if(j == 0) {
                        if (input.charAt(j) == input.charAt(j + k)) {
                            count++;
                        }
                        else {
                            newInput = newInput.concat(String.valueOf(count) + String.valueOf(number));
                            break;
                        }
                    }
                    else if(j + k <= input.length() - 1) {
                        if(input.charAt(j) == input.charAt(j - 1)) {
                            break;
                        }
                        else if (input.charAt(j) == input.charAt(j + k)) {
                            count++;
                        }
                        else {
                            newInput = newInput.concat(String.valueOf(count) + String.valueOf(number));
                            break;
                        }
                    }
                    else {
                        newInput = newInput.concat(String.valueOf(count) + String.valueOf(number));
                        break;
                    }
                }
            }
            input = newInput;
        }

        System.out.println(input.length());
    }
}
