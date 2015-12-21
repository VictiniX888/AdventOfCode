package days.day20;

import lib.ReadInput;

public class Day20Part1 {

    public Day20Part1() {

        ReadInput readInput = new ReadInput();
        int input = Integer.parseInt(readInput.input);
        int[] houses = new int[input/10];

        for (int i = 1; i < input / 10; i++) {
            for (int j = i; j < input / 10; j += i) {
                houses[j] += i * 10;
            }
        }

        for (int i = 0; i < houses.length; i++) {
            if(houses[i] >= input) {
                System.out.println(i);
                break;
            }
        }
    }
}
