package aoc2015.days.day25;

import java.util.Scanner;

public class Day25Part2 {

    public Day25Part2() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("How many stars do you have?");
        System.out.print("Number of stars: ");
        int stars = scanner.nextInt();
        if(stars == 49 || stars == 50) {
            System.out.println("Well, congratulations! (I hope you did not get all your answers from here)");
        }
        else if(stars < 49 && stars > 0) {
            System.out.println("You should complete the other puzzles first");
        }
        else if(stars == 0) {
            System.out.println("Do the other puzzles :P");
        }
        else {
            System.out.println("Um... what?");
        }
    }
}
