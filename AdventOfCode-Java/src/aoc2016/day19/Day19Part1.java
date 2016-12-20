package aoc2016.day19;

import java.util.Scanner;

public class Day19Part1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        int input = Integer.parseInt(scanner.nextLine());

        int[] circle = new int[input];
        for (int i = 0; i < circle.length; i++) {
            circle[i] = i+1;
        }

        int output = elephant(circle);
        System.out.println(output);
    }

    private static int elephant(int[] circle) {

        int[] newCircle;
        int answer;

        if(circle.length % 2 == 0) {
            newCircle = new int[circle.length/2];
            for (int i = 0; i < newCircle.length; i++) {
                newCircle[i] = circle[i*2];
            }
        }
        else {
            newCircle = new int[(circle.length - 1)/2];
            for (int i = 0; i < newCircle.length; i++) {
                newCircle[i] = circle[(i*2)+2];
            }
        }

        if(newCircle.length > 1) {
            answer = elephant(newCircle);
        }
        else {
            answer = newCircle[0];
        }

        return answer;
    }
}
