package days.day17;

import lib.ReadInput;

import java.util.Arrays;

public class Day17Part2 {

    public Day17Part2() {

        ReadInput readInput = new ReadInput();
        String[] input = readInput.input.split(";");

        int[] inputs = new int[20];
        Boolean[] booleans = new Boolean[20];
        int count = 0;
        int least = Integer.MAX_VALUE;

        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = Integer.parseInt(input[i]);
            booleans[i] = true;
        }

        while(Arrays.asList(booleans).contains(true)) {

            int containers = 0;
            int total = 0;

            for (int i = 0; i < inputs.length; i++) {
                if(booleans[i]) {
                    total += inputs[i];
                    containers++;
                }
            }

            if(total == 150) {
                count++;
                if(containers < least) {
                    least = containers;
                }
            }

            for (int i = inputs.length - 1; i >= 0; i--) {
                if(booleans[i]) {
                    booleans[i] = false;
                    break;
                }
                else {
                    booleans[i] = true;
                }
            }
        }

        for (int i = 0; i < inputs.length; i++) {
            booleans[i] = true;
        }

        count = 0;
        while(Arrays.asList(booleans).contains(true)) {

            int containers = 0;
            int total = 0;

            for (int i = 0; i < inputs.length; i++) {
                if(booleans[i]) {
                    total += inputs[i];
                    containers++;
                }
            }

            if(total == 150 && containers == least) {
                count++;
            }

            for (int i = inputs.length - 1; i >= 0; i--) {
                if(booleans[i]) {
                    booleans[i] = false;
                    break;
                }
                else {
                    booleans[i] = true;
                }
            }
        }

        System.out.println(count);
    }
}
