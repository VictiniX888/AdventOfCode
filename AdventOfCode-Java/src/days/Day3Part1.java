package days;

import java.awt.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day3Part1 {

    Set<Point> pointSet;

    public Day3Part1() {

        Point point = new Point(0,0);
        pointSet = new HashSet<>();

        pointSet.add(point.getLocation());

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.next();

        char[] charArray = input.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i] == '^') {
                point.translate(0,1);
            }
            else if(charArray[i] == 'v') {
                point.translate(0,-1);
            }
            else if(charArray[i] == '>') {
                point.translate(1,0);
            }
            else if(charArray[i] == '<') {
                point.translate(-1,0);
            }

            pointSet.add(point.getLocation());
        }

        System.out.println("Day 3 Part 1 answer: " + pointSet.toArray().length);
    }
}
