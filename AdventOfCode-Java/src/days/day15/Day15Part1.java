package days.day15;

import lib.ReadInput;

public class Day15Part1 {

    public Day15Part1() {

        ReadInput readInput = new ReadInput();
        String[] input = readInput.input.split(";");
        int highest = Integer.MIN_VALUE;

        for (int i = 0; i <= 100; i++) {
            String[] splitA = input[0].split(" ");
            for (int j = 0; j <= 100; j++) {
                String[] splitB = input[1].split(" ");
                for (int k = 0; k <= 100; k++) {
                    String[] splitC = input[2].split(" ");
                    for (int l = 0; l <= 100; l++) {
                        String[] splitD = input[3].split(" ");
                        if(i + j + k + l == 100) {
                            int capacity = (Integer.parseInt(splitA[2].substring(0, splitA[2].length() - 1)) * i) + (Integer.parseInt(splitB[2].substring(0, splitB[2].length() - 1)) * j) + (Integer.parseInt(splitC[2].substring(0, splitC[2].length() - 1)) * k) + (Integer.parseInt(splitD[2].substring(0, splitD[2].length() - 1)) * l);
                            int durability = (Integer.parseInt(splitA[4].substring(0, splitA[4].length() - 1)) * i) + (Integer.parseInt(splitB[4].substring(0, splitB[4].length() - 1)) * j) + (Integer.parseInt(splitC[4].substring(0, splitC[4].length() - 1)) * k) + (Integer.parseInt(splitD[4].substring(0, splitD[4].length() - 1)) * l);
                            int flavor = (Integer.parseInt(splitA[6].substring(0, splitA[6].length() - 1)) * i) + (Integer.parseInt(splitB[6].substring(0, splitB[6].length() - 1)) * j) + (Integer.parseInt(splitC[6].substring(0, splitC[6].length() - 1)) * k) + (Integer.parseInt(splitD[6].substring(0, splitD[6].length() - 1)) * l);
                            int texture = (Integer.parseInt(splitA[8].substring(0, splitA[8].length() - 1)) * i) + (Integer.parseInt(splitB[8].substring(0, splitB[8].length() - 1)) * j) + (Integer.parseInt(splitC[8].substring(0, splitC[8].length() - 1)) * k) + (Integer.parseInt(splitD[8].substring(0, splitD[8].length() - 1)) * l);
                            int addAll;
                            if(capacity > 0 && durability > 0 && flavor > 0 && texture > 0) {
                                addAll = capacity * durability * flavor * texture;
                            }
                            else {
                                addAll = 0;
                            }
                            if(addAll > highest) {
                                highest = addAll;
                            }
                        }
                        else if(i + j + k + l > 100) {
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(highest);
    }
}
