package aoc2015.days.day24;

import aoc2015.lib.ReadInput;

public class Day24Part2 {

    public Day24Part2() {

        ReadInput readInput = new ReadInput();
        String[] stringInput = readInput.input.split(";");

        int[] input = new int[stringInput.length];
        Boolean[] booleans = new Boolean[stringInput.length];
        int total = 0;
        int totalPresents = Integer.MAX_VALUE;
        long totalQE = Long.MAX_VALUE;

        for (int i = 0; i < input.length; i++) {
            input[i] = Integer.parseInt(stringInput[i]);
            booleans[i] = true;
            total += input[i];
        }

        int quarter = total / 4;

        while(true) {

            int weight = 0;
            int presents = 0;
            long qe = 1;
            for (int i = 0; i < input.length; i++) {
                if(booleans[i]) {
                    weight += input[i];
                    presents += 1;
                    qe *= input[i];
                }
            }

            if(weight == quarter) {
                if (presents < totalPresents) {
                    totalPresents = presents;
                    totalQE = qe;
                    System.out.println(totalQE);
                } else if (presents == totalPresents && qe < totalQE) {
                    totalQE = qe;
                    System.out.println(totalQE);
                }
            }

            for (int i = input.length - 1; i >= 0; i--) {
                if(booleans[i]) {
                    booleans[i] = false;
                    break;
                }
                else {
                    booleans[i] = true;
                }
            }
        }
    }
}
