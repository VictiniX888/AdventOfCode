package aoc2015.days.day20;

import aoc2015.lib.ReadInput;

public class Day20Part2 {

    public Day20Part2() {

        ReadInput readInput = new ReadInput();
        int input = Integer.parseInt(readInput.input);
        int[] houses = new int[input/10];

        for (int i = 1; i < input / 10; i++) {
            for (int j = i; j < input / 10; j += i) {
                houses[j] += i * 11;
                if(j == i * 50) {
                    break;
                }
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
