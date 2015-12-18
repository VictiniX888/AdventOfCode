package days.day18;

import lib.ReadInput;

public class Day18Part2 {

    public Day18Part2() {

        ReadInput readInput = new ReadInput();
        String[] input = readInput.input.split(";");

        Boolean[][] initial = new Boolean[100][100];
        int answer = 0;

        for (int i = 0; i < initial.length; i++) {
            for (int j = 0; j < initial[i].length; j++) {
                if(input[i].charAt(j) == '#') {
                    initial[i][j] = true;
                }
                else if(input[i].charAt(j) == '.') {
                    initial[i][j] = false;
                }
            }
        }

        initial[0][0] = true;
        initial[0][99] = true;
        initial[99][99] = true;
        initial[99][0] = true;

        for (int i = 0; i < 100; i++) {
            Boolean[][] newGrid = new Boolean[100][100];

            for (int j = 0; j < initial.length; j++) {
                for (int k = 0; k < initial[j].length; k++) {
                    int count = 0;
                    if(j > 0) {
                        if(initial[j-1][k]) {
                            count++;
                        }
                        if(k > 0) {
                            if(initial[j-1][k-1]) {
                                count++;
                            }
                        }
                        if(k < 99) {
                            if(initial[j-1][k+1]) {
                                count++;
                            }
                        }
                    }
                    if(j < 99) {
                        if(initial[j+1][k]) {
                            count++;
                        }
                        if(k > 0) {
                            if(initial[j+1][k-1]) {
                                count++;
                            }
                        }
                        if(k < 99) {
                            if(initial[j+1][k+1]) {
                                count++;
                            }
                        }
                    }
                    if(k > 0) {
                        if(initial[j][k-1]) {
                            count++;
                        }
                    }
                    if(k < 99) {
                        if(initial[j][k+1]) {
                            count++;
                        }
                    }

                    if(j == 0 && k == 0) {
                        newGrid[j][k] = true;
                    }
                    else if(j == 0 && k == 99) {
                        newGrid[j][k] = true;
                    }
                    else if(j == 99 && k == 99) {
                        newGrid[j][k] = true;
                    }
                    else if(j == 99 && k == 0) {
                        newGrid[j][k] = true;
                    }
                    else if(initial[j][k]) {
                        if(count == 2 || count == 3) {
                            newGrid[j][k] = true;
                        }
                        else {
                            newGrid[j][k] = false;
                        }
                    }
                    else {
                        if(count == 3) {
                            newGrid[j][k] = true;
                        }
                        else {
                            newGrid[j][k] = false;
                        }
                    }
                }
            }

            initial = newGrid;
        }

        for (int i = 0; i < initial.length; i++) {
            for (int j = 0; j < initial[i].length; j++) {
                if(initial[i][j]) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
