package days;

import lib.ReadInput;

public class Day2Part2 {

    public Day2Part2() {

        int small1 = 0;
        int small2 = 0;
        int answer = 0;

        ReadInput readInput = new ReadInput();
        String[] splitInput = readInput.input.split(";");
        for (int i = 0; i < splitInput.length; i++) {
            String[] splitSortedInput = splitInput[i].split("x");
            int l = Integer.parseInt(splitSortedInput[0]);
            int w = Integer.parseInt(splitSortedInput[1]);
            int h = Integer.parseInt(splitSortedInput[2]);

            int volume = l*w*h;
            small1 = l;
            if(w <= small1) {
                small2 = small1;
                small1 = w;
            }
            if(h <= small1 || h <= small2) {
                small2 = h;
            }
            if(w > small1 && h > small1) {
                small2 = Math.min(w, h);
            }

            int total = small1 + small1 + small2 + small2 + volume;
            answer = answer + total;
        }

        System.out.println("Day 2 Part 2 answer: " + answer);
    }
}
