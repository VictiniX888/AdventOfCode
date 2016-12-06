package aoc2016.day01;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1Part2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();
        String[] inputs = input.split(", ");

        Point pos = new Point(0, 0);
        int face = 0;
        ArrayList<Point> points = new ArrayList<>();

        points.add(new Point(0, 0));

        pants:
        for (int i = 0; i < inputs.length; i++) {
            char turn = inputs[i].charAt(0);
            int steps = Integer.parseInt(inputs[i].substring(1));

            if(turn == 'R') {
                face++;
            }
            else {
                face--;
            }

            if(face == 4) {
                face = 0;
            }
            else if(face == -1) {
                face = 3;
            }

            for (int j = 0; j < steps; j++) {
                if(face == 0) {
                    pos.move(pos.x, pos.y + 1);
                }
                else if(face == 1) {
                    pos.move(pos.x + 1, pos.y);
                }
                else if(face == 2) {
                    pos.move(pos.x, pos.y-1);
                }
                else if(face == 3) {
                    pos.move(pos.x-1, pos.y);
                }
                else {
                    System.out.println("Error");
                }

                Point newPoint = (Point) pos.clone();
                if (points.contains(newPoint)) {
                    pos = newPoint;
                    break pants;
                }
                points.add(newPoint);
            }
        }

        int x = pos.x;
        int y = pos.y;

        if(x <= -1) {
            x = 0-x;
        }
        if(y <= -1) {
            y = 0-y;
        }

        System.out.println(x + y);
    }
}
