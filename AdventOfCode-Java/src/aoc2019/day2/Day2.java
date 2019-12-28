package aoc2019.day2;

import javafx.util.Pair;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Day2 {

    public static void main(String[] args) {

        FileReader fileReader;
        BufferedReader bufferedReader;
        String input = null;

        try {
            fileReader = new FileReader(new File("src/aoc2019/day2/input2"));
            bufferedReader = new BufferedReader(fileReader);
            input = bufferedReader.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        int[] inputArray = Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        Scanner scanner = new Scanner(System.in);
        int part = scanner.nextInt();

        if (part == 1) {
            System.out.println(run(12, 2, inputArray)[0]);
        }
        else if (part == 2) {
            Pair<Integer, Integer> answer = findNounVerb(19690720, inputArray);
            System.out.println(answer.getKey()*100 + answer.getValue());
        }
        else {
            System.out.println("Invalid Part Number");
        }
    }

    private static Pair<Integer, Integer> findNounVerb(int output, int[] program) {

        int noun = 0;
        int verb = 0;

        outer:
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {

                if (run(i, j, program.clone())[0] == output) {
                    noun = i;
                    verb = j;
                    break outer;
                }
            }
        }

        return new Pair<>(noun, verb);
    }

    private static int[] run(int noun, int verb, int[] program) {

        program[1] = noun;
        program[2] = verb;

        outer:
        for (int i = 0; i < program.length; ) {

            switch (program[i]) {

                case(1):  sum(i, program); i += 4; break;
                case(2):  multiply(i, program); i += 4; break;
                case(99): /* i += 1; */ break outer;
                default:  break outer;
            }
        }

        return program;
    }

    private static void sum(int pos, int[] program) {

        program[program[pos+3]] = program[program[pos+1]] + program[program[pos+2]];
    }

    private static void multiply(int pos, int[] program) {

        program[program[pos+3]] = program[program[pos+1]] * program[program[pos+2]];
    }
}
