package aoc2019.day3;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day3 {

    public static void main(String[] args) {

        String input1 = null;
        String input2 = null;

        try {
            FileReader fileReader = new FileReader(new File("src/aoc2019/day3/input3"));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            input1 = bufferedReader.readLine();
            input2 = bufferedReader.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        String[] inputArray1 = input1.split(",");
        String[] inputArray2 = input2.split(",");

        Scanner scanner = new Scanner(System.in);
        int part = scanner.nextInt();

        if (part == 1) {
            System.out.println(getMinDistance(getIntersections(wireCoords(inputArray1), wireCoords(inputArray2))).orElse(-1));
        }
        else if (part == 2) {
            System.out.println(getMinSteps(getIntersections(wireCoords(inputArray1), wireCoords(inputArray2))).orElse(-1));
        }
        else {
            System.out.println("Invalid Part Number");
        }
    }

    private static OptionalInt getMinSteps(Map<Coordinate,Integer> coords) {

        return coords.values().stream().mapToInt(Integer::intValue).min();
    }

    private static OptionalInt getMinDistance(Map<Coordinate,Integer> coords) {

        return coords.keySet().stream().mapToInt(Day3::distance).min();
    }

    private static int distance(Coordinate coord) {

        return (Math.abs(coord.x) + Math.abs(coord.y));
    }

    private static Map<Coordinate,Integer> getIntersections(Map<Coordinate,Integer> coords1, Map<Coordinate,Integer> coords2) {

        Set<Coordinate> intersections = new HashSet<>(coords1.keySet());
        intersections.retainAll(coords2.keySet());
        Map<Coordinate,Integer> intersectionStepsMap = new HashMap<>();

        for (Coordinate coord : intersections) {
            intersectionStepsMap.put(coord, coords1.get(coord)+coords2.get(coord));
        }

        return intersectionStepsMap;
    }

    private static Map<Coordinate,Integer> wireCoords(String[] directions) {

        Map<Coordinate,Integer> coords = new HashMap<>();
        int x = 0;
        int y = 0;

        int totalSteps = 0;

        for (String direction : directions) {

            Pair<Character,Integer> parsedDirection = parseDirection(direction);
            Character relativeDirection = parsedDirection.getKey();
            int steps = parsedDirection.getValue();

            for (int i = 0; i < steps; i++) {

                totalSteps++;

                switch (relativeDirection) {
                    case 'U': y++; break;
                    case 'D': y--; break;
                    case 'L': x--; break;
                    case 'R': x++; break;
                }

                coords.putIfAbsent(new Coordinate(x, y), totalSteps);
            }
        }

        return coords;
    }

    private static Pair<Character,Integer> parseDirection(String direction) {

        return new Pair<>(direction.charAt(0), Integer.parseInt(direction.substring(1)));
    }
}

class Coordinate {

    int x;
    int y;

    public Coordinate(int x, int y) {

        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {

        return (obj instanceof Coordinate && ((Coordinate) obj).x == this.x && ((Coordinate) obj).y == this.y);
    }

    @Override
    public int hashCode() {
        //may lead to different coordinates having the same hashcode, but the prime is big enough that the hashcodes are spread out
        return (this.x*397 + this.y);
    }
}