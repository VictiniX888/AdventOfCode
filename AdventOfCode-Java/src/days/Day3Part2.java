package days;

import lib.ReadInput;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Day3Part2 {

    Set<Point> pointSet;

    public Day3Part2() {

        Point pointSanta = new Point(0,0);
        Point pointRobo = new Point(0,0);
        pointSet = new HashSet<>();

        pointSet.add(pointSanta.getLocation());

        ReadInput readInput = new ReadInput();
        char[] charArray = readInput.input.toCharArray();

        //Santa
        for (int i = 0; i < charArray.length; i+=2) {
            if(charArray[i] == '^') {
                pointSanta.translate(0,1);
            }
            else if(charArray[i] == 'v') {
                pointSanta.translate(0,-1);
            }
            else if(charArray[i] == '>') {
                pointSanta.translate(1,0);
            }
            else if(charArray[i] == '<') {
                pointSanta.translate(-1,0);
            }

            pointSet.add(pointSanta.getLocation());
        }

        //Robo-Santa
        for (int i = 1; i < charArray.length; i+=2) {
            if(charArray[i] == '^') {
                pointRobo.translate(0,1);
            }
            else if(charArray[i] == 'v') {
                pointRobo.translate(0,-1);
            }
            else if(charArray[i] == '>') {
                pointRobo.translate(1,0);
            }
            else if(charArray[i] == '<') {
                pointRobo.translate(-1,0);
            }

            pointSet.add(pointRobo.getLocation());
        }

        System.out.println("Day 3 Part 2 answer: " + pointSet.toArray().length);
    }
}
