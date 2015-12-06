package days;

import lib.ReadInput;

public class Day6Part1 {

    public Day6Part1() {

        ReadInput readInput = new ReadInput();
        int answer = 0;

        int[][] ints = new int[1000][1000];
        String[] splitInput = readInput.input.split(";");

        for (int i = 0; i < splitInput.length; i++) {
            if(splitInput[i].substring(0, 7).equals("turn on")) {
                turnOn(splitInput[i], ints);
            }

            if(splitInput[i].substring(0,6).equals("toggle")) {
                toggle(splitInput[i], ints);
            }

            if(splitInput[i].substring(0,8).equals("turn off")) {
                turnOff(splitInput[i], ints);
            }
        }

        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                if(ints[i][j] == 1) {
                    answer++;
                }
            }
        }

        System.out.println("Day 6 Part 1 answer: " + answer);
    }

    public void turnOn(String s, int[][] ints) {

        String subS = s.substring(8);
        String[] subSA = subS.split(" through ");
        String[][] subSB = new String[subSA.length][];

        subSB[0] = subSA[0].split(",");
        subSB[1] = subSA[1].split(",");
        int xStart = Integer.parseInt(subSB[0][0]);
        int yStart = Integer.parseInt(subSB[0][1]);
        int xEnd = Integer.parseInt(subSB[1][0]);
        int yEnd = Integer.parseInt(subSB[1][1]);

        for (int j = xStart; j <= xEnd; j++) {
            for (int k = yStart; k <= yEnd; k++) {
                ints[j][k] = 1;
            }
        }
    }

    public void toggle(String s, int[][] ints) {

        String subS = s.substring(7);
        String[] subSA = subS.split(" through ");
        String[][] subSB = new String[subSA.length][];

        subSB[0] = subSA[0].split(",");
        subSB[1] = subSA[1].split(",");
        int xStart = Integer.parseInt(subSB[0][0]);
        int yStart = Integer.parseInt(subSB[0][1]);
        int xEnd = Integer.parseInt(subSB[1][0]);
        int yEnd = Integer.parseInt(subSB[1][1]);

        for (int j = xStart; j <= xEnd; j++) {
            for (int k = yStart; k <= yEnd; k++) {
                if(ints[j][k] == 0) {
                    ints[j][k] = 1;
                }
                else {
                    ints[j][k] = 0;
                }
            }
        }
    }

    public void turnOff(String s, int[][] ints) {

        String subS = s.substring(9);
        String[] subSA = subS.split(" through ");
        String[][] subSB = new String[subSA.length][];

        subSB[0] = subSA[0].split(",");
        subSB[1] = subSA[1].split(",");
        int xStart = Integer.parseInt(subSB[0][0]);
        int yStart = Integer.parseInt(subSB[0][1]);
        int xEnd = Integer.parseInt(subSB[1][0]);
        int yEnd = Integer.parseInt(subSB[1][1]);

        for (int j = xStart; j <= xEnd; j++) {
            for (int k = yStart; k <= yEnd; k++) {
                ints[j][k] = 0;
            }
        }
    }
}
